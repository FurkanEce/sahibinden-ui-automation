package com.sahibinden.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import com.sahibinden.config.WebDriverConfig;
import com.sahibinden.pages.HomePage;
import com.sahibinden.pages.NewlyPhoneLandingPage;
import com.sahibinden.pages.YepyPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@SpringBootTest
@ContextConfiguration(classes = {WebDriverConfig.class, HomePage.class})
@ComponentScan(basePackages = "com.sahibinden")
@Epic("Price Soritng Tests")
@Feature("Price Soritng Tests in Yepy Page")
public class YepyPageTest {

    @Autowired
    private WebDriver driver;

    private HomePage homePage;

    private YepyPage yepyPage;

    private NewlyPhoneLandingPage newlyPhoneLandingPage;

    @BeforeEach
    public void setup() {
        homePage = new HomePage(driver);
        yepyPage = new YepyPage(driver);
        newlyPhoneLandingPage = new NewlyPhoneLandingPage(driver);
    }

    @Test
    @Story("Click Yepy Link")
    @Description("Test to verify that the Yepy link can be clicked successfully.")
    @Severity(SeverityLevel.CRITICAL)
    public void testClickYepyLink() {
        driver.get("https://www.sahibinden.com");
        homePage.clickYepyLink();
        yepyPage.clickNewlyPhone();
        // add assertion url to check if the page is correct
        String expectedUrl = "https://www.sahibinden.com/yepy/yenilenmis-telefonlar?referrer=LandingPage";
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl) : "URL did not match. Expected: " + expectedUrl + ", but got: " + actualUrl;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}