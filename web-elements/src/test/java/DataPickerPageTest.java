import config.ConfigProvider;
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
import page.DatePickerPage;


public class DataPickerPageTest {
    private static WebDriver driver;
    private static DatePickerPage DatePickerPage;
    @BeforeAll
    public static void setUp() {
        driver = ConfigProvider.getDriver();
        DatePickerPage = new DatePickerPage(driver);
        DatePickerPage.openDatePickerPage();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("checkChangingDateInDatePicker")
    public void changingDateInDataPicker(){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        String expectedResult = DatePickerPage.changeDataInSelectDataPicker(5);
        String actualResult = driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
        Assertions.assertEquals(expectedResult, actualResult, "The data isn't similar");
    };
}
