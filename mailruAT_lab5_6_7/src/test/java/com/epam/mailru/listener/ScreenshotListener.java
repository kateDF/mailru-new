package com.epam.mailru.listener;

import static com.epam.mailru.driver.AbstractWebDriverFactory.BrowserType;
import static com.epam.mailru.driver.AbstractWebDriverFactory.WebDriverType;

import com.epam.mailru.config.Config;
import com.epam.mailru.driver.AbstractWebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotListener extends TestListenerAdapter {

    private static final WebDriverType WEB_DRIVER_TYPE = Config.getWebDriverType();
    private static final AbstractWebDriverFactory.BrowserType BROWSER_TYPE = Config.getBrowserType();
    private final Logger logger = LogManager.getRootLogger();
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName();

        if (!result.isSuccess()) {
            try {
                File scrFile = ((TakesScreenshot) AbstractWebDriverFactory.getInstance(WEB_DRIVER_TYPE, BROWSER_TYPE)).getScreenshotAs(OutputType.FILE);
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/test_screenshots";
                String screenshotName = reportDirectory + "/failure_screenshots/" + methodName + "_" + formatter.format(calendar.getTime()) + ".png";
                File destFile = new File(screenshotName);
                FileUtils.copyFile(scrFile, destFile);
                logger.info("Saved screenshot: " + screenshotName);
                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100%' width='100%'/> </a>");
            } catch (IOException e) {
                logger.error("Can not save screenshot: ", e);
            }
        }
    }

}
