package Day6_91920;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPath_Yahoo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        //type a keyword on yahoo search field
        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("Manchester United");
        //click/submit on search button
        driver.findElement(By.xpath("//*[@value='Search']")).click();


    }//end of main method
}//end of class
