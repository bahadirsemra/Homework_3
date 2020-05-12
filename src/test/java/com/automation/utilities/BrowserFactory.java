package com.automation.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
        public static WebDriver getDriver (String browserType){
        if (browserType.toLowerCase().equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            return  driver;
        }
        else if (browserType.toLowerCase().equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            return driver;
        }
        else if (browserType.toLowerCase().equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            return  driver;
        }

        else if (browserType.toLowerCase().equalsIgnoreCase("Safari")) {
            System.out.println("Select one of the following options: Chrome , Firefox, Edge");
            return null;
        }

        else{
            System.out.println("Select one of the following options: Chrome , Firefox, Edge");
            return null;
        }
    }
}
