package Action_item;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;


public class AdditionalActiom_Item {
    public static void main(String[] args) throws InterruptedException {
        //Setting chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions Yahoo = new ChromeOptions();
        //set the driver to be maximized
        Yahoo.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        Yahoo.addArguments("incognito");
        //run the driver in headless mode
        //.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(Yahoo);
        //lets create dynamic array to handle multiple boroughs on BING search
        String[] Boroughs = new String[5];
        Boroughs[0]= "Manchester United";
        Boroughs[1]="Iron Maiden";
        Boroughs[2]="Manchester United Jers+ey";
        Boroughs[3]="Wayne Rooney";
        Boroughs[4]="Nemanja Vidic";
        for (int i = 0; i < Boroughs.length; i++) {
            driver.navigate().to("https://www.yahoo.com"); //navigate to bing page
            Thread.sleep(1000);
            driver.findElement(By.name("p")).sendKeys(Boroughs[i]);
            Thread.sleep(2000);
            driver.findElement(By.name("p")).submit();
            //delay to load search result
            Thread.sleep(2000);
            //to perform scroll on yahoo using Selenium
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,3500)");
            //capture the search result text
            String result = driver.findElement(By.className("compPagination")).getText();
            String[] arrayResult = result.split("Next");
            //print out the search number
            System.out.println("My search number for " + Boroughs[i] + " is " + arrayResult[1]);

            Thread.sleep(2000);

        }//end of for loop
        driver.quit();
    }
}
