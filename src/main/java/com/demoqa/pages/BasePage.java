package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    public  BasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public WebElementActions webElementActions= new WebElementActions();
    DemoQAPages demoQAPages = new DemoQAPages();
}
