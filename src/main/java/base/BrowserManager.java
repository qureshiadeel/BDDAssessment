package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrowserManager {
    public static WebDriver doBrowserSetup(String browser) {
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        if(browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("force-device-scale-factor=0.75");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setPlatform(Platform.ANY);

            try {
                driver = new ChromeDriver(chromeOptions.merge(desiredCapabilities));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setAcceptInsecureCerts(true);
            desiredCapabilities.setBrowserName("firefox");
            desiredCapabilities.setPlatform(Platform.ANY);
            desiredCapabilities.setCapability("moz:debuggerAddress", true);
            // Set up the WebDriver for Firefox

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            firefoxOptions.addArguments("--remote-allow-origins=*");
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return driver;
    }

    public static Properties loadPropertyFile() {
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream =new FileInputStream("Configuration/config.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<Object, Object> each : properties.entrySet()) {

            String pattern = "\\$\\{([A-Za-z0-9.]+)\\}";
            Pattern expr = Pattern.compile(pattern);
            Matcher matcher = expr.matcher(each.getValue().toString());
            while (matcher.find()) {
                String envValue = System.getenv(matcher.group(1));
                if (envValue == null) {
                    envValue = "";
                } else {
                    envValue = envValue.replace("\\", "\\\\");
                }
                Pattern subexpr = Pattern.compile(Pattern.quote(matcher.group(0)));
                each.setValue(subexpr.matcher(each.getValue().toString()).replaceAll(envValue));
            }
        }
        return properties;
    }

}
