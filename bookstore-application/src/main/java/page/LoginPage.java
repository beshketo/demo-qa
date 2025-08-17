package page;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;


public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    final String LOGIN_PAGE_URL = baseurl + "/login";

    public void openPage() {
      openPage(LOGIN_PAGE_URL);
    }
    public boolean isLoginPageDisplayed() {
        return WebDriverRunner.url().equals(LOGIN_PAGE_URL);
    }


}
