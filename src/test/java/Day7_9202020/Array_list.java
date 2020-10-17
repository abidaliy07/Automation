package Day7_9202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Array_list {
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

        //click on different months from the drop down using array list
        ArrayList<String> smList= new ArrayList<>();
        smList.add("Jan");
        smList.add("Feb");
        smList.add("Mar");
        smList.add("Apr");
        smList.add("May");

        //navigate to mlcalc website
        driver.navigate().to("https:www.mlcalc.com");
        Thread.sleep(2000);
        //using for loop I want to iterate through all the month list and click on each one
        for (int i= 0; i< smList.size(); i++){
            //use webelement variable to store your month dropdown
            WebElement startMonth= driver.findElement(By.xpath("//*[@name='sm']"));
            Select smDropDown = new Select (startMonth);
            smDropDown.selectByVisibleText(smList.get(i));
            //if there is no select tag
            driver.findElement(By.xpath("//*[@name='sm]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[text()='"+smList+"']")).click();


        }


    }
}
