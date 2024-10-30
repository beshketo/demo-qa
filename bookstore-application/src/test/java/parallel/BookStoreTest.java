package parallel;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BookStoreTest {


    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 2000;
    }

    @Given("Open Book Store page")
    public void openBookStorePage() {
        open("https://demoqa.com/books");
    }

    @When("Fill out search field with part of title: {string}")
    public void FillOutTitleInSearchField(String partTitle) {
        System.out.println("partTitle: " + partTitle);
        Configuration.timeout = 1000;
        $("#searchBox").setValue(partTitle);
    }

    @When("Fill out the search field with name of author: {string}")
    public void FillOutAuthorInSearchField(String author) {
        System.out.println("author: " + author);
        Configuration.timeout = 1000;
        $("#searchBox").setValue(author);
    }

    @When("Click on the Author button")
    public void clickOnAuthorButton() {
        $x("//div[text()=\"Author\"]\t").click();
    }

    @When("Click on the Login button on Book Store Page")
    public void clickOnLoginButton() {
        $("#login").click();
        Configuration.timeout = 1000;
    }

    @When("Fill out all fields for login: {string}, {string}")
    public void FillOutExistingUserData(String userName, String password) {
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        Configuration.timeout = 1000;
        $("#userName").setValue(userName);
        Configuration.timeout = 1000;
        $("#password").setValue(password);
    }

    @Then("The book searched by title is displayed")
    public void assertBookByTitleIsDisplayed() {
        boolean isChosenBookDisplayed = $x("//*[@id='see-book-Learning JavaScript Design Patterns']").isDisplayed();
        Assert.assertTrue(isChosenBookDisplayed, "The chosen book isn't displayed");
    }

    @Then("The book searched by author is displayed")
    public void assertBookByAuthorIsDisplayed() {
        boolean isChosenBookDisplayed = $x("//div[text()=\"Glenn Block et al.\"]\t").isDisplayed();
        Assert.assertTrue(isChosenBookDisplayed, "The chosen book isn't displayed");
    }

    @Then("All books are sorted by the name of the author")
    public void assertBooksSortedByAuthorIsDisplayed() {
        String actualFirstAuthor = $x("//div[@class='rt-tr-group'][1]//div[@class='rt-td'][position()=3]").getText();
        String FirstAuthorInList = "Addy Osmani";
        Assert.assertEquals(actualFirstAuthor, FirstAuthorInList, "Wrong first author after sorting");

    }

    @Then("User is logged in Account: {string}")
    public void assertUserIsLoggedInAccount(String userName) {
        String nameOfUser = $("#userName-value").getText();
        Assert.assertEquals(nameOfUser, userName, "User isn't logged in");

    }


    @After
    public void tearDown() {
        System.out.println("Закриття браузера");
        closeWebDriver();
    }

}
