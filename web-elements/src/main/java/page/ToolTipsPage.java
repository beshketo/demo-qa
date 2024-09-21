package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends AbstractPage{

    private static final String TOOL_TIPS_PAGE_URL = baseurl + "/tool-tips";
    @FindBy(id = "toolTipButton")
    private WebElement HoverMeToSeeButton;
    @FindBy(css = "#texToolTopContainer a")
    private WebElement ContraryTextLink;

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open page")
    public void openToolTipsPage() {
        openPage(TOOL_TIPS_PAGE_URL);
    }

    @Step("Hover over button")
    public void hoverOverButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(HoverMeToSeeButton).perform();
    }
    @Step("Hover over link")
    public void hoverOverLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(ContraryTextLink).perform();
    }

}
