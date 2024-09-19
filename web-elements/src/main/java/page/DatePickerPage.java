package page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class DatePickerPage extends AbstractPage {
    private static final String DATE_PICKER_PAGE_URL = baseurl + "/date-picker";
    @FindBy(id = "datePickerMonthYearInput")
    WebElement selectDate;
    @FindBy(id = "dateAndTimePickerInput")
    WebElement selectDateAndTime;
    @FindBy(className = "react-datepicker__month")
    WebElement datePickerCalendar;


    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page")
    public void openDatePickerPage() {
        openPage(DATE_PICKER_PAGE_URL);
    }

    public String changeDataInSelectDataPicker(int number) {
        selectDate.click();
        List<WebElement> allDates = getAllDateElementsInCurrentMonth();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(datePickerCalendar));

        if (number >= 0 && number < allDates.size()){
            WebElement chosenDate = allDates.get(number);
            chosenDate.click();
            String fullDate = selectDate.getAttribute("value");
            return fullDate;
        }
        else {
            throw new IllegalArgumentException("Invalid number provided for date selection: " + number);
        }
    }


    @Step("Get all date elements in the current month")
    public List<WebElement> getAllDateElementsInCurrentMonth() {
        List<WebElement> allDateElementsInCurrentMonth = datePickerCalendar.findElements(By.cssSelector(".react-datepicker__day"));
        return allDateElementsInCurrentMonth;
    }


}
