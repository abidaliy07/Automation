package Day7_9202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class try_catch_in_mlcalc {
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
        driver.navigate().to("https:www.mlcalc.com");
        Thread.sleep(2000);

        //clear and enter purchase price
        try {
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        } catch (Exception err) {
            System.out.println("Unable to enter value on purchase price " + err);
        }// end of purchase price exception

        //clear and enter down payment
        try {
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys("40");
        } catch (Exception err) {
            System.out.println("Unable to enter value on downpayment " + err);
        }// end of downpayment exception

        //Select a start month
        try {
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        startMonth.clear();
        startMonth.sendKeys("Feb");
        } catch (Exception err) {
            System.out.println("Unable to enter value on start month " + err);
        }// end of startMonth exception

        //click on calculate
        try {
            driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
        } catch (Exception err) {
            System.out.println("Unable to click on calculate button" + err);

        }// end of calculate exception



    }//end of main method


}
