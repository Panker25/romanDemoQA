package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.enums.Orange;
import com.demoqa.enums.TopBarMenuEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangePage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement userPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@class='oxd-topbar-body']")
    public WebElement topBarParent;


    public OrangePage fillupRegistration() {
        webElementActions.sendKeys(userNameInput, "Admin")
                .sendKeys(userPasswordInput, "admin123")
                .click(submitBtn);
        return this;
    }

    public OrangePage fillupPanelMenu(Orange panelMenu ) {
        WebElement element =
                DriverManager.getDriver().findElement(By.xpath("//ul[@class='oxd-main-menu']/li/a/span[text()='" + panelMenu.getPanelMenu()+"']"));
        element.click();
        return this;
    }


    public WebElement getNavigationBar() {
        return topBarParent;
    }

    public OrangePage fillupBarMenuItem(TopBarMenuEnums topBarMenuEnums) {
        WebElement navBar = getNavigationBar();
        WebElement mainMenuItem = navBar.findElement(By.xpath(".//li/span[contains(text(), '"
                + topBarMenuEnums.getTopBarMenu() + "')]"));
        mainMenuItem.click();
        return this;
    }
    public OrangePage fillupSubMenuItem(String topBarMenuItems) {
        WebElement itemsBar = getNavigationBar();
        WebElement subMenuItemElement = itemsBar.findElement(By.xpath(".//li/a[contains(text(), '"
                + topBarMenuItems + "')]"));
        subMenuItemElement.click();
        return this;
    }
}
