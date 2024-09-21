import config.ConfigProvider;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ModalDialogsPage;
import page.TextBoxPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ModalDialogsTest {
    private static WebDriver driver;
    private static ModalDialogsPage ModalDialogPage;

    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        ModalDialogPage = new ModalDialogsPage(driver);
        ModalDialogPage.openModalDialogPage();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("checkClosingSmallModalWindow")
    public void closingSmallModalWindow(){
        ModalDialogPage.openModalDialogPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("showSmallModal")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        ModalDialogPage.openSmallModalWindow();
        WebElement actualWindow = driver.findElement(By.id("example-modal-sizes-title-sm"));
        Assertions.assertNotNull(actualWindow, "Small window isn't opened");
        ModalDialogPage.closeSmallModalWindow();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("example-modal-sizes-title-sm")));
        boolean isModalClosed = driver.findElements(By.id("example-modal-sizes-title-sm")).isEmpty();
        Assertions.assertTrue(isModalClosed, "Small modal window isn't closed");

    };
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("checkClosingLargeModalWindow")
    public void closingLargeModalWindow(){
        ModalDialogPage.openModalDialogPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("showLargeModal")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        ModalDialogPage.openLargeModalWindow();

        WebElement actualWindow = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assertions.assertNotNull(actualWindow, "Large window isn't opened");

        ModalDialogPage.сloseLargeModalWindow();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        boolean isModalClosed = driver.findElements(By.id("example-modal-sizes-title-lg")).isEmpty();
        Assertions.assertTrue(isModalClosed, "Large modal window isn't closed");

    }

}

