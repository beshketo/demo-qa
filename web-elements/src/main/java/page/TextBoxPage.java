package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextBoxPage extends AbstractPage {
    private static final String TEXT_BOX_PAGE_URL = baseurl + "/text-box";;
    @FindBy(id="userName")
    private WebElement fullNameField;
    @FindBy(id="userEmail")
    private WebElement emailField;
    @FindBy(id="currentAddress")
    private WebElement currentAddressField;
    @FindBy(id="permanentAddress")
    private WebElement permanentAddressField;
    @FindBy(css = ".btn-primary")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
    private WebElement resultOutput;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void openTextBoxPage() {
        openPage(TEXT_BOX_PAGE_URL);
    }

    public TextBoxPage fillForm(User user) {
        fullNameField.sendKeys(user.getName());
        emailField.sendKeys(user.getEmail());
        currentAddressField.sendKeys(user.getCurrentAddress());
        permanentAddressField.sendKeys(user.getPermanentAddress());
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public WebElement getResultDiv() {
        return resultOutput;
    }

}




