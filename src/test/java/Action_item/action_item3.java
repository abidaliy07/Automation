package Action_item;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class action_item3 {
    public static void main(String[] args) throws InterruptedException {
        //Setting chrome driver location
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
        //lets create dynamic array to handle multiple boroughs on BING search
        String[] Boroughs = new String[5];
        Boroughs[0]= "Manchester United";
        Boroughs[1]="Iron Maiden";
        Boroughs[2]="Manchester United Jersey";
        Boroughs[3]="Wayne Rooney";
        Boroughs[4]="Nemanja Vidic";
        for (int i = 0; i < Boroughs.length; i++) {
            driver.navigate().to("https://www.bing.com"); //navigate to bing page
            Thread.sleep(1000);
            driver.findElement(By.name("q")).sendKeys(Boroughs[i]);
            Thread.sleep(2000);
            driver.findElement(By.name("q")).submit();
            //delay to load search result
            Thread.sleep(1000);
            //capture the search result text
            String result = driver.findElement(By.id("b_tween")).getText();
            String[] arrayResult = result.split(" ");
            //print out the search number
            System.out.println("My search number for " + Boroughs[i] + " is " + arrayResult[0]);

            Thread.sleep(2000);

        }//end of for loop
        driver.quit();











    }
}
