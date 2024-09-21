import config.ConfigProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ToolTipsPage;
import java.time.Duration;

public class ToolTipsTest {
    private static WebDriver driver;
    private static ToolTipsPage toolTipsPage;

    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        toolTipsPage = new ToolTipsPage(driver);
        toolTipsPage.openToolTipsPage();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @BeforeEach
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check hovering over the button")
    public void hoverOverButton() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        toolTipsPage.hoverOverButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonToolTip")));
        String tooltip = driver.findElement(By.id("toolTipButton")).getAttribute("aria-describedby");
        Assertions.assertEquals("buttonToolTip", tooltip, "Tooltip isn't appeared");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check hovering over text link")
    public void hoverOverTextLink() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        toolTipsPage.hoverOverLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-describedby='contraryTexToolTip']")));

        String tooltip = driver.findElement(By.cssSelector("#texToolTopContainer a")).getAttribute("aria-describedby");
        Assertions.assertEquals("contraryTexToolTip", tooltip, "Tooltip isn't appeared");
    }
}
