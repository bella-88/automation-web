package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static commons.Constants.LONG_TIMEOUT;

public class AbstractPage {
  WebElement element;
  JavascriptExecutor javascriptExecutor;
  WebDriverWait waitExplicit;
  By byLocator;
  public void openAnyUrl(WebDriver driver, String url) {
    driver.get(url);
  }
  public String getTitlePage(WebDriver driver) {
    return driver.getTitle();
  }

  public String getCurrentUrl(WebDriver driver) {
    return driver.getCurrentUrl();
  }
  public void backToPreviousPage(WebDriver driver) {
    driver.navigate().back();
  }

  public void reloadPage(WebDriver driver) {
    driver.navigate().refresh();
  }
  public void scrollToBottomPage(WebDriver driver) {
    javascriptExecutor = (JavascriptExecutor) driver;
    javascriptExecutor.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");
  }
  public void waitForAllElementsPresence(WebDriver driver, String locator) {
    waitExplicit = new WebDriverWait(driver, LONG_TIMEOUT);
    byLocator = By.xpath(locator);
    waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byLocator));
  }
  public void clickElement(WebDriver driver, String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    waitForAllElementsPresence(driver, locator);
    element.click();
  }

  public void sendkeysToElement(WebDriver driver, String locator, String text) {
    WebElement element = driver.findElement(By.xpath(locator));
    element.sendKeys(text);
  }
  public static boolean isDisplayed(WebElement element) {
    try {
      if (element.isDisplayed()) {
        return element.isDisplayed();
      }
    } catch (NoSuchSessionException ex) {
      return false;
    }
    return false;
  }
}
