package Action_item;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class Action_item4 {
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
        //navigate to website
        driver.navigate().to("https://www.weightwatchers.com");
        Thread.sleep(1000); //delay for a second
        //capture home title and verify if matches expected title
        String actualTitle = driver.getTitle();
        if (actualTitle == "Weight Watches: Weight Loss & Wellness Help") {
            System.out.println("The title matches");
        } else {
            System.out.println("The title does not match. Actual title is " + actualTitle);
        } //Title match method completed
        //Create an array list for zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11423");
        zipCode.add("10803");
        zipCode.add("10003");

        //call the for loop to iterate through the array list
        for (int i = 0; i < zipCode.size(); i++) {
            //navigate to website
            driver.navigate().to("https://www.weightwatchers.com");
            //click on find a studio link
            driver.findElement(By.xpath("//*[@da-label='Find a Workshop']")).click();
                WebElement zCode = driver.findElement(By.xpath("//*[@id='location-search']")); //storing zipcode id here
                zCode.clear(); //clearing zipcode location
                zCode.sendKeys(zipCode.get(i)); //inputting value from array list here
                driver.findElement(By.xpath("//*[@id='location-search']")).submit();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//wait statement in order to capture work
                List<WebElement> workshop = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));
                //gets specific links
            try {
                if (zipCode.get(i) == "11423") {
                    workshop.get(1).click();
                    String address = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(0).getText();
                    //the full address is stored in two halves. They share the same class.
                    String address_2 = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(1).getText();
                    System.out.println("For zipcode 11423, the address is " + address + address_2);
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollBy(0,3500)");} //to scroll down to bottom of page

                if (zipCode.get(i) == "10803") {
                    workshop.get(0).click();
                    String address = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(0).getText();
                    ////the full address is stored in two halves. They share the same class.
                    String address_2 = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(1).getText();
                    System.out.println("For zipcode 10803, the address is " + address + address_2);
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollBy(0,3500)");} //to scroll down to bottom of page

                if (zipCode.get(i) == "10003") { //this is for the remaining zipcode
                    workshop.get(3).click();
                    String address = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(0).getText();
                    //the full address is stored in two halves. They share the same class.
                    String address_2 = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(1).getText();
                    System.out.println("For zipcode 1003, the address is " + address + address_2);
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollBy(0,3500)");} //to scroll down to bottom of page
                String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println("Schedule for current location " +schedule); //saving schedule and then printing
            } catch(Exception err) { //if any error exists this will print the error
                    System.out.println("Unable to input zipcode or go to specific link or print schedule " + err);}

                } //end of loop
            }
        }//end of action item

