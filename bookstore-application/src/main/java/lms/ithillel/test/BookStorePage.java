package lms.ithillel.test;

import org.openqa.selenium.WebDriver;
import page.AbstractPage;

public class BookStorePage extends AbstractPage  {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }
    final String LOGIN_PAGE_URL = baseurl + "/books";
}
