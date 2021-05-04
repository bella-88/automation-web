package pages;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

import static interfaces.LoginPageUI.HERE_LINK;

public class HomePage extends AbstractPage {
  WebDriver driver;

  public HomePage(WebDriver driver_) {
    this.driver = driver_;
  }


}
