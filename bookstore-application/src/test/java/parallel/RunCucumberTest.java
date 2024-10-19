package parallel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources", // Вказати шлях до .feature файлів
        glue = "parallel", // Вказати пакет зі степами
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    // Цей клас запускає всі Cucumber тести через TestNG
}
