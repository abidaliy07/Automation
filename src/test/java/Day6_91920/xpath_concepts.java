package Day6_91920;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class xpath_concepts {
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

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000); //delay 2 sec

        //locate search field by id or name
        driver.findElement(By.xpath("//*[@id='ybar-sbq' or @name='p']")).sendKeys("cars");
        Thread.sleep(2000); //delay 2 seconds

        driver.navigate().to("https://www.yahoo.com"); //navigate to yahoo page
        Thread.sleep(2000); //delay 2 sec
        //using CONTAINS to only specify matching words and ignoring spaces within a property
        driver.findElements(By.xpath("//*[contains(@class='yb_e4mte')]")).get(2).click();



    }
}
