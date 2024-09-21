package page;

import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;


public class DatePickerPage extends AbstractPage {
    private static final String DATE_PICKER_PAGE_URL = baseurl + "/date-picker";
    @FindBy(id = "datePickerMonthYearInput")
    WebElement selectDate;
    @FindBy(id = "dateAndTimePickerInput")
    WebElement selectDateAndTime;
    @FindBy(className = "react-datepicker__month")
    WebElement datePickerCalendar;
    @FindBy(className = "react-datepicker__time-list")
    WebElement timePickerCalendar;


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

        if (number >= 0 && number < allDates.size()) {
            WebElement chosenDate = allDates.get(number);
            chosenDate.click();
            String fullDate = selectDate.getAttribute("value");
            return fullDate;
        } else {
            throw new IllegalArgumentException("Invalid number provided for date selection: " + number);
        }
    }

    public String changeTimeInDateAndTimePicker(String time) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime parsedTime = LocalTime.parse(time, timeFormatter);

        selectDateAndTime.click();
        List<WebElement> allTimesFromCurrentDay = getAllTimeElementsInCurrentDay();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(timePickerCalendar));
        for (WebElement timeSlot : allTimesFromCurrentDay) {
            String timeSlotText = timeSlot.getText().trim();

            if (timeSlotText.equals(parsedTime.format(timeFormatter))) {
                timeSlot.click();
                break;
            }
        }
        String fullDate = selectDateAndTime.getAttribute("value");
        return fullDate;

    }


    @Step("Get all date elements in the current month")
    public List<WebElement> getAllDateElementsInCurrentMonth() {
        List<WebElement> allDateElementsInCurrentMonth = datePickerCalendar.findElements(By.cssSelector(".react-datepicker__day"));
        return allDateElementsInCurrentMonth;
    }

    @Step("Get all time elements in the current day")
    public List<WebElement> getAllTimeElementsInCurrentDay() {
        List<WebElement> allTimeElementsInCurrentDay = timePickerCalendar.findElements(By.cssSelector(".react-datepicker__time-list-item"));
        return allTimeElementsInCurrentDay;
    }

}
