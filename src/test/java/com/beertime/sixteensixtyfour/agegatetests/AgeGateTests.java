package com.beertime.sixteensixtyfour.agegatetests;

import com.beertime.sixteensixtyfour.base.AbstractTest;
import com.beertime.sixteensixtyfour.utils.ScreenshotTaker;
import com.beertime.sixteensixtyfour.webpages.AgeGate;
import org.exparity.hamcrest.date.Moments;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.exparity.hamcrest.date.DateMatchers.within;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.zakarias on 5/9/2017.
 */
public class AgeGateTests extends AbstractTest {

    @BeforeMethod
    public void setup() {

//        System.setProperty("webdriver.chrome.driver", "D://ChromeDriver/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().deleteCookieNamed("\tageGateCheck_1664");
        driver.manage().deleteAllCookies();
        driver.get(brandHomepageUrl);


    }

    /**
     * This test verifies that the error message provided by the customer
     * appears on the screen upon clicking the "Non" button.
     */
    @Test(description = "Testing functionality of NON button")
    public void verifyNonButtonMessage() {

        AgeGate ageGate = new AgeGate(driver);
        ageGate.clickOnNonButton();

        assertThat(ageGate.isErrorMessageVisible(), is(true));

    }

    /**
     * This test verifies that the header menu is displayed
     * after clicking on the "Oui button".
     */
    @Test
    public void verifyOuiButtonRedirect() {

        AgeGate ageGate = new AgeGate(driver);
        ageGate.clickOnOuiButton();

        assertThat(ageGate.isHeaderMenuVisible(), is(true));

    }

    /**
     * This test verifies that the cookie added upon clicking the "Oui" button
     * expires within maximum 8 days of its creation.
     */
    @Test(description = "Testing functionality of OUI button.")
    public void verifyOuiButtonCookieExpirationDate() {

        AgeGate ageGate = new AgeGate(driver);
        ageGate.clickOnOuiButton();

        Cookie cookie = driver.manage().getCookieNamed("ageGateCheck_1664");
        Date cookieExpiryDate = cookie.getExpiry();

        assertThat(cookieExpiryDate, within(8, TimeUnit.DAYS, Moments.today()));

    }

}
