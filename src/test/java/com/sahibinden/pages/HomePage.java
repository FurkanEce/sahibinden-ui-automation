package com.sahibinden.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

    @Autowired
    private WebDriver driver;

    @FindBy(id = "yepy-link-primary")
    private WebElement yepyLink;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickYepyLink() {
        yepyLink.click();
    }

}