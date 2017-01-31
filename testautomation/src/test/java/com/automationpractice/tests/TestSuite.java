package com.automationpractice.tests;

import com.automationpractice.webpages.HomePage;
import com.automationpractice.webpages.LoginPage;
import com.automationpractice.webpages.NewUserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Jeff on 1/30/2017.
 */
public class TestSuite {
    public WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //@AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void VisitHomepage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.verifyText(), "Automation Practice Website");

        LoginPage loginPage = homePage.clickSignInButton();
        Assert.assertEquals(loginPage.verifyText(),"AUTHENTICATION");
        loginPage.setEmailAddress("test@email100.com");

        NewUserPage newUserPage = loginPage.clickCreateAccount();
        Assert.assertEquals(newUserPage.verifyText(),"CREATE AN ACCOUNT");
        newUserPage.setTitle("mr");
        newUserPage.setCustomerFirstName("Firstname");
        newUserPage.setCustomerLastName("Lastname");
        newUserPage.setPassword("123456");
        newUserPage.setAddress("Address");
        newUserPage.setCity("City");
        newUserPage.setZipCode("123456");
        newUserPage.setState("Alabama");
        newUserPage.setCountry("United States");
        newUserPage.setMobileNumber("123456");
    }
}