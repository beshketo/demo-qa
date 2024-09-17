import config.ConfigProvider;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.ModalDialogsPage;
import page.TextBoxPage;

import java.time.Duration;

public class ModalDialogsTest {
    private static WebDriver driver;
    private static ModalDialogsPage ModalDialogPage;

    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ModalDialogPage = new ModalDialogsPage(driver);
        ModalDialogPage.openModalDialogPage();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void closingSmallModalWindow(){
        ModalDialogPage.openSmallModalWindow();
        WebElement actualWindow = driver.findElement(By.id("example-modal-sizes-title-sm"));
        Assertions.assertNotNull(actualWindow, "Small window isn't opened");
        ModalDialogPage.closeSmallModalWindow();
        Assertions.assertNotNull(ModalDialogPage.openPage(););
    }

}

