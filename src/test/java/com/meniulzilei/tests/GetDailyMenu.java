package com.meniulzilei.tests;

import com.meniulzilei.utils.EmailSender;
import com.meniulzilei.webpages.CM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.zakarias on 20.03.2017.
 */
public class GetDailyMenu {

    WebDriver driver;

    @BeforeMethod
    public void initChromeDriver() {

        System.setProperty("webdriver.chrome.driver", ("/home/training/chromedriver/chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

    }

    @Test(description = "This test is passed if...")
    public void checkMenu() {

        //Create object of Page Class
        CM page = new CM(driver);

        page.listMenuEntries();

        String meniulZilei = page.addMenuEntriestoString();

        /**
         * Meniul super:
         */
        //assertThat(meniulZilei, containsString("artofi gratina"));
        //assertThat(meniulZilei, containsString("iept de pui cu sos gorgonzola"));
        //assertThat(meniulZilei, containsString("rofiterol"));

        assertThat(meniulZilei, containsString("Cotlet de porc"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {

            EmailSender email = new EmailSender();
            email.sendMail();

        }

        driver.close();

    }

}
