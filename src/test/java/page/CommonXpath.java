package page;

import org.openqa.selenium.WebDriver;

public class CommonXpath extends MethodPage {
    public CommonXpath(WebDriver driver){
        super(driver);
    }

    //LOGİN
    //public final String login = "//button[@name='login']";
    public final String loginMail = "//input[@name='email']";
   // public final String loginPassword = "//input[@name='password']";
   // public final String loginIn = "//button[@class='btn btn-primary mt-2']";

    //logout
    public final String logOut= "//i[@class='fa custom-caret']";
    //public final String closeButton = "//a[.='Çıkış Yap']";

    public final String inputDefault= "//button[@id='inputDefault']";
    public final String close = "//i[@class='fas fa-times']"; //close 3 sayfadada aynı
    public final String save = "//button[@id='inputDefault']";

    //Detail
    public final String detailSix= "//tr[6]//button[@class='btn btn-sm btn-info m-1']";
    public final String detailEight = "//tr[7]//button[@class='btn btn-sm btn-info m-1']";
    public final String detailFour = "//tr[3]//button[@class='btn btn-sm btn-info m-1']";
    public final String detailTwentyOne= "//tr[21]//button[@class='btn btn-sm btn-info m-1']"; // hepsinde ortak olduğu için kullanmak istediğin sayi ile değiştirebilirsin tek detayda yerterli olur i ekleyerek. buna bir bak tekrara gerek yok.

    //popup message
    public final String popupTrue = "//div[@class='modal-body']/div[@class='Notification_container__3-29_ Notification_top-right__2vZt9']";
    public final String popupFalse = "//div[@class='Notification_notification__JRxX2 Notification_toast__1RIns Notification_top-right__2vZt9']";
    public final String popupSpecialCharacter = "//div[@class='modal-body']/div[@class='Notification_container__3-29_ Notification_top-right__2vZt9']";
}