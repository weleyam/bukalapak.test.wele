package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "LoginID")
    WebElement txtUsename;

    @FindBy(id = "Password")
    WebElement txtPassword;

    @FindBy(id = "btn-login")
    WebElement btnLogin;

    @FindBy(id = "submit_button")
    WebElement btnLanjut;

    @FindBy(xpath = "//div[@class='bl-text-field__message']//p[@class='bl-text bl-text--caption bl-text--error']")
    WebElement errorMessageIncorrectPassword;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        txtUsename.sendKeys(username);
    }

    public void clickButtonLanjut() {
        btnLanjut.click();
    }

    public void clickButtonLogin() {
        btnLogin.click();
    }

    public boolean txtPasswordIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        return txtPassword.isDisplayed();
    }

    public boolean btnLoginIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnLogin));
        return btnLogin.isDisplayed();
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public boolean errorMessageIncorrectPasswordIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(errorMessageIncorrectPassword));
        return errorMessageIncorrectPassword.isDisplayed();
    }
}
