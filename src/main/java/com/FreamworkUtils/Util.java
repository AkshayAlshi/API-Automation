package com.FreamworkUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Util {

    private static final Logger logger = LogManager.getLogger(Util.class);

    /**
     * Capture screenshot of the current browser window
     * @param driver WebDriver instance
     * @param testName Name of the test (used as screenshot file name)
     * @return Path of the saved screenshot
     */
    public String captureScreenshot(WebDriver driver, String testName) {
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            File dest = new File(screenshotPath);
            dest.getParentFile().mkdirs(); // create folder if it does not exist
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot: ", e);
        }

        return screenshotPath;
    }
}
