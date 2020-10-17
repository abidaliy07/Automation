package Action_item;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods;
import Reusable_library.Reusable_Methods_Loggers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class Action_item7 extends Abstract_Class {
//declare the excel commands as global variance. Not part of abstract class.
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @Test
    public void express() throws InterruptedException,IOException, BiffException, WriteException {
        driver.navigate().to("https://www.express.com");
        Thread.sleep(2000);
        //verify title using softAssert
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals("Men's and Women's Clothing", driver.getTitle());

        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/ActionItem_7.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy to apply code on
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItem7.xls"),readableFile);
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {

            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String FirstName = writableSheet.getCell(2, i).getContents();
            String LastName = writableSheet.getCell(3, i).getContents();
            String Email = writableSheet.getCell(4, i).getContents();
            String PhoneNumber = writableSheet.getCell(5, i).getContents();
            String StreetAddress = writableSheet.getCell(6, i).getContents();
            String ZipCode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String CardNumber = writableSheet.getCell(10, i).getContents();
            String ExpireMonth = writableSheet.getCell(11, i).getContents();
            String ExpireYear = writableSheet.getCell(12, i).getContents();
            String CVV = writableSheet.getCell(13, i).getContents();

            //navigate to website
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.express.com");
            Thread.sleep(2000);
            //hovering over to mens
            Reusable_Methods_Loggers.MouseHover(driver, "//*[@href='/mens-clothing']", logger, "MouseHover");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@href='/mens-clothing/shirts/cat410008']", logger, "Click");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.clickByIndex(driver, "//*[@class='_2EWqA']", 2, logger, "Choosing Shirt");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[(@class='_3OQxl') and (@value='" + Size + "')]", logger, "Size of shirt");
            Thread.sleep(1500);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Add to Bag']", logger, "Adding to bag");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@aria-label='view bag']", logger, "Viewing bag");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@id='qdd-0-quantity']", Quantity, logger, " Quantity ");
            Thread.sleep(1500);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Checkout']", logger, "Checkout");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Checkout as Guest']", logger, "As guest");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='First Name: The first name field is required.']", FirstName, logger, "FirstName");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='Last Name: The last name field is required.']", LastName, logger, "LastName");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='Email Address: The email address field is required.']", Email, logger, "Email");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='Confirm Email Address']", Email, logger, "Confirm Email");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='Phone Number: The phone number field is required.']", PhoneNumber, logger, "Phone number");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Continue']", logger, "Continue");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='Street Address: The street address field is required.']", StreetAddress, logger, "Address");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='Postal Code: The postal code field is required.']", ZipCode, logger, "Zipcode");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='City: The city field is required.']", City, logger, "City");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='shipping.state']", State, logger, "State");
            Thread.sleep(1500);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Continue']", logger, "Continue");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Continue']", logger, "Continue");
            Thread.sleep(2000);
            try {
                Reusable_Methods_Loggers.MouseHover(driver, "//*[text()='NO, THANK YOU']", logger, "No, thank you");
                Thread.sleep(2000);
                Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='NO, THANK YOU']", logger, "no, thank you");
                Thread.sleep(2000);
            } catch(Exception err) {
                System.out.println("Pop up doesn't show");
            }
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='Credit Card Number: The credit card number field is required.']", CardNumber, logger, "Card Number");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='expMonth']", ExpireMonth, logger, " ExpireMonth ");
            Thread.sleep(1500);
            Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@name='expYear']", ExpireYear, logger, " ExpireYear ");
            Thread.sleep(1500);
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@aria-label='CVV: The cvv field is required.']", CVV, logger, "CVV");
            Thread.sleep(3000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[text()='Place Order']", logger, "PlaceOrder");
            Thread.sleep(2000);
            String ScreenShot = Reusable_Methods_Loggers.captureResult(driver, "//*[@id='rvn-note-NaN']", logger, "Capturing");
            Thread.sleep(2000);
            Label label = new Label(14, i, ScreenShot);
            //adding this label to the writable sheet
            writableSheet.addCell(label);

             //end of verify title
        }//loop done

            writableFile.write();
            writableFile.close();
            //Reusable_Methods_Loggers.getScreenShot(driver,logger, "SS");
            softAssert.assertAll();






}}
