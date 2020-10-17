package day9_092720;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class USPS_MouseMovement {
    public static void main(String[] args) throws InterruptedException {
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

        //navigate to website
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //declare mouse movement
        Actions actions = new Actions(driver);
        //move your mouse to quick tools to open drop down
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        actions.moveToElement(quickTools).perform();

        //entering tracking number
        Thread.sleep(2500);
        WebElement trackNumber = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        //actions.moveToElement(trackNumber).sendkeys("11122323244");
        trackNumber.sendKeys("111111");


    }
}
