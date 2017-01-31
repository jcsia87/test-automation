package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Jeff on 1/31/2017.
 */
public class NewUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
    private WebElement textToCheck;

    @FindBy(className = "radio-inline")
    private List<WebElement> title;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "postcode")
    private WebElement zipCode;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement mobileNumber;

    public NewUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setTitle(String title) {
        if(title.equals("mr")){
            this.title.get(0).click();
        } else if(title.equals("mrs")) {
            this.title.get(1).click();
        }
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName.sendKeys(customerFirstName);
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName.sendKeys(customerLastName);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setAddress(String address) {
        this.address.sendKeys(address);
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.sendKeys(zipCode);
    }

    public void setState(String state) {
        Select dropdown = new Select(this.state);
        dropdown.selectByVisibleText(state);
    }

    public void setCountry(String country) {
        Select dropdown = new Select(this.country);
        dropdown.selectByVisibleText(country);
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber.sendKeys(mobileNumber);
    }

    public String verifyText(){
        return textToCheck.getText();
    }
}

