package Action_item;

import Reusable_library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Action_item6 {
    //declare all the global variables outside
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //setting chrome driver
        driver = Reusable_Methods.getDriver();
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Action_item6.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy to apply code on
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItem_6.xls"),readableFile);
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of before suite


    @Test(priority = 1)
    public void VerifyTitle(){
        driver.navigate().to("https://www.kayak.com");
        //verify title
        String actualTitle = driver.getTitle();
        System.out.println("Page Title :" +actualTitle);
        if (actualTitle.contains("KAYAK")) {
            System.out.println("The title matches");
        } else {
            System.out.println("The title does not match. Actual title is " + actualTitle);
    }}//end of test 1

    @Test(priority = 2)

    public void PickUP() throws WriteException, InterruptedException {

//all the test steps have to go inside for loop
            for (int i = 1; i < rowCount; i++) {
                //I need to get the content of the cell
                //column is hard coded and row is dynamic(i)
                String Airport = writableSheet.getCell(0, i).getContents();
                String StartDate = writableSheet.getCell(1, i).getContents();
                String StartTime = writableSheet.getCell(2, i).getContents();
                String EndDate = writableSheet.getCell(3, i).getContents();
                String EndTime = writableSheet.getCell(4, i).getContents();
                String Vehicle_Size = writableSheet.getCell(5, i).getContents();

                //navigate to website
                driver.manage().deleteAllCookies();
                driver.navigate().to("https://www.Kayak.com");
                Thread.sleep(2000);
                //enter airport
               Reusable_Methods.click(driver, "//*[contains(@id,'pickup-display')]", "Search");
               Reusable_Methods.sendKeys(driver, "//*[@name='pickup']", Airport, "Airport");
               Thread.sleep(2000);

               //enter StartDate
                Reusable_Methods.mouseClick(driver, "//*[contains(@id,'dateRangeInput-display-start-inner')]", "StartDate");
                Thread.sleep(2000);
                Reusable_Methods.typeAndSubmit(driver, "//*[contains(@id, 'pickup-date-input')]", StartDate, "StartDate");
                Thread.sleep(2000);
                //enter EndDate
                Reusable_Methods.mouseClick(driver, "//*[contains(@id,'dateRangeInput-display-end-inner')]", "EndDate");
                Thread.sleep(2000);
                Reusable_Methods.typeAndSubmit(driver, "//*[contains(@id,'dropoff-date-input')]", EndDate, "EndDate");
                Thread.sleep(2000);
                //clicking anywhere outside to avoid element not traceable
                Reusable_Methods.click(driver, "//*[@class='title dark']", "Dark Title");
                Thread.sleep(2000);
                //clicking on startTime
                Reusable_Methods.mouseClick(driver, "//*[contains(@id,'start-time-select-display')]", "Start Time");
                Thread.sleep(3000);
                Reusable_Methods.mouseClick(driver, "//*[contains(@id,'start-time-select-option') and @data-title='" + StartTime + "']", "Starting Time");
                Thread.sleep(1500);
                //Enter end time
                Reusable_Methods.mouseClick(driver, "//*[contains(@id,'dateRangeInput-end-time-select-display-status')]", "End Time");
                Thread.sleep(2000);
                Reusable_Methods.mouseClick(driver, "//*[contains(@id,'end-time-select-option') and @data-title='" + EndTime + "']", "Ending time");
                Thread.sleep(1500);
                //Click on search
                Reusable_Methods.mouseClick(driver, "//*[contains(@id,'submit')]", "Search");
                Thread.sleep(3000);
                //Selecting Small
                driver.findElement(By.xpath("//*[contains(text(),'Small')]")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[contains(text(),'More options')]")).click(); //similar to Dark Title, new tab wasn't opening. A box showing the deal would just open.
                Thread.sleep(3000);
                //clicking on the 3rd deal
                Reusable_Methods.clickByIndex(driver, "//*[contains(text(),'View Deal')]", 3, "Vehicle Size");
                Thread.sleep(3000);
                //USE TRY CATCH here for different types of view deals
                //Only 1 tab opens for me.
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //switch to second tab
                driver.switchTo().window(tabs.get(1));
                Thread.sleep(2000);
                String TotalDue = Reusable_Methods.captureText(driver, "//span[contains(text(),'$')]", "Total Due");
                Thread.sleep(2000);
                System.out.println("My vehicle cost is " + TotalDue);
                Thread.sleep(2000);
                Label label = new Label(5, i, TotalDue);
                //adding this label to the writable sheet
                writableSheet.addCell(label);
                driver.close(); //to close the new tab if you don't need it again
                //switch back to previous tab
                driver.switchTo().window(tabs.get(0));
                //renavigate back to Kayak
                //driver.navigate().to("https://www.kayak.com");
            }//end of loop
    }//end of test

                @AfterSuite
                public void closingInfo() throws IOException, WriteException {
                    writableFile.write();
                    writableFile.close();
                    driver.quit();
                }//end of after suite

}//end of class











