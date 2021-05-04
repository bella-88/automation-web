package cucumberOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static commons.Constants.URL_TEST;

public class Hooks {
  private static WebDriver driver;
  private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());


  //  @BeforeClass
  public synchronized static WebDriver openBrowser() {
    ChromeOptions chromeOptions = new ChromeOptions();
    if (!System.getProperty("os.name").startsWith("Windows")) {
      chromeOptions.addArguments("--no-sandbox");
      chromeOptions.addArguments("--disable-dev-shm-usage");
      chromeOptions.addArguments("--headless");
    }
    if (driver == null) {
      try {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
      } catch (UnreachableBrowserException e) {
        driver = new ChromeDriver(chromeOptions);
      } catch (WebDriverException e) {
        driver = new ChromeDriver(chromeOptions);
      } finally {

        Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
      }
      if (!StringUtils.equals(driver.getCurrentUrl(), URL_TEST)) {
        driver.get(URL_TEST);
      } else {
        driver.get(URL_TEST);
      }
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
      LOGGER.info("===============STARTED THE BROWSER =====================");
    }
    return driver;
  }
  public static void closeSite() {
    try {
      openBrowser().quit();
      driver = null;
      LOGGER.info("Closing the browser");
    } catch (UnreachableBrowserException e) {
      LOGGER.info("Cannot close browser: unreachable browser");
    }
  }

  private static class BrowserCleanup implements Runnable {
    public void run() {
      closeSite();
    }
  }

  ///======================================
  @After
  public void closeSite(WebDriver driver) {
    try {
      if (driver != null) {
        driver.quit();
        System.gc();
        if (driver.toString().toLowerCase().contains("chrome")) {
          String cmd = "taskkill /IM chromedriver.exe/C";
          Process process = Runtime.getRuntime().exec(cmd);
          process.waitFor();
        }
        System.out.println("=======Quit Browser========");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
}
