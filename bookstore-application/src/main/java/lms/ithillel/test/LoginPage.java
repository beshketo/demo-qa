package lms.ithillel.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    final String LOGIN_PAGE_URL = baseurl + "/login";

    public void openPage() {
      openPage(LOGIN_PAGE_URL);
    }


}
