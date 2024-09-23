package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class SortablePage extends AbstractPage{
    private final String SORTABLE_PAGE_URL = baseurl + "/sortable";
    @FindBy(id = "demo-tab-grid")
    public WebElement gridTab;
    @FindBy(xpath = "//div[@class='grid-container mt-4']//div[text()='One']")
    public WebElement gridFirstItem;
    @FindBy(xpath = "//div[text()='One']")
    public WebElement blockOne ;

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(SORTABLE_PAGE_URL);
    }

    public SortablePage listBlockMovedToLastPosition(){
        blockOne.click();
        List<WebElement> listItems = driver.findElements(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action']"));
        WebElement lastItem = listItems.get(listItems.size() - 1);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(blockOne, lastItem).perform();
        return this;
    }
    public SortablePage gridBlockMovedToLastPosition(){
        gridTab.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        List<WebElement> gridItems = driver.findElements(By.xpath("//div[@class='grid-container mt-4']//div[@class='list-group-item list-group-item-action']"));
        WebElement lastItem = gridItems.get(gridItems.size() - 1);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(gridFirstItem, lastItem).perform();

        return this;
    }
}
