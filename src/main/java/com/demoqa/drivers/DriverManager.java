package com.demoqa.drivers;

import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getValue("browser").toLowerCase()){
                case "chrome":
                    driver= ChromeWebDriver.loadChromedriver();
                    break;
                case "firefox":
                    break;

                default:
                    throw new IllegalArgumentException("Wrong Driver name");
            }
        }
        return driver;
    }

    public static void closeDriwer(){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
                driver=null;
            }
        }catch (Exception e){
            System.err.println("Error while closing driver");
        }
    }
}
