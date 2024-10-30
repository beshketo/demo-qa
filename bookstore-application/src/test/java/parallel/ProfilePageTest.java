package parallel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ithillel.test.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class ProfilePageTest {
    private LoginPage loginPage;
    private WebDriver driver;


    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
    }

    @Given("Open Profile page")
    public void openProfilePage() {
        open("https://demoqa.com/profile");
    }

    @When("The title is displayed on the profile page for unlogged-in user")
    public void checkTitleOnProfilePage() {
        Assert.assertTrue($("#notLoggin-label").isDisplayed(), "Title is not displayed for unlogged-in user");
    }

    @Then("Click the login link in text on page")
    public void clickOnLoginInText() {
        $x("//a[contains(@href, 'login')]").click();
        Configuration.timeout = 5000;
    }
    @When("Login Page is opened after clicking the link")
    public void checkLoginPageIsOpened() {
        loginPage = new LoginPage(driver);
        Configuration.timeout = 10000;
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not opened");
    }

    @When("Empty dashboard is opened for logged-in user")
    public void checkEmptyDashboardIsDisplayed(){
        boolean isDashboardIsVisible = $(".ReactTable").isDisplayed();
        Assert.assertTrue(isDashboardIsVisible,"Dashboard isn't displayed for logged in user");
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
