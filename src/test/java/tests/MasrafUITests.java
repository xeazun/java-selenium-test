package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import constants.AdminConstant;
import constants.CommonConstant;
import services.UITestService;
import constants.UserConstant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class MasrafUITests {
    private WebDriver _driver;
    private AdminConstant _adminConstant;
    private CommonConstant _commonConstant;
    private UserConstant _userConstant;

    private UITestService _uiTestService;


    @BeforeEach
    void setup() {
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        _adminConstant = new AdminConstant();
        _commonConstant = new CommonConstant();
        _userConstant = new UserConstant();
        _uiTestService = new UITestService(_driver);
    }

    @Test
    void oneHeartTest() throws InterruptedException {
        _driver.get("https://masraf-dev-front.azurewebsites.net/");

        int durationTime = 5;

        //ADMİN LOGİN
        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.admin@nttdata.com");

        //KULLANICI YÖNET

        _uiTestService.Wait(_adminConstant.userToManageSectionXpath, durationTime);
        _uiTestService.FindElementClick(_adminConstant.userToManageSectionXpath);
        _uiTestService.UserNewRecord("ezgi.admin@nttdata.com", "ezgi.admin@nttdata.com", "Ezgi", "Azun", durationTime);

        _uiTestService.Notification(durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);

//        //ÖDEME YÖNTEMİ

        _uiTestService.Wait(_adminConstant.paymentSectionXpath, durationTime);
        _uiTestService.FindElementClick(_adminConstant.paymentSectionXpath);
        _uiTestService.NewRecord("KREDI5", "KRD5", durationTime);
        _uiTestService.Notification(durationTime);
        _uiTestService.DetailSection(_commonConstant.showEighthRecordButtonXpath, durationTime);

//        //MASRAF MERKEZİ

        _uiTestService.Wait(_adminConstant.costCenterSectionXpath, durationTime);
        _uiTestService.FindElementClick(_adminConstant.costCenterSectionXpath);
        _uiTestService.NewRecord("Masraf Merkezi 5", "MER5", durationTime);
        _uiTestService.Notification(durationTime);
        _uiTestService.DetailSection(_commonConstant.showFiveRecordButtonXpath, durationTime);

//        //PARA BİRİMİ

        _uiTestService.Wait(_adminConstant.currencySectionXpath, durationTime);
        _uiTestService.FindElementClick(_adminConstant.currencySectionXpath);
        _uiTestService.NewRecord("STERLİN", "GBD", durationTime);
        _uiTestService.Notification(durationTime);
        _uiTestService.DetailSection(_commonConstant.showFourRecordButtonXpath, durationTime);

//        //LOGOUT

        _uiTestService.Logout(durationTime);


        //USER LOGİN
        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.user@nttdata.com");

//        //FİŞ EKLEME
        for (int i = 1; i <= 3; i++) { // randomları metot olarak topla.

            Random random = new Random();

            int tutar = random.nextInt((901) + 100);

            double kdvTutar = (tutar * (1 + (18.0 / 100.0))); // virgüllü kullanmam lazım onu nasıl yaparım ögren
            int kdvTutarint = (int) kdvTutar;

            int fisNo = random.nextInt((10) + 1);
            String stringFisNo = Integer.toString(fisNo);

            String[] kdv = {"1", "8", "18"};
            int randomIndex = random.nextInt(kdv.length);
            String randomKdv = kdv[randomIndex];

            String[] institution = {"Trendyol", "Opet", "Market", ",Getir", "Taksi"};
            int randomInstitution = random.nextInt(institution.length);
            String randomInstitutions = institution[randomInstitution];

            LocalDate currentDate = LocalDate.now();
            LocalDate startDate = currentDate.minusDays(5);
            LocalDate endDate = currentDate.plusDays(5);
            int randomDays = random.nextInt(endDate.getDayOfYear() - startDate.getDayOfYear()) + startDate.getDayOfYear();
            LocalDate randomDate = LocalDate.ofYearDay(currentDate.getYear(), randomDays);
            String formattedDate = randomDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            _uiTestService.DocumentSection("Test Fiş", stringFisNo, durationTime);
            _uiTestService.DropDownLastElement(_userConstant.documentCostCenterDropdownXpath, durationTime); // 3 kere olan seyi 1 kere yazabiliyor muyuz?
            _uiTestService.DropDownLastElement(_userConstant.documentPaymentMethodDropdownXpath, durationTime);
            _uiTestService.DropDownLastElement(_userConstant.documentCurrencyDropdownXpath, durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentAmountFieldXpath, Integer.toString(tutar));
            _uiTestService.FindElementWrite(_userConstant.documentVatRateFieldXpath, randomKdv);
            _uiTestService.FindElementWrite(_userConstant.documentVatAmountFieldXpath, Integer.toString(kdvTutarint));
            _uiTestService.FindElementWrite(_userConstant.documentExchangeRateFieldXpath, Integer.toString(random.nextInt((20) + 1)));
            _uiTestService.FindElementWrite(_userConstant.documentInstitutionFieldXpath, randomInstitutions);
            _uiTestService.FindElementWrite(_userConstant.documentIssuedDateFieldXpath, formattedDate);
            _uiTestService.FindElementWrite(_userConstant.documentDescriptionFieldXpath, UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
            _uiTestService.DocumentImageFileField();
            _uiTestService.FindElementClick(_commonConstant.modalSaveButtonXpath);
            _uiTestService.Notification(durationTime * 3);
            _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);
        }

        _uiTestService.Logout(durationTime);

        //APPROVER LOGİN

        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.approver@nttdata.com");
//
        //FİŞ ONAY/RED
        _uiTestService.Wait(_commonConstant.documentSectionXpath, durationTime * 2);
        _uiTestService.FindElementClick(_commonConstant.documentSectionXpath);

        for (int i = 0; i < 3; i++) {
            JavascriptExecutor js = (JavascriptExecutor) _driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight * " + i + ");"); // kodu UI test servise tası
            Thread.sleep(1000);

        }

        _uiTestService.DocumentApproveButton(_commonConstant.showSeventeenRecordButtonXpath, durationTime * 2);
        _uiTestService.DetailSection(_commonConstant.showSeventeenRecordButtonXpath, durationTime);

        _uiTestService.DocumentApproveButton(_commonConstant.showEighteenRecordButtonXpath, durationTime * 2);
        _uiTestService.DetailSection(_commonConstant.showEighteenRecordButtonXpath, durationTime);

        _uiTestService.DocumentRejectButton(_commonConstant.showNineteenRecordButtonXpath, durationTime * 2);
        _uiTestService.DetailSection(_commonConstant.showNineteenRecordButtonXpath, durationTime);

        JavascriptExecutor js = (JavascriptExecutor) _driver;
        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(1000);

        //LOGOUT

        _uiTestService.Logout(durationTime);

        //USER LOGİN

        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.user@nttdata.com");

        //FORM YARAT

        _uiTestService.Wait(_commonConstant.formSectionXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.formSectionXpath);

        _uiTestService.Wait(_commonConstant.createRecordXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.createRecordXpath);

        _uiTestService.Wait(_commonConstant.nameFieldXpath, durationTime);
        _uiTestService.FindElementWrite(_commonConstant.nameFieldXpath, "Test Form");

        _uiTestService.Wait(_commonConstant.codeFieldXpath, durationTime);
        _uiTestService.FindElementWrite(_commonConstant.codeFieldXpath, UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));

        _uiTestService.Wait(_commonConstant.modalSaveButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalSaveButtonXpath);

        _uiTestService.Wait(_commonConstant.notificationSuccessStateTextXpath, durationTime);
        _uiTestService.Notification(durationTime);

        _uiTestService.Wait(_commonConstant.modalCloseButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);

        _uiTestService.Wait(_commonConstant.showSevenRecordButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.showSevenRecordButtonXpath);

        _uiTestService.Wait(_userConstant.addDocumentToFormButtonXpath, durationTime);
        _uiTestService.FindElementClick(_userConstant.addDocumentToFormButtonXpath);

        _uiTestService.Wait(_userConstant.formDocumentDropdownXpath, durationTime);
        _uiTestService.DocumentDropDown(_userConstant.formDocumentDropdownXpath, durationTime * 2);


        _uiTestService.Wait(_commonConstant.modalCloseButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);

        _uiTestService.Wait(_commonConstant.showSevenRecordButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.showSevenRecordButtonXpath);

        _uiTestService.Wait(_userConstant.viewFormDocumentsButtonXpath, durationTime);
        _uiTestService.FindElementClick(_userConstant.viewFormDocumentsButtonXpath);

        _uiTestService.Wait(_commonConstant.modalCloseButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);

        // _uiTestService.Logout(durationTime);
    }


    @AfterEach
    void tearDown() throws InterruptedException {
//        Thread.sleep(1500);
//        _driver.close();
    }
}

