package com.epam.mailru.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeWebdriver {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
   // private static final String CHROME_PATH = "C:/dev/webdrivers/chrome/2.42/chromedriver.exe";

    private static WebDriver driver;

    private ChromeWebdriver() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            checkDriverProperty(WEBDRIVER_CHROME_DRIVER);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    private static void checkDriverProperty(String webDriverName) {
        if (System.getProperty(webDriverName) == null) {
            System.setProperty(webDriverName, System.getenv(webDriverName));
        }
    }

}
