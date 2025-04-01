package com.sahibinden.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewlyPhoneLandingPage {

    @Autowired
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='searchResultsSearchForm']/div/div[3]/div/div[3]/div/div[1]/div[2]/div/div")
    private WebElement sortingOptions;

    @FindBy(xpath = "//*[@id='searchResultsSearchForm']/div/div[3]/div/div[3]/div/div[1]/div[2]/div/div/ul/li/ul/li[3]")
    private WebElement lowToHighPriceOption;

    @FindBy(xpath = "//*[@id='searchResultsSearchForm']/div/div[3]/div/div[3]/div/div[1]/div[2]/div/div/ul/li/ul/li[4]")
    private WebElement highToLowPriceOption;

    @FindBy(xpath = "//*[@id='searchResultsSearchForm']/div/div[4]/div[1]/ul/li[1]/div/div[2]/div[3]/div/span")
    private WebElement firstCartPrice;

    @FindBy(xpath = "//*[@id='searchResultsSearchForm']/div/div[4]/div[1]/ul/li[2]/div/div[2]/div[3]/div/span")
    private WebElement secondCartPrice;

    @FindBy(id = "1141850")
    private WebElement goldColorFilterCheckbox;

    @FindBy(id = "1121842")
    private WebElement gbFourFilterCheckbox;

    @FindBy(xpath = "//*[@id='searchResultsSearchForm']/div/div[2]/div[8]/button")
    private WebElement searchBtn;


    public NewlyPhoneLandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void controlLowToHighPrice() {
        sortingOptions.click();
        lowToHighPriceOption.click();
        int firstPrice = Integer.parseInt(firstCartPrice.getText());
        int secondPrice = Integer.parseInt(secondCartPrice.getText());
        if(firstPrice < secondPrice) {
            System.out.println("The first cart price is lower than the second cart price.");
        } else {
            System.out.println("The first cart price is not lower than the second cart price.");
        }
    }

    public void controlHighToLowPrice() {
        sortingOptions.click();
        highToLowPriceOption.click();
        int firstPrice = Integer.parseInt(firstCartPrice.getText());
        int secondPrice = Integer.parseInt(secondCartPrice.getText());
        if(firstPrice > secondPrice) {
            System.out.println("The first cart price is higher than the second cart price.");
        } else {
            System.out.println("The first cart price is not higher than the second cart price.");
        }
    }

    public void colorFilterControl() {
        goldColorFilterCheckbox.click();
        searchBtn.click();
        String color = firstCartPrice.getText();
        if(color.contains("Altın")) {
            System.out.println("The first cart is gold.");
        } else {
            System.out.println("The first cart is not gold.");
        }
    }

    public void storageCapacityFilterControl() {
        gbFourFilterCheckbox.click();
        searchBtn.click();
        String gb = firstCartPrice.getText();
        if(gb.contains("4 GB")) {
            System.out.println("The first cart is 4 GB.");
        } else {
            System.out.println("The first cart is not 4 GB.");
        }
    }


}