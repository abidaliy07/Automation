package Day8_92620;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class inclass_actionitem {
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

        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name='q-destination']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Atlantic City, New Jersey, United States of America']")).click();

        driver.findElement(By.xpath("//*[@value='9/28/20']")).click();


    }
}