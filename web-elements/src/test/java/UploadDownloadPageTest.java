import config.ConfigProvider;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.FileDownloadChecker;
import page.UploadDownloadPage;
import java.awt.*;
import java.time.Duration;
public class UploadDownloadPageTest {
    private static WebDriver driver;
    private static UploadDownloadPage uploadDownloadPage;
    private static FileDownloadChecker fileDownloadChecker;

    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            uploadDownloadPage = new UploadDownloadPage(driver);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        uploadDownloadPage.openUploadDownloadPage();
        fileDownloadChecker = new FileDownloadChecker();

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Disabled
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check downloading the file")
    @Attachment
    public void downloadFileeTest() {
        uploadDownloadPage.openUploadDownloadPage();
        uploadDownloadPage.downloadFile();
        boolean result = fileDownloadChecker.checkDownloadedFile();
        Assert.isTrue(result, "File isn't downloaded");
    }
    @Disabled
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check uploading the file")
    @Attachment
    public void uploadingFileTest() {
        uploadDownloadPage.openUploadDownloadPage();
        uploadDownloadPage.uploadFile();
        WebElement actualPath = driver.findElement(By.id("uploadedFilePath"));
        Assertions.assertNotNull(actualPath, "File wasn't uploaded");
    }


}
