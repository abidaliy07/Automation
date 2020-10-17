package Day6_91920;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
//storing search field locator as a webelement variable
        WebElement searchField= driver.findElement(By.xpath("//*[@name='p']"));
        //clear any pre defined value on the field
        searchField.clear();
        //enter your new keyword
        searchField.sendKeys("Manchester United");
        //submit on the same field after teh value
        searchField.submit();

        //using find element to click on 3rd link (news)
        //driver.findElements(By.xpath("//*[@class='_yb_e4mte']")).get(2).click();



    }
}
