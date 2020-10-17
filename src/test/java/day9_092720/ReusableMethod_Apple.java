package day9_092720;

import Reusable_library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReusableMethod_Apple {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);

        //navigate to apple.com
        driver.navigate().to("https://www.apple.com");
        //call the reusable click method to click on mac
        Reusable_Methods.click( driver, "//*[@data-analytics-title='mac']", "Mac Link");
        Reusable_Methods.click( driver, "//*[@class='chapternav-label']", "MacBook Air");
        Reusable_Methods.click( driver, "//*[@class='ac-gn-link ac-gn-link-search']", "Search");
        Reusable_Methods.sendKeys( driver, "//*[@placeholder='Search apple.com']", "iphone", "Search Value ");
        Reusable_Methods.submit( driver, "//*[@placeholder='Search apple.com']", "Search");

    } //end of method

} //end of class
