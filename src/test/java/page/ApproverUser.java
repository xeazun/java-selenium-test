package page;

import org.openqa.selenium.WebDriver;

public class ApproverUser extends MethodPage {
    public ApproverUser(WebDriver driver) {
        super(driver);
    }

    public final String approveReject = "//button[@class='btn btn-sm btn-primary m-1 fw-bold']";
    public final String approve = "//button[@class='btn btn-sm btn-success m-1 text-4 fw-bold']";
    public final String reject ="//button[@class='btn btn-sm btn-danger m-1 text-4 fw-bold']";
}
