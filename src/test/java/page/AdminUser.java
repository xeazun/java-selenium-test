package page;

import org.openqa.selenium.WebDriver;

public class AdminUser extends MethodPage {
    public AdminUser(WebDriver driver) {
      super(driver);
    }

    // TABLER
    public final String adminUserToManage = "//span[.='Kullanıcıları Yönet']";
    public final String adminPayment = "//span[.='Ödeme Yöntemi']";
    public final String  adminCostCenter ="//span[.='Masraf Merkezi']";
    public final String  adminCurrency ="//span[.='Para Birimi']";

    // Tüm tablerde aynı
    public final String adminRecord = "//button[@class='btn btn-sm btn-success mb-1']"; // sanırım gerek kalmadı bir bak.
    public final String adminName = "//input[@name='form-name']"; //gerek kalmadı
    public final String adminCode = "//input[@name='description']"; //gerek kalmadı

    //Yeni kullanıcı kaydı
    public final String adminMail = "//form[@class='form-control-modern container-fluid form-control-lg']/div[2]//input[@id='inputDefault']";
    public final String adminFirstName = "//form[@class='form-control-modern container-fluid form-control-lg']/div[3]//input[@id='inputDefault']";
    public final String adminSaveLastName = "//div[4]//input[@id='inputDefault']";

}
