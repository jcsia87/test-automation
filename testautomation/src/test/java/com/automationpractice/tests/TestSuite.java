package com.automationpractice.tests;

import com.automationpractice.webpages.HomePage;
import com.automationpractice.webpages.LoginPage;
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
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
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

        loginPage.clickCreateAccount();
        //Assert.assertEquals(loginPage.verifyText(),"CREATE AN ACCOUNT");

    }
}
