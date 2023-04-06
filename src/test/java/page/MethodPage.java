package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodPage {
    WebDriver driver;

    public MethodPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Login(String elementId, String email) { // her seyi girdik bir tek maili girilcek bıraktık.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='login']")));
        driver.findElement(By.xpath("//button[@name='login']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));
        driver.findElement(By.xpath(elementId)).sendKeys(email);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password12.");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-primary mt-2']")));
        driver.findElement(By.xpath("//button[@class='btn btn-primary mt-2']")).click();
    }

    public void Wait(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));
    }

    public void FindElementClick(String elementId) {
        driver.findElement(By.xpath(elementId)).click();
    }

    public void FindElementWrite(String elementId, String generalText) {
        driver.findElement(By.xpath(elementId)).sendKeys(generalText);
    }

//    public void Notification(String elementId) { //sorun var hala çözülmediiiii
//        WebElement notificationElement = driver.findElement(By.xpath(elementId));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
//        wait.until(ExpectedConditions.visibilityOf(notificationElement));
//
//        String notificationText = notificationElement.getText();
//        System.out.println("Notification text: " + notificationText);
//
//        if (notificationText == "İşlem Başarılı") {
//            System.out.println("işlem başarılı");
//        } else {
//            System.out.println("İşlem Başarısız");
//        }
//
//    }

    public void NewRecord( String elementId, String name, String code) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-sm btn-success mb-1']")));
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-success mb-1']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='form-name']")));
        driver.findElement(By.xpath("//input[@name='form-name']")).sendKeys(name);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='description']")));
        driver.findElement(By.xpath("//input[@name='description']")).sendKeys(code);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='inputDefault']")));
        driver.findElement(By.xpath("//button[@id='inputDefault']")).click();

//NOTİFİCATİON
        WebElement notificationElement = driver.findElement(By.xpath("//div[@class='modal-body']/div[@class='Notification_container__3-29_ Notification_top-right__2vZt9']"));

        wait.until(ExpectedConditions.visibilityOf(notificationElement));

        String notificationText = notificationElement.getText();
        System.out.println("Notification text: " + notificationText);

        if (notificationText == "İşlem Başarılı") {
            System.out.println("işlem başarılı");
        } else {
            System.out.println("İşlem Başarısız");
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fas fa-times']")));
        driver.findElement(By.xpath("//i[@class='fas fa-times']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId))); //elementID detail olandan secicez commonXpath te
        driver.findElement(By.xpath(elementId)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fas fa-times']")));
        driver.findElement(By.xpath("//i[@class='fas fa-times']")).click();

    }

    public void Logout(String elementId) { //element ıd kullanmadan yazdıgımızda diger tarafta nasıl cagırıcaz?????????
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));
        driver.findElement(By.xpath(elementId)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Çıkış Yap']")));
        driver.findElement(By.xpath("//a[.='Çıkış Yap']")).click();
    }
}




