package pages;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

import static interfaces.LoginPageUI.HERE_LINK;

public class LoginPage extends AbstractPage {
  WebDriver driver;

  public LoginPage(WebDriver driver_) {
    this.driver = driver_;
  }

  public RegisterPage clickToLink() {
    clickElement(driver, HERE_LINK);
    return new RegisterPage(driver);
  }
}
