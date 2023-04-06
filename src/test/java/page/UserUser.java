package page;

import org.openqa.selenium.WebDriver;

public class UserUser extends MethodPage {
    public UserUser(WebDriver driver) {
        super(driver);
    }

    public final String createVoucher = "//a[@name='Fiş']";
    public final String newCreateVoucher = "//button[@class='btn btn-sm btn-success mb-1 dropdown-toggle']";
    public final String manuel = "//li[.='Manuel']";
    public final String voucherName = "//input[@name='document-name']";
    public final String voucherNo = "//input[@name='document-no']";
    public final String category = "//select[@name='category-code']";
    //dropdowlist kapanıyor onların içinden randon secmeyi bul.
    public final String costCenterCode = "//select[@name='costcenter-code']";
    //dropdowlist kapanıyor onların içinden son oluşturulanı seç secmeyi bul.
    public final String paymentMethodCode = "//select[@name='paymentmethod-code']";
    public final String currencyCode = "//select[@name='currency-code']";
    public final String amount = "//input[@name='amount']"; //random bir tutar olucak ama makul bir random tutar olacak.
    public final String vatAmount = "//input[@name='vat-amount']"; //random bir tutar olucak ama makul bir random tutar olacak.
    public final String exchangeRate = "//input[@name='exchange-rate']"; //random bir tutar olucak ama makul bir random tutar olacak.
    public final String institution = "//input[@name='institution']"; //bir dizi oluştur ordan random çek dizide 5 kurum adı olsun 3ü sana lazım.
    public final String issuedDate = "//input[@id='issued-date']"; // +5 -5 gün
    public final String description = "//input[@name='description']"; // UUID acıklama form içinde bu kullanılacak.
    public final String file = "//input[@name='file']"; // resim yükleme tek bir resim olsa yeterli
    public final String form = "//a[@name='Form']";
    public final String addReceipt = "//button[@class='btn btn-sm btn-tertiary m-1 fw-bold']";
    public final String userClose = "//button[@class='button close']";
    public final String receipt = "//select[@name='category-code']"; //açılır pencere ama xpath secemiyorum nasıl secım yapıcam ??
    public final String viewReceipt = "//button[@class='btn btn-sm btn-primary m-1 fw-bold']";

}
