package threads;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AlertsPage;

import java.time.Duration;

public class runnableThread implements Runnable {
    private static WebDriver driver;

    public runnableThread(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Override
    public void run() {
        try {

            System.out.println("Починаємо тест в потоці: " + Thread.currentThread().getName());

            AlertsPage alertsPage = new AlertsPage(driver);
            alertsPage.openAlertsPage();
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            alertsPage.setClickMeButton(alertsPage.secondClickMeButton);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assertions.assertEquals(alertText, "This alert appeared after 5 seconds");
            alert.accept();
            System.out.println("✅ Потік " + Thread.currentThread().getName() + " успішно завершив тест!");
            driver.quit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}