package lms.ithillel.test;
import org.openqa.selenium.WebDriver;
import static page.AbstractPage.baseurl;

public class ProfilePage {
    public ProfilePage(WebDriver driver) {
        super();
    }
    final String PROFILE_PAGE_URL = baseurl + "/profile";
}
