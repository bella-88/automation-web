package pages;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

import static interfaces.RegisterPageUI.EMAIL_TXT;
import static interfaces.RegisterPageUI.SUBMIT_BTN;

public class RegisterPage extends AbstractPage {
  WebDriver driver;
  public RegisterPage(WebDriver driver_) {
    this.driver = driver_;
  }
  public HomePage inputInfo(String email){
    sendkeysToElement(driver,EMAIL_TXT,email);
    clickElement(driver, SUBMIT_BTN);
    return new HomePage(driver);
  }
}
