package Action_item;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class inclass_AI extends Abstract_Class {

    @Test

    public void yahoo() throws InterruptedException {
        driver.navigate().to("https://yahoo.com");
        Thread.sleep(2000);

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals("Yahoo", driver.getTitle());
        Thread.sleep(2000);

        List<WebElement> linkCount= driver.findElements(By.xpath("//*[@class='_yb_122wn']"));
        //print out the link count
        System.out.println(("Link count is " + linkCount.size()));

        Reusable_Methods_Loggers.sendKeys(driver, "//*[@class='_yb_1a8w9']", "Nutrition", logger, "Searching");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver, "//*[@value='Search']","Clicking");
        Thread.sleep(2000);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3500)");
        Thread.sleep(2000);
        String result = driver.findElement(By.className("compPagination")).getText();
        String[] arrayResult = result.split("Next");
        //print out the search number
        System.out.println("My search number for is " + arrayResult[1]);
        Thread.sleep(2000);

        JavascriptExecutor jss= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-3500)");
        Reusable_Methods_Loggers.MouseHover(driver, "//*[@class='fl-l mr-5 last']", logger, "Hovering");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver, "//*[@class='fl-l mr-5 last']", "Clicking");
        Thread.sleep(2000);

        List<WebElement> imageCount= driver.findElements(By.xpath("//*[@data-bns='API']"));
        //USING DATA BNS INSTEAD OF CLASS GIVES A BETTER COUNT.
        //print out the link count
        System.out.println(("Image Count is " + imageCount.size()));
        Thread.sleep(2000);

        Reusable_Methods_Loggers.mouseClick(driver, "//*[@class='text signin']",logger, "Sign in");
        Thread.sleep(2000);
        boolean checkboxState= driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //checkbox should be selected
        if (checkboxState ==true) {
            System.out.println("Checkbox is selected as expected");
        } else{
            System.out.println("Checkbox is not selected by default");
        }

        Reusable_Methods_Loggers.mouseClick(driver, "//*[@id='login-username']",logger, "Username");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='login-username']", "aaaaa", logger, "Email Address" );
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@id='login-signin']",logger, "Username");
        Thread.sleep(2000);

        String CaptureMessage = Reusable_Methods_Loggers.captureResult(driver, "//*[@id='username-error']", logger, "Capturing");
        Thread.sleep(2000);
        System.out.println("Error message is " + CaptureMessage);
        if (CaptureMessage =="Sorry, we don't recognize this email") {
            logger.log(LogStatus.PASS, "Error Matches");
        } else{
            logger.log(LogStatus.FAIL, "Error doesn't match");
        }


        softAssert.assertAll();


















    }




}
