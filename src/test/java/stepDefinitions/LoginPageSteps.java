package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginPageSteps {
  WebDriver driver;
  private LoginPage loginPage;
  private HomePage homePage;
  private RegisterPage registerPage;
  @Before
  public void setUp() {
    driver = Hooks.openBrowser();

  }
  @Given("^I navigate to Guru site$")
  public void i_navigate_to_guru_site() throws Throwable {
loginPage = new LoginPage(driver);
  }

  @When("^I click on here link and link to register page$")
  public void i_click_on_here_link_and_link_to_register_page() throws Throwable {
    loginPage.clickToLink();
    registerPage = new RegisterPage(driver);
  }

  @And("^I input \"([^\"]*)\" and click submit button$")
  public void i_input_something_and_click_submit_button(String email, String strArg1) throws Throwable {
    registerPage.inputInfo(email);
    homePage = new HomePage(driver);
  }

  @And("^I get information to login$")
  public void i_get_information_to_login() throws Throwable {

  }

}
