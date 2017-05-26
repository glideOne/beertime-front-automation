package com.beertime.sixteensixtyfour.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.environ.EnvironmentVariables.BASE_URL;

/**
 * Created by ovidiu.zakarias on 03.05.2017.
 */
public class AgeGate {

    private WebDriver driver;

    //Page URL
    public static String AGE_GATE_URL = BASE_URL + "/1664";

    //Locators
    @FindBy(xpath = ".//*[text()='OUI']")
    private WebElement ouiButton;

    @FindBy(xpath = ".//*[text()='NON']")
    private WebElement nonButton;

    @FindBy(xpath = ".//*[text()='Vous devez être majeur pour accéder à #Beertime.']")
    private WebElement nonAgeGateMessage;

    @FindBy(className = "menu")
    private WebElement headerMenu;

    //Constructor
    public AgeGate (WebDriver driver) {
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnOuiButton() {
        ouiButton.click();
    }

    public void clickOnNonButton() {
        nonButton.click();
    }

    public boolean isErrorMessageVisible() {
        if(nonAgeGateMessage.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isHeaderMenuVisible() {
        if(headerMenu.isDisplayed()) {
            return true;
        }
        return false;
    }

}
