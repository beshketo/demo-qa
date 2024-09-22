import config.ConfigProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.SortablePage;

import java.time.Duration;
import java.util.List;

public class SortablePageTest {
    private static WebDriver driver;
    private static SortablePage sortablePage;

    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        sortablePage = new SortablePage(driver);
        sortablePage.openPage();
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
    @Description("Check moving one object over last item in list")
    public void movingFirstObjectOverLastItemInList() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        sortablePage.listBlockMovedToLastPosition();

        List<WebElement> listItems = driver.findElements(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action']"));
        WebElement lastItem = listItems.get(listItems.size() - 1);
        String lastItemText = lastItem.getText();
        Assertions.assertEquals("One", lastItemText, "Button One isn't on last position.");
    }
    @SneakyThrows
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check moving one object over last item in grid")
    public void movingFirstObjectOverLastItemInGrid() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        sortablePage.gridBlockMovedToLastPosition();

        List<WebElement> listItems = driver.findElements(By.xpath("//div[@class='grid-container mt-4']//div[@class='list-group-item list-group-item-action']"));
        WebElement lastItem = listItems.get(listItems.size() - 1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(lastItem, "One"));
        String lastItemText = lastItem.getText();
        Assertions.assertEquals("One", lastItemText, "Button One isn't on last position.");
    }


}
