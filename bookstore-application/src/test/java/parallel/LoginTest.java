package parallel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ithillel.test.LoginPage;
import lms.ithillel.test.RegisterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;


public class LoginTest {

    private static LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 2000;
    }

    @Given("Open Login page")
    public void openLoginPage() {
        /*setUp();*/
        open("https://demoqa.com/login");
        executeJavaScript("arguments[0].scrollIntoView(true);", $("#newUser"));
    }

    @When("Fill out all fields with existing user data: {string}, {string}")
    @When("Fill out all fields with non-existing user data: {string}, {string}")
    public void FillOutData(String userName, String password) {
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        Configuration.timeout = 1000;
        $("#userName").setValue(userName);
        Configuration.timeout = 1000;
        $("#password").setValue(password);
    }

  /*  @When("Fill out all fields with non-existing user data: {string}, {string}")
    public void FillOutNonExistingName(String userName, String password) {
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        Configuration.timeout = 1000;
        $("#userName").setValue(userName);
        Configuration.timeout = 1000;
        $("#password").setValue(password);
    }*/

    @When("Click the Login button")
    public void clickLoginButton() {
        executeJavaScript("arguments[0].scrollIntoView(true);", $("#login"));
        $("#login").click();
        Selenide.sleep(2000);
    }


    @Then("Expected success login of {string}")
    public void assertSuccessLogin(String userName) {
        boolean isUserDataVisibleInAccount = $x("//*[@id='userName-value' and text()='" + userName + "']").isDisplayed();
        Assert.assertTrue(isUserDataVisibleInAccount, "User isn't logged in successfully: " + userName);
    }

    @Then("Expected error message")
    public void assertErrorMessage() {
        boolean isErrorMessageIsVisible = $("#name.mb-1").has(Condition.text("Invalid username or password!"));
        Assert.assertTrue(isErrorMessageIsVisible, "Error message is not visible or incorrect");
    }


    @After
    public void tearDown() {
        // Закриття браузеру після тесту
        WebDriverRunner.closeWebDriver();
    }


}
