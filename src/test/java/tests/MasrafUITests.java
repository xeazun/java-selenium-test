package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.AdminUser;
import page.CommonXpath;
import page.MethodPage;

public class MasrafUITests {
    private WebDriver driver;
    private AdminUser adminUser;
    private CommonXpath commonXpath;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        adminUser = new AdminUser(driver);
        commonXpath = new CommonXpath(driver);

    }

    @Test
    void oneHeartTest() throws InterruptedException {
        driver.get("https://masraf-dev-front.azurewebsites.net/");

        //ADMİN LOGİN = metot haline getirip her login olduğunda bir kere cagırabilir miyiz? YES BEEEH

        commonXpath.Login(commonXpath.loginMail, "murat.admin@nttdata.com");

//        commonXpath.Wait(commonXpath.login);
//        commonXpath.FindElementClick(commonXpath.login);
//
//        commonXpath.Wait(commonXpath.loginMail);
//        commonXpath.FindElementWrite(commonXpath.loginMail, "murat.admin@nttdata.com");
//
//        commonXpath.Wait(commonXpath.loginPassword);
//        commonXpath.FindElementWrite(commonXpath.loginPassword, "Password12.");
//
//        commonXpath.Wait(commonXpath.loginIn);
//        commonXpath.FindElementClick(commonXpath.loginIn);

        //KULLANICI YÖNET

        adminUser.Wait(adminUser.adminUserToManage);
        adminUser.FindElementClick(adminUser.adminUserToManage);

        adminUser.Wait(adminUser.adminRecord);
        adminUser.FindElementClick(adminUser.adminRecord);

//        adminUser.Wait(adminUser.adminName);
//        adminUser.FindElementWrite(adminUser.adminName,"ezgi.admin@nttdata.com"); //8 denemeden 2 sini kaydetti 6sini kaydetmedi.

        adminUser.Wait(adminUser.adminMail);
        adminUser.FindElementWrite(adminUser.adminMail, "ezgi.admin@nttdata.com");

        adminUser.Wait(adminUser.adminFirstName);
        adminUser.FindElementWrite(adminUser.adminFirstName, "Ezgi");

        adminUser.Wait(adminUser.adminSaveLastName);
        adminUser.FindElementWrite(adminUser.adminSaveLastName, "Azun");

        commonXpath.Wait(commonXpath.save);
        commonXpath.FindElementClick(commonXpath.save);

//        commonXpath.Wait(commonXpath.popupTrue); //istediğim gibi çalışmıyor. istek tamamlandı mesqajını görmeden çıkıyor.
//        commonXpath.Notification(commonXpath.popupTrue);

        commonXpath.Wait(commonXpath.close);
        commonXpath.FindElementClick(commonXpath.close);

        //ÖDEME YÖNTEMİ

        adminUser.Wait(adminUser.adminPayment);
        adminUser.FindElementClick(adminUser.adminPayment);

        commonXpath.NewRecord(commonXpath.detailEight,"KREDI4","KRD4");

//        adminUser.Wait(adminUser.adminRecord);
//        adminUser.FindElementClick(adminUser.adminRecord);
//
////        adminUser.Wait(adminUser.adminName);
////        adminUser.FindElementWrite(adminUser.adminName,"KREDİ4");   //sıkıntı xpathte bulamıyor o kısımdakilerinde hep sıkıntı cıkartcak gibi
//
//        adminUser.Wait(adminUser.adminCode);
//        adminUser.FindElementWrite(adminUser.adminCode, "KRD4");
//
//        commonXpath.Wait(commonXpath.save);
//        commonXpath.FindElementClick(commonXpath.save);
//
////        commonXpath.Wait(commonXpath.popupTrue); //istediğim gibi çalışmıyor. istek tamamlandı mesqajını görmeden çıkıyor.
////        commonXpath.Notification(commonXpath.popupTrue);
//
//        commonXpath.Wait(commonXpath.close);
//        commonXpath.FindElementClick(commonXpath.close);
//
//        commonXpath.Wait(commonXpath.detailEight);
//        commonXpath.FindElementClick(commonXpath.detailEight);
//
//        commonXpath.Wait(commonXpath.close);
//        commonXpath.FindElementClick(commonXpath.close);   //çalışmıyor neden allahım neden

        //MASRAF MERKEZİ

        adminUser.Wait(adminUser.adminCostCenter);
        adminUser.FindElementClick(adminUser.adminCostCenter);

        commonXpath.NewRecord(commonXpath.detailFour,"Masraf Merkezi 4","MER4");

//        adminUser.Wait(adminUser.adminRecord);
//        adminUser.FindElementClick(adminUser.adminRecord);
//
//        adminUser.Wait(adminUser.adminName);
//        adminUser.FindElementWrite(adminUser.adminName, "Masraf Merkezi4");   //sıkıntı xpathte bulamıyor o kısımdakilerinde hep sıkıntı cıkartcak gibi
//
//        adminUser.Wait(adminUser.adminCode);
//        adminUser.FindElementWrite(adminUser.adminCode, "MER4");
//
//        commonXpath.Wait(commonXpath.save);
//        commonXpath.FindElementClick(commonXpath.save);
//
////        commonXpath.Wait(commonXpath.popupTrue); //istediğim gibi çalışmıyor. istek tamamlandı mesqajını görmeden çıkıyor.
////        commonXpath.Notification(commonXpath.popupTrue);
//
//        commonXpath.Wait(commonXpath.close);
//        commonXpath.FindElementClick(commonXpath.close);
//
//        commonXpath.Wait(commonXpath.detailFour);
//        commonXpath.FindElementClick(commonXpath.detailFour);
//
//        commonXpath.Wait(commonXpath.close);
//        commonXpath.FindElementClick(commonXpath.close);   //çalışmıyor neden allahım neden

        //PARA BİRİMİ

        adminUser.Wait(adminUser.adminCurrency);
        adminUser.FindElementClick(adminUser.adminCurrency);
        commonXpath.NewRecord(commonXpath.detailFour,"Sterlin","GBP");

//        adminUser.Wait(adminUser.adminRecord);
//        adminUser.FindElementClick(adminUser.adminRecord);
//
//        adminUser.Wait(adminUser.adminName);
//        adminUser.FindElementWrite(adminUser.adminName, "Masraf Merkezi4");   //sıkıntı xpathte bulamıyor o kısımdakilerinde hep sıkıntı cıkartcak gibi
//
//        adminUser.Wait(adminUser.adminCode);
//        adminUser.FindElementWrite(adminUser.adminCode, "MER4");
//
//        commonXpath.Wait(commonXpath.save);
//        commonXpath.FindElementClick(commonXpath.save);
//
////        commonXpath.Wait(commonXpath.popupTrue); //istediğim gibi çalışmıyor. istek tamamlandı mesqajını görmeden çıkıyor.
////        commonXpath.Notification(commonXpath.popupTrue);
//
//        commonXpath.Wait(commonXpath.detailFour);
//        commonXpath.FindElementClick(commonXpath.detailFour);
//
//        commonXpath.Wait(commonXpath.close);
//        commonXpath.FindElementClick(commonXpath.close);   //çalışmıyor neden allahım neden


        //LOGOUT
//        commonXpath.Wait(commonXpath.logOut);
//        commonXpath.FindElementClick(commonXpath.logOut);
//
//        commonXpath.Wait(commonXpath.closeButton);
//        commonXpath.FindElementClick(commonXpath.closeButton);
//        commonXpath.Logout(commonXpath.logOut);    // bunu baska sekilde yapmak mümkün mü?????????

        //USER LOGİN
        commonXpath.Login(commonXpath.loginMail, "murat.user@nttdata.com");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
//        Thread.sleep(1500);
//        driver.close();
    }
}

