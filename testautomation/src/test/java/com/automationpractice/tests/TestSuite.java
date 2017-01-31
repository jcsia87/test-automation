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

import java.util.concurrent.TimeUnit;

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

        NewUserPage newUserPage = loginPage.clickCreateAccount();
        Thread.sleep(5000);
        Assert.assertEquals(newUserPage.check(),"YOUR PERSONAL INFORMATION");

    }
}
