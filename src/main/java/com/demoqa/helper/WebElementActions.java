package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class WebElementActions {


    public WebElementActions click(WebElement element){
        waitElementToBeClickAble(element);
        scrollToEltment(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String txt){
        waitElementToBeVisible(element);
        scrollToEltment(element);
        element.sendKeys(txt);
        return this;
    }
    public WebElementActions sendKeysWithEnter(WebElement element, String txt){
        waitElementToBeVisible(element);
        scrollToEltment(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }


    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
    public WebElementActions waitElementToBeVisible(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions scrollToEltment (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this;


    }
    Actions actions = new Actions(DriverManager.getDriver());

}
