import config.ConfigProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AlertsPage;

import java.time.Duration;

public class AlertsPageTest {
    private static WebDriver driver;
    private static AlertsPage alertsPage;

    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        alertsPage = new AlertsPage(driver);
        alertsPage.openAlertsPage();

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("checkFirstButtonAlert")
    public void checkFirstButtonAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("google_ads_iframe")));
        alertsPage.setClickMeButton(alertsPage.firstClickMeButton);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals(alertText, "You clicked a button");
        alert.accept();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("checkSecondButtonAlert")
    public void checkSecondButtonAlert() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        alertsPage.setClickMeButton(alertsPage.secondClickMeButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals(alertText, "This alert appeared after 5 seconds");
        alert.accept();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("checkThirdButtonAlert")
    public void checkThirdButtonAlert() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        alertsPage.setClickMeButton(alertsPage.thirdClickMeButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("text-success"))));
        String confirmResult = driver.findElement(By.className("text-success")).getText();
        String expectedResult = "You selected Ok";
        Assertions.assertEquals(expectedResult, confirmResult, "Actual result is differ from expected result");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("checkFourthButtonAlert")
    public void checkFourthButtonAlert() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        alertsPage.setClickMeButton(alertsPage.fourthClickMeButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.accept();
        String confirmResult = driver.findElement(By.className("text-success")).getText();
        String expectedResult = "You entered Test";
        Assertions.assertEquals(expectedResult, confirmResult, "Actual result is differ from expected result");
    }
}
