package Day7_9202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Example {
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

        //navigate to mlcalc website
        driver.navigate().to("https:www.mlcalc.com");
        Thread.sleep(1000);


        //use Webelement variable to store your start month dropdown
        WebElement startMonth= driver.findElement(By.xpath("//*[@name='sm']"));
        Select smDropDown = new Select(startMonth);
        smDropDown.selectByVisibleText("Feb");

        //selecting start month when the html tag is not select
        driver.findElement(By.xpath("//*[@name='sm']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Feb']")).click();


        //use webelemnt variable to store your start year dropdown
        WebElement startYear= driver.findElement(By.xpath("//*[@name='sy']"));
        Select syDropDown= new Select(startYear);
        syDropDown.selectByVisibleText("2022");






    }//end of main method
}
