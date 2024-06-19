package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Класс, представляющий страницу с alert
public class AlertPage extends BasePage {

    // Находит элемент с id="confirmButton" и инициализирует его как WebElement
    @FindBy(id = "confirmButton")
    public WebElement confirmAlertBtn;

    // Этот элемент представляет собой кнопку, вызывающую confirm alert
}