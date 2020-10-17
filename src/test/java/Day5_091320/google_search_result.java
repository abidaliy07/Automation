package Day5_091320;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search_result {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver();

        //let's get to google home page
        //driver.get ("https: //www.google.com");
        driver.navigate().to("https://www.google.com");
        //maximize my window
        driver.manage().window().maximize();
        //put two second delay
        Thread.sleep(2000);
        //locate search field by name and enter a keyword on the field
        driver.findElement(By.name("q")).sendKeys("Manchester United");
        Thread.sleep(1000);
        //click on google search
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("btnK")).submit();
        //delay to load search result
        Thread.sleep(2000);
        //capture the search result text
        String result = driver.findElement(By.id("result-stats")).getText();
        String[] arrayResult = result.split(" ");
        //print out the search number
        System.out.println("My search number is " + arrayResult[1]);

        Thread.sleep(2000);
        driver.quit();

    }
}
