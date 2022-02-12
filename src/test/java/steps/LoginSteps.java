package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.DashboardPage;
import page.LandingPage;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends MatcherAssert {
    WebDriver driver;
    DashboardPage dashboardPage;
    LandingPage landingPage;
    LoginPage loginPage;

    //Comment hooks if you want to run api //@Before & @After
    //Uncomment hooks if you want to run login.feature //@Before & @After
    @Before
    public void browserSetup() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        DesiredCapabilities cap = DesiredCapabilities.htmlUnit();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        this.driver = new ChromeDriver(cap);

        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        driver.manage().window().maximize();

    }

    @After
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @Given("user open bukalapak.com page")
    public void userOnLandingPage() {
        driver.navigate().to("https://www.bukalapak.com");
    }

    @And("user clicks button login on the landing page")
    public void user_clicks_button_login_on_the_landing_page() {
        landingPage.clickLblLogin();
    }

    @Then("user redirected to login page")
    public void user_redirected_to_login_page() {
        assertThat("user is not redirect to login page", driver.getCurrentUrl().contains("/login"));
    }

    @When("^user enters username with value (.*)")
    public void user_enters_username(String username) {
        loginPage.setUsername(username);
    }

    @When("user clicks on lanjut button")
    public void user_clicks_on_lanjut_button() {
        loginPage.clickButtonLanjut();
    }

    @Then("user can see password textbox and login button")
    public void user_can_see_password_textbox_and_login_button() {
        assertThat("password textbox not displayed",
                loginPage.txtPasswordIsDisplayed()
                        && loginPage.btnLoginIsDisplayed());
    }

    @When("^user enters password with value (.*)")
    public void user_enters_password(String password) {
        loginPage.setPassword(password);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickButtonLogin();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        assertThat("failed login! search box is not displayed!", dashboardPage.isTxtSearchDisplayed());
    }


    @Then("user see error message incorect password")
    public void userSeeErrorMessageIncorectPassword() {
        assertThat("error message not displayed!", loginPage.errorMessageIncorrectPasswordIsDisplayed());
    }
}
