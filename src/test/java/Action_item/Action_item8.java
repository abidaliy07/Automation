package Action_item;

import Reusable_library.Abstract_Class_Cross_Browser;
import Reusable_library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


import java.awt.*;

public class Action_item8 extends Abstract_Class_Cross_Browser {

    @Test

    public void FedEx() throws InterruptedException, AWTException {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        Thread.sleep(2000); //going to fedex website

        Reusable_Methods_Loggers.mouseClick(driver, "//*[@aria-label='Open Design & Print menu']", logger, "Clicking on Design");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.MouseHover(driver, "//*[@alt='Upload a Print-Ready File']", logger, "Hovering over to Upload a print-ready File");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@alt='Upload a Print-Ready File']", logger,"Clicking on upload a print-ready file");
        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Fedex Office Print Online")) {
            logger.log(LogStatus.PASS, "Error Matches");
        } else{
            logger.log(LogStatus.FAIL, "Error doesn't match");
        }

        Reusable_Methods_Loggers.mouseClick(driver, "//*[@alt='Document Printing']", logger,"Document Printing");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@title='Get Started - Copies & Custom Projects']", logger,"Custom Picture");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@name='upload-files-button']", logger,"Uploading picture");
        Thread.sleep(4000);
        Reusable_Methods_Loggers.uploadFile("C:\\Users\\Dell\\Desktop\\New folder\\Project\\src\\main\\resources\\George_best.jpg");
        Thread.sleep(4000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='CONTINUE WITH EXISTING']", logger,"Not reuploading picture"); //low resolution
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@class='quantity-field']", logger, "Clicking on quantity");
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@class='quantity-field']", "5", logger, "Inputting Quantity");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@name='update_quanity-addToCart-lbl']", logger,"Add to cart");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@name='cart_page-chkOut-lbl']", logger,"Checkout");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[@id='continueAsGuest']", logger,"Checkout as guest");
        Thread.sleep(3000);
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']", "5 Miles", logger, " As Radius");
        Thread.sleep(5000);
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='loc_seacrh_text']", "11423", logger, "Inputting Zipcode");
        Thread.sleep(4000);
        Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Continue']", logger, "Continue");
        Thread.sleep(2000);
        String ScreenShot = Reusable_Methods_Loggers.captureResult(driver, "//*[@class='active']", logger, "Capturing suggested address");
        Thread.sleep(2000);
        System.out.println(ScreenShot);

    } //end of test

}//
