package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    // ThreadLocal WebDriver for parallel execution
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize Driver
    public static void initDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = getChromeOptions();
            driver.set(new ChromeDriver(options));

            System.out.println("Browser Started : " + Thread.currentThread().getName());

        } else {
            throw new RuntimeException("Browser not supported : " + browser);
        }
    }

    // Get Driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Chrome Options
    private static ChromeOptions getChromeOptions() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        // options.addArguments("--headless=new");
        // options.addArguments("--disable-gpu");
        // options.addArguments("--no-sandbox");
        // options.addArguments("--disable-dev-shm-usage");
        // options.addArguments("--disable-popup-blocking");
        // options.addArguments("--disable-extensions");

        return options;
    }

    // Open Application
    public static void applicationOpen() {

        System.out.println("Application Started");

        String url = ConfigReader.getProperty("url");

        getDriver().get(url);
    }

    // Close Browser
    public static void close() {

        if (getDriver() != null) {

            System.out.println("Browser Closing : " + Thread.currentThread().getName());

            getDriver().quit();

            driver.remove(); // Important: Remove driver from ThreadLocal
        }
    }
}
