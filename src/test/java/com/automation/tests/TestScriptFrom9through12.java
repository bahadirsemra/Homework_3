package com.automation.tests;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScriptFrom9through12 {
    WebDriver driver = BrowserFactory.getDriver("chrome");
    private By statusCode = By.linkText("Status Codes");
    private By code200 = By.linkText("200");
    private By code301 = By.linkText("301");
    private By code404 = By.linkText("404");
    private By code500 = By.linkText("500");

    private By code200Message = By.tagName("p");
    private By code301Message = By.tagName("p");
    private By code404Message = By.tagName("p");
    private By code500Message = By.tagName("p");


    /*
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
     */
    @BeforeMethod
    public void setup(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WaitUtils.wait(2);
        driver.findElement(statusCode).click();
        WaitUtils.wait(2);
    }//p[contains(text()=’This page returned a 301 status code.’)]

    /*
    Step 3. Then click on “200”.
    Step 4. Verify that following message is displayed: “This page returned a 200 status code”
    */
    @Test
    public void testCase9(){
        driver.findElement(code200).click();
        WaitUtils.wait(2);
        String  expected="This page returned a 200 status code.";
        String actual= driver.findElement(code200Message).getText();
        Assert.assertTrue(actual.startsWith(expected));

    }


    /*
    Step 3. Then click on “301”.
    Step 4. Verify that following message is displayed: “This page returned a 301 status code”
     */
    @Test
    public void testCase10(){
        driver.findElement(code301).click();
        WaitUtils.wait(2);
        String  expected="This page returned a 301 status code.";
        String actual= driver.findElement(code301Message).getText();
        Assert.assertTrue(actual.startsWith(expected));
    }


    /*
    Step 4. Then click on “404”.
    Step 5. Verify that following message is displayed: “This page returned a 404 status code”
     */
    @Test
    public void testCase11(){
        driver.findElement(code404).click();
        WaitUtils.wait(2);
        String  expected="This page returned a 404 status code.";
        String actual= driver.findElement(code404Message).getText();
        Assert.assertTrue(actual.startsWith(expected));
    }



    /*
    Step 4. Then click on “500”.
    Step 5. Verify that following message is displayed: “This page returned a 500 status code”
     */
    @Test
    public void testCase12(){
        driver.findElement(code500).click();
        WaitUtils.wait(2);
        String  expected="This page returned a 500 status code.";
        String actual= driver.findElement(code500Message).getText();
        Assert.assertTrue(actual.startsWith(expected));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
