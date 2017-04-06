package com.meniulzilei.webpages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by ovidiu.zakarias on 20.03.2017.
 */
public class CasaMuresana {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL = "http://www.meniulzilei.info/targu-mures/restaurant/restaurant-casa-muresana";

    //Locators
    //Menu element:
    @FindBy(how = How.XPATH, xpath = ".//*[@class='dailymenu']/ul/li")
    private List<WebElement> dailymenu;

    //Constructor
    public CasaMuresana(WebDriver driver) {

        this.driver = driver;
        driver.get(PAGE_URL);

        //Initialise Elements:
        PageFactory.initElements(driver, this);
    }

    public void listMenuEntries() {
        for (WebElement option : dailymenu) {
            System.out.println("Menu entry:" + option.getText());
        }
    }

    public String addMenuEntriestoString() {
        String menu = "";
        for (WebElement option : dailymenu) {
            menu = menu + " " + option.getText();
        }

        return menu;
    }

}
