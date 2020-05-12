package com.automation.tests;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScript7and8 {
    WebDriver driver = BrowserFactory.getDriver("chrome");
    private By fileUpload = By.linkText("File Upload");
    private  By autocomplete = By.linkText("Autocomplete");
    private By country = By.id("myCountry");
    private By chooseFile = By.id("file-upload");
    private By fileSubmit = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");
    private By verifyMessage = By.id("result");
    private By submitButton = By.xpath("//input[@type='button']");


//Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    @BeforeMethod
    public void setup(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
    }


    /*
    Step 2. And click on “File Upload".
    Step 3. Upload any file with .txt extension from your computer.
    Step 4. Click “Upload” button.
    Step 5. Verify that subject is: “File Uploaded!”
    Step 6. Verify that uploaded file name is displayed.
     */
    @Test
    public void testCase7(){
        driver.findElement(fileUpload).click();
        WaitUtils.wait(2);
        driver.findElement(chooseFile).sendKeys("C:/Users/semra/IdeaProjects/Homework_3/dfs.PNG");
        WaitUtils.wait(2);
        driver.findElement(fileSubmit).click();
        Assert.assertEquals(driver.findElement(uploadedFile).getText(),"dfs.PNG" );
    }


    /*
    Step 2. And click on “Autocomplete”.
    Step 3. Enter “United States of America” into country input box.
    Step 4. Verify that following message is displayed: “You selected: United States of America”
     */
    @Test
    public void testCase8(){
        driver.findElement(autocomplete).click();
        driver.findElement(country).sendKeys("United States of America");
        WaitUtils.wait(2);
        driver.findElement(submitButton).click();
        Assert.assertEquals(driver.findElement(verifyMessage).getText(), "You selected: United States of America");

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
