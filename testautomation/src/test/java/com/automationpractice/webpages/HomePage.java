package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jeff on 1/30/2017.
 */
public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"editorial_block_center\"]/h1")
    private WebElement textToCheck;

    public HomePage (WebDriver driver){
        this.driver = driver;
        driver.get("http://automationpractice.com/index.php");
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickSignInButton(){
        signInButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public String verifyText(){
        return textToCheck.getText();
    }
}
