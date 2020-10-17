package Day7_9202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class mlcalc_withLoop {
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

        //set teh value for purchase price array list
        ArrayList<String> pPriceList = new ArrayList<>();
        pPriceList.add("350000");
        pPriceList.add("400000");


        //set the values for downpayment array list
        ArrayList<String> dPaymentlist = new ArrayList<>();
        dPaymentlist.add("30");
        dPaymentlist.add("50");

        //call the for loop to iterate through the array list
        for (int i = 0; i < pPriceList.size(); i++) {
            //navigate to mlcalc page
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);
            //clear and enter purchase price
            try {
                WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
            } catch (Exception err) {
                System.out.println("Unable to enter value on purchase price " + err);
            }// end of purchase price exception

            //clear and enter down payment
            try {
                WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
                dPayment.clear();
                dPayment.sendKeys(dPaymentlist.get(i));
            } catch (Exception err) {
                System.out.println("Unable to enter value on downpayment " + err);
            }// end of downpayment exception

            //clicking on calculate button
            try {
                driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
            } catch (Exception err) {
                System.out.println("Unable to click on calculate button" + err);
            }//end of calculate button exception

            Thread.sleep(4000);

            try {
                String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
                System.out.println("My monthly payments is " + mntPayment);
            } catch (Exception err) {
                System.out.println("Unable to capture the Monthly payment" + err);

            }

        }//end of loop
    } //end of main method
}//end of class






































