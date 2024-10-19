package parallel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ithillel.test.RegisterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class RegisterTest {

    private static RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/login");
        Configuration.timeout = 2000;
    }

    @Given("Open Register page")
    public void openRegisterPage() {
        setUp();
        executeJavaScript("arguments[0].scrollIntoView(true);", $("#newUser"));
        $("#newUser").click();  // Використання Selenide для пошуку елемента
    }

    @When("Fill in the registration form with {string}, {string}, {string}, {string}")
    public void FillOutName(String firstName, String lastName, String userName, String password) {
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        Configuration.timeout = 1000;
        $("#firstname").setValue(firstName);
        Configuration.timeout = 1000;
        $("#lastname").setValue(lastName);
        Configuration.timeout = 1000;

        $("#userName").setValue(userName);
        Configuration.timeout = 1000;

        $("#password").setValue(password);
    }

    @When("Check Captcha box")
    public void solveCaptcha() {
        $("#g-recaptcha").click();
        // Виводимо повідомлення для ручного проходження CAPTCHA
        System.out.println("Будь ласка, пройдіть CAPTCHA вручну.");
        // Зупинка тесту на 30 секунд для вручного проходження CAPTCHA
        Selenide.sleep(50000);
    }
    @When("Click Register button")
    public void clickRegisterButton(){
        $("#register").click();
    }

    @Then("Expected success message")
    public void assertResult(){
        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        String alertMessage = switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "User Register Successfully.");
        switchTo().alert().accept();
    }
    @After
    public void tearDown() {
        // Закриття браузеру після тесту
        WebDriverRunner.closeWebDriver();
    }



}
