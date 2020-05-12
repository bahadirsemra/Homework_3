package com.automation.tests;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScript6 {
    /*
    Step 1. Go to "https://www.tempmailaddress.com/"
    Step 2. Copy and save email as a string.
    Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
    Step 4. And click on “Sign Up For Mailing List".
    Step 5. Enter any valid name.
    Step 6. Enter email from the Step 2.
    Step 7. Click Sign Up
    Step 8. Verify that following message is displayed:
                   “Thank you for signing up. Click the button below to return to the home page.”
    Step 9. Navigate back to the “https://www.tempmailaddress.com/”
    Step 10. Verify that you’ve received an email from
                   “do-not-reply@practice.cybertekschool.com”
    Step 11. Click on that email to open it.
    Step 12. Verify that email is from:
                   “do-not-reply@practice.cybertekschool.com”
    Step 13. Verify that subject is:
                   “Thanks for subscribing to practice.cybertekschool.com!”
     */
    @Test
    public void testCase6(){
        WebDriver driver  = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.tempmailaddress.com/");
        WaitUtils.wait(1);
        String emailAdress = driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        WaitUtils.wait(1);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Semra");
        driver.findElement(By.name("email")).sendKeys(emailAdress);
        WaitUtils.wait(1);
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        WaitUtils.wait(1);
        String actualMessage = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.navigate().forward();
        driver.navigate().to("https://www.tempmailaddress.com/");
        WaitUtils.wait(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("#schranka > tr:nth-child(1) > td.from")).getText().trim(), "do-not-reply@practice.cybertekschool.com");
        driver.findElement(By.cssSelector("#schranka > tr:nth-child(1) > td.from")).click();
        WaitUtils.wait(1);
        String actual = driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(actual.trim(), "do-not-reply@practice.cybertekschool.com");
        Assert.assertEquals(driver.findElement(By.id("predmet")).getText() , "Thanks for subscribing to practice.cybertekschool.com!");
        driver.quit();

    }
}
