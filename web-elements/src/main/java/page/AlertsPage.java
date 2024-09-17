package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends AbstractPage {
    AlertsPage alertsPage;
    private static final String ALERTS_PAGE_URL = baseurl + "/alerts";
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void openAlertsPage() {
        openPage(ALERTS_PAGE_URL);
    }

    @FindBy(id = "alertButton")
    public WebElement firstClickMeButton;
    @FindBy(id = "timerAlertButton")
    public WebElement secondClickMeButton;
    @FindBy(id = "confirmButton")
    public WebElement thirdClickMeButton;
    @FindBy(id = "promtButton")
    public WebElement fourthClickMeButton;

    public AlertsPage setClickMeButton(WebElement e) {
        e.click();
        return alertsPage;
    }
}
