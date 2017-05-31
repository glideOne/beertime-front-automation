package com.beertime.sixteensixtyfour.base;

import com.beertime.sixteensixtyfour.utils.ScreenshotTaker;
import com.beertime.sixteensixtyfour.webpages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.zakarias on 5/18/2017.
 */
@ContextConfiguration(locations = {"classpath:conf/beertime-automation-conf.xml"})
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

    protected WebDriver driver;

    protected AgeGate ageGate;
    protected AllProductsPage allProductsPage;
    protected BrandHomepage brandHomepage;
    protected ContentAndStory contentAndStory;
    protected ProductPage productPage;

    //asdada

    @Value("${beertime.base.url}")
    protected String baseUrl;

    @Value("${beertime.brandhomepage.url}")
    protected String brandHomepageUrl;

    @BeforeClass
    public void setupDriverAndPages() {
        System.setProperty("webdriver.chrome.driver", "D://ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        ageGate = new AgeGate(driver);
    }

    @BeforeMethod
    public void getAppUrl() {
        driver.navigate().refresh();
        //driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotTaker.captureScreenshot(driver, result.getName());
        }
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

}
