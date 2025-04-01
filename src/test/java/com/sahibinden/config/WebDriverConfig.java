package com.sahibinden.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@Configuration
public class WebDriverConfig {

    @Bean
    public WebDriver webDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // Selenoid özel yetenekleri
        HashMap<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true); // VNC desteği
        selenoidOptions.put("enableVideo", false); // Video kaydı (true yapabilirsiniz)
        selenoidOptions.put("enableLog", true); // Tarayıcı logları

        options.setCapability("selenoid:options", selenoidOptions);


        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Selenoid bağlantısı başarısız!", e);
        }
    }
}