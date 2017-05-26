package com.beertime.sixteensixtyfour.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;


/**
 * Created by ovidiu.zakarias on 5/17/2017.
 */
public class ScreenshotTaker {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
            System.out.println("Screenshot taken;");
        }catch (Exception exception)
        {
            System.out.println("Throwing exception while taking screenshot" +exception.getMessage());
        }
    }

}
