package com.sahibinden.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YepyPage {

    @Autowired
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='container']/div[2]/div[1]/div/div[1]/div[4]/a[1]")
    private WebElement newlyPhone;

    public YepyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickNewlyPhone() {
        newlyPhone.click();
    }

}