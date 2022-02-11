package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage{
    WebDriver driver;

    @FindBy(xpath = "//a[@class='sigil-header__nav te-header-login']//*[contains(text(),'Login')]")
    WebElement lblLogin;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLblLogin() {
        if (lblLogin.isDisplayed()) {
            lblLogin.click();
        }
    }
}
