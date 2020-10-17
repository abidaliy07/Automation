package Day8_92620;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;

public class metlife_switchtabs {
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
        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();
        //click on take along dental link
        driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();
        Thread.sleep(1500);
        //none of the elements are easy to use, so go for the one in black and use text. For text no need for @
        //click on enroll now button
        driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
        Thread.sleep(2000);
        //contains because there is a lot of space, ignores space. Since, there is a lot of space don't do text= instead
        //do text comma
        ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));
        //enter the zipcode
        driver.findElement(By.xpath("//*[@name='txtZipCode']")).sendKeys("11218");
        Thread.sleep(2000);
        driver.close(); //to close the new tab if you don't need it again
        //switch back to previous tab
        driver.switchTo().window(tabs.get(0));
        //renavigate back to met life
        driver.navigate().to("https://www.metlife.com");










    }





}
