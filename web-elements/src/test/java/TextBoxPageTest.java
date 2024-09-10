import config.ConfigProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.TextBoxPage;
import page.User;
import page.UserFactory;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

public class TextBoxPageTest {
    private static WebDriver driver;
    private static TextBoxPage textBoxPage;

    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        textBoxPage = new TextBoxPage(driver);
        textBoxPage.openTextBoxPage();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest
    @MethodSource("userProvider")
    public void validTest(User user) {
        textBoxPage.fillForm(user);
        WebElement submitButton = driver.findElement(By.cssSelector(".btn-primary"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        textBoxPage.clickSubmitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> textBoxPage.getResultDiv().isDisplayed());

        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Name", "Name:"+user.getName());
        expectedValues.put("Email", "Email:" + user.getEmail());
        expectedValues.put("Current Address", "Current Address :" + user.getCurrentAddress());
        expectedValues.put("Permanent Address", "Permananet Address :" + user.getPermanentAddress());

        // Перевірка фактичних значень
        Map<String, String> actualValues = getActualValues();
        expectedValues.forEach((key, expectedValue) ->
                Assertions.assertEquals(expectedValue, actualValues.get(key), key + " не збігається!")
        );
    }

    private Map<String, String> getActualValues() {
        Map<String, String> actualValues = new HashMap<>();
        actualValues.put("Name", textBoxPage.getResultDiv().findElement(By.xpath("//p[1]")).getText());
        actualValues.put("Email", textBoxPage.getResultDiv().findElement(By.xpath("//p[2]")).getText());
        actualValues.put("Current Address", textBoxPage.getResultDiv().findElement(By.xpath("//p[3]")).getText());
        actualValues.put("Permanent Address", textBoxPage.getResultDiv().findElement(By.xpath("//p[4]")).getText());
        return actualValues;
    }

    static Stream<User> userProvider() {
        return Stream.of(
                UserFactory.generateUser("John Doe", "john.doe@example.com", "123 Main St", "456 Elm St")
        );
    }
}
