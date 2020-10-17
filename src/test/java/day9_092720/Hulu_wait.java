package day9_092720;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hulu_wait {
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

        //set implicit wait before your test steps
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.hulu.com");

        //click on start free trial
        //driver.findElement(By.xpath("//*[text()='START YOUR FREE TRIAL']")).click();
        //above element doesn't work. Find another unique property
        driver.findElement(By.xpath("//*[@class='button--cta button--white Masthead__input-cta']")).click();






    }
}
