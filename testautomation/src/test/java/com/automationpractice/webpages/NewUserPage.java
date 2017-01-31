package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jeff on 1/30/2017.
 */
public class NewUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
    private WebElement textToCheck;

    public NewUserPage(WebDriver driver){
        this.driver = driver;
    }

    public String check(){
        return textToCheck.getText();
    }
}
