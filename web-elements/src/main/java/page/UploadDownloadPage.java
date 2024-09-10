package page;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

@Slf4j
public class UploadDownloadPage  extends AbstractPage  {
    WebDriver webDriver;
    private static final String UPLOAD_DOWNLOAD_PAGE_URL = baseurl + "/upload-download";
    @FindBy(id="downloadButton")
    private WebElement downloadButton;
    @FindBy(id = "uploadFile")
    private WebElement chooseFileButton;
    Robot robot = new Robot();

    public UploadDownloadPage(WebDriver driver) throws AWTException  {
        super(driver);
        this.robot = new Robot();
    }

    @Step("Open Upload Download page")
    public void openUploadDownloadPage() {
        openPage(UPLOAD_DOWNLOAD_PAGE_URL);
    }

    @Step("Download the file")
    public void downloadFile(){
        downloadButton.click();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(2000);
    }

    public void uploadFile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chooseFileButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadFile")));
        chooseFileButton.sendKeys("/Users/anna/Downloads/sampleFile.jpeg");
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
