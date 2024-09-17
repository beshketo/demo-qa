package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalDialogsPage extends AbstractPage {
    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }
    private static final String MODAL_DIALOGS_PAGE_URL = baseurl + "/modal-dialogs";
    @FindBy(id = "showSmallModal")
    WebElement smallModalButton;
    @FindBy(id = "showLargeModal")
    WebElement largeModalButton;
    @FindBy(id = "closeSmallModal")
    WebElement closeSmallModalButton;

    @FindBy(id = "closeLargeModal")
    WebElement closeLargeModalButton;

    public void openModalDialogPage() {
        openPage(MODAL_DIALOGS_PAGE_URL);
    }
    public ModalDialogsPage openSmallModalWindow() {
        smallModalButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }
    public ModalDialogsPage closeSmallModalWindow() {
        closeSmallModalButton.click();
        return this;
    }


    public ModalDialogsPage openLargeModalWindow() {
        largeModalButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        closeLargeModalButton.click();
        return this;
    }


}
