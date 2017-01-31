package com.automationpractice.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jeff on 1/30/2017.
 */
public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement emailAddressField;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    private WebElement textToCheck;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailAddress(String emailAddress){
        emailAddressField.sendKeys(emailAddress);
    }

    public void clickCreateAccount(){
        createAccountButton.click();
    }

    public String verifyText(){
        return textToCheck.getText();
    }
}
