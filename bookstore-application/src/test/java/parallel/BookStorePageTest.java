package parallel;

import config.ConfigProvider;
import model.BookTableRow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.BookStorePage;

import java.util.List;

public class BookStorePageTest {
    private WebDriver browser;
    private BookStorePage page;

    @BeforeEach
    public void setUp() {
        browser = ConfigProvider.getDriver();
        page = new BookStorePage(browser);
        page.openPage();
    }

    @AfterEach
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void getAllBookTest() {
        BookTableRow expectedBook = new BookTableRow();
        expectedBook.setTitle("Git Pocket Guide");
        expectedBook.setAuthor("Richard E. Silverman");
        expectedBook.setPublisher("O'Reilly Media");

        List<BookTableRow> books = page.getBooks();
        System.out.println(books);

        Assertions.assertTrue(books.contains(expectedBook));
        Assertions.assertEquals(8, books.size());
    }
}
