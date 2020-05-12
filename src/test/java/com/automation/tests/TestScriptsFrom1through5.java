package com.automation.tests;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScriptsFrom1through5 {
    WebDriver driver= BrowserFactory.getDriver("chrome");
    private By registrationFormBy = By.xpath("//a[.='Registration Form']");
    private By dateOfBirthBy = By.name("birthday");
    private By invalidDateMessageBy = By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]");
    private By signUpBy = By.id("wooden_spoon");
    private By cplusplusBy  =By.xpath("//label[@for='inlineCheckbox1']");
    private By javaBy  =By.xpath("//label[@for='inlineCheckbox2']");
    private By javaScriptBy  =By.xpath("//label[@for='inlineCheckbox3']");
    private By firstNameBy = By.xpath("//input[@name='firstname']");
    private By firstNameOneLetterWarningMessage = By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]");
    private By lastNameBy =  By.xpath("//input[@name='lastname']");
    private By lastNameOneLetterWarningMessage = By.xpath("//*[@data-bv-for='lastname'][2]");
    private By usernameBy = By.xpath("//input[@name='username']");
    private By emailBy = By.xpath("//input[@name='email']");
    private By passwordBy = By.xpath("//input[@name='password']");
    private By phoneNumberBy = By.xpath("//input[@name='phone']");
    private By genderBy = By.xpath("//input[@value='female']");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By signUpMessage = By.tagName("p");


/*
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
 */

    @BeforeMethod
    public void setup(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(registrationFormBy).click();
        WaitUtils.wait(2);
    }


/*
Step 3. Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”
 */
    @Test
    public void testCase1(){
       driver.findElement(dateOfBirthBy).sendKeys("wrong_dob");
        WaitUtils.wait(2);
        String actual = driver.findElement(invalidDateMessageBy).getText();
        Assert.assertEquals(actual,"The date of birth is not valid");
    }


//Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
    @Test
    public void testCase2(){
        if (driver.findElement(cplusplusBy).isDisplayed()){
            System.out.println("C++ is displayed");
        }
        if (driver.findElement(javaBy).isDisplayed()){
            System.out.println("Java is displayed");
        }
        if (driver.findElement(javaScriptBy).isDisplayed()){
            System.out.println("JavaScript is displayed");
        }
    }


    /*
    Step 3. Enter only one alphabetic character into first name input box.
    Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void testCase3(){
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        WaitUtils.wait(2);
        driver.findElement(firstNameBy).sendKeys("a");
        WaitUtils.wait(2);
        String actualMessage = driver.findElement(firstNameOneLetterWarningMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }



    /*
    Step 3. Enter only one alphabetic character into last name input box.
    Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
     */
     @Test
     public void testCase4(){
         String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
         WaitUtils.wait(2);
         driver.findElement(lastNameBy).sendKeys("a");
         WaitUtils.wait(2);
         String actualMessage = driver.findElement(lastNameOneLetterWarningMessage).getText();
         Assert.assertEquals(actualMessage, expectedMessage);
    }


/*
3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
 */
        @Test
        public void testCase5(){
        driver.findElement(firstNameBy).sendKeys("Semra");
            WaitUtils.wait(1);
        driver.findElement(lastNameBy).sendKeys("Bahadir");
            WaitUtils.wait(1);
        driver.findElement(usernameBy).sendKeys("useruser");
            WaitUtils.wait(1);
        driver.findElement(emailBy).sendKeys("sbahadir@email.com");
            WaitUtils.wait(1);
        driver.findElement(passwordBy).sendKeys("Aabc1234");
            WaitUtils.wait(1);
        driver.findElement(phoneNumberBy).sendKeys("123-123-1212");
            WaitUtils.wait(1);
        driver.findElement(genderBy).click();
            WaitUtils.wait(1);
        driver.findElement(dateOfBirthBy).sendKeys("01/01/1997");
            WaitUtils.wait(1);
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Engineering");
            WaitUtils.wait(1);
        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");
            WaitUtils.wait(1);
        driver.findElement(javaBy).click();
            WaitUtils.wait(1);
        driver.findElement(signUpBy).click();
            WaitUtils.wait(1);
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(signUpMessage).getText();
        Assert.assertEquals(actualMessage ,expectedMessage);

        }

    @AfterMethod
    public void teardown(){
      driver.quit();
    }

}
