package Action_item;

import Page_Object_Framework.Google_POM.BaseClass_QuickenLoans;
import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class QuickenLoans extends Abstract_Class {
    @Test(priority = 0)
    public void QuickenLoans_Home() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.quickenloans.com/");
        BaseClass_QuickenLoans.quickenloans_home().Calc();
        BaseClass_QuickenLoans.seeAllCalc().SeeAllCalc();
        BaseClass_QuickenLoans.quickenloans_home().Calc();
        Thread.sleep(2000);
        BaseClass_QuickenLoans.seeAllCalc().RefiCalc(); //shifting to refinance calc
    }//end of home page to SeeAllCalc to refinance Calc

    @Test (priority = 1)
    public void QuickenLoans_Refinance() throws InterruptedException, IOException, BiffException, WriteException {
        Thread.sleep(4000);
        try {
            Reusable_Methods_Loggers.MouseHover(driver, "//*[@data-lp-event='close']", logger, "Closing Box");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@data-lp-event='close'", logger, "Closing box");
            Thread.sleep(2000);
        } catch(Exception err) {
            System.out.println("Pop up doesn't show");
        }
        Workbook readableFile;
        Sheet readableSheet;
        WritableWorkbook writableFile;
        WritableSheet writableSheet;
        int rowCount;
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/RefinanceCalc.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy to apply code on
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Refinance_Calc.xls"), readableFile);
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop

        for (int i = 1; i < rowCount; i++) {
            String RefinanceType = writableSheet.getCell(0, i).getContents();
            String MortgageBalance = writableSheet.getCell(1, i).getContents();
            String CashoutAmount = writableSheet.getCell(2, i).getContents();
            String HomeWorth = writableSheet.getCell(3, i).getContents();
            String ZipCode = writableSheet.getCell(4, i).getContents();
            String CreditScore = writableSheet.getCell(5, i).getContents();


            BaseClass_QuickenLoans.refinanceCalc().RefinanceChoice(RefinanceType);
            BaseClass_QuickenLoans.refinanceCalc().MortgageBalance(MortgageBalance);
            BaseClass_QuickenLoans.refinanceCalc().CashoutAmount(CashoutAmount);
            BaseClass_QuickenLoans.refinanceCalc().HomeValue(HomeWorth);
            BaseClass_QuickenLoans.refinanceCalc().ZipCode(ZipCode);
            BaseClass_QuickenLoans.refinanceCalc().CreditScore(CreditScore);
            BaseClass_QuickenLoans.refinanceCalc().CalculateButton();
            BaseClass_QuickenLoans.quickenloans_home().Calc();
            Thread.sleep(4000);
            BaseClass_QuickenLoans.refinanceCalc().ChangeCalcType(); //changing to PurchaseCalculator
        }
    }//end of refinance Calc, shifted to purchase Calculator

    @Test (priority = 2)
    public void QuickenLoans_PurchaseCalculator() throws InterruptedException, IOException, BiffException, WriteException {
        Thread.sleep(4000);
        try {
            Reusable_Methods_Loggers.MouseHover(driver, "//*[@data-lp-event='close']", logger, "Closing Box");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@data-lp-event='close'", logger, "Closing box");
            Thread.sleep(2000);
        } catch(Exception err) {
            System.out.println("Pop up doesn't show");
        }
        Workbook readableFile;
        Sheet readableSheet;
        WritableWorkbook writableFile;
        WritableSheet writableSheet;
        int rowCount;
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/PurchaseCalculator.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy to apply code on
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Purchase_Calculator.xls"), readableFile);
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop

        for (int i = 1; i < rowCount; i++) {
            String PurchasePrice = writableSheet.getCell(0, i).getContents();
            String Downpayment = writableSheet.getCell(1, i).getContents();
            String LoanTerm = writableSheet.getCell(2, i).getContents();
            String Interest = writableSheet.getCell(3, i).getContents();
            String Taxes = writableSheet.getCell(4, i).getContents();
            String HomeInsurance = writableSheet.getCell(5, i).getContents();
            String HOA = writableSheet.getCell(6, i).getContents();

            BaseClass_QuickenLoans.purchaseCalculator().PurchasePrice(PurchasePrice);
            BaseClass_QuickenLoans.purchaseCalculator().Dpayment(Downpayment);
            BaseClass_QuickenLoans.purchaseCalculator().LoanTerm(LoanTerm);
            BaseClass_QuickenLoans.purchaseCalculator().Interest(Interest);
            BaseClass_QuickenLoans.purchaseCalculator().Taxes(Taxes);
            BaseClass_QuickenLoans.purchaseCalculator().HomeInsurance(HomeInsurance);
            BaseClass_QuickenLoans.purchaseCalculator().HOA(HOA);
            BaseClass_QuickenLoans.quickenloans_home().Calc();
            Thread.sleep(4000);
            BaseClass_QuickenLoans.purchaseCalculator().RentvBuy(); //changing to rentvbuy calc
        }
    }//end of purchase Calc, shifted to rentvbuy calc
    @Test (priority = 3)
    public void QuickenLoans_RentvBuyCalc() throws InterruptedException, IOException, BiffException, WriteException {
        Thread.sleep(4000);
        try {
            Reusable_Methods_Loggers.MouseHover(driver, "//*[@data-lp-event='close']", logger, "Closing Box");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@data-lp-event='close'", logger, "Closing box");
            Thread.sleep(2000);
        } catch(Exception err) {
            System.out.println("Pop up doesn't show");
        }
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 150);");
        Workbook readableFile;
        Sheet readableSheet;
        WritableWorkbook writableFile;
        WritableSheet writableSheet;
        int rowCount;
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/RentVsBuyCalc.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy to apply code on
        writableFile = Workbook.createWorkbook(new File("src/main/resources/RentVsBuyCalcs.xls"), readableFile);
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop

        for (int i = 1; i < rowCount; i++) {
            String ZipCode = writableSheet.getCell(0, i).getContents();
            String CreditScore = writableSheet.getCell(1, i).getContents();
            String PurchasePrice = writableSheet.getCell(2, i).getContents();
            String Downpayment = writableSheet.getCell(3, i).getContents();
            String Interest = writableSheet.getCell(4, i).getContents();
            String Rent = writableSheet.getCell(5, i).getContents();


            BaseClass_QuickenLoans.rentvBuyCalc().ZipCode(ZipCode);
            BaseClass_QuickenLoans.rentvBuyCalc().CreditScore(CreditScore);
            BaseClass_QuickenLoans.rentvBuyCalc().PurchasePrice(PurchasePrice);
            BaseClass_QuickenLoans.rentvBuyCalc().DownPayment(Downpayment);
            BaseClass_QuickenLoans.rentvBuyCalc().Interest(Interest);
            BaseClass_QuickenLoans.rentvBuyCalc().MonthlyRent(Rent);
            BaseClass_QuickenLoans.refinanceCalc().CalculateButton();
            BaseClass_QuickenLoans.quickenloans_home().Calc();
            Thread.sleep(4000);
            BaseClass_QuickenLoans.rentvBuyCalc().HomeAffordable(); //changing to homeaffordabilitycalc
        }
    }//end of rentvbuy calc, changing to affordable calc

}



