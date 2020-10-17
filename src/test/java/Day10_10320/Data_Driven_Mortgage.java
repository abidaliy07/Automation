package Day10_10320;

import Reusable_library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Data_Driven_Mortgage {
    public static void main(String[] args) throws IOException, BiffException {
        //setting the chrome driver
        WebDriver driver = Reusable_Methods.getDriver();
        //step 1: locate teh readable excel workbook
       Workbook readableFile= Workbook.getWorkbook(new File("src/main/resources/Excel_Selenium.xls"));
       //step 2: locate the excel sheet for this readable workbook
        Sheet readableSheet = readableFile.getSheet(0);
        //step 3: make a copy of readable file to write back to the excel so it doesnt corrupt the original file
        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/main/resources/Mortgage_info_results.xls"));
        //step 4: define the writeable sheet for writeable file
        WritableSheet writableSheet = writeableFile.getSheet(0);
        //step 5: get the count of the rows that are not empty on your excel workbook
        int rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop
        for(int i = 1; i < rowCount; i++) {
            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String homeVal = writableSheet.getCell(0,i).getContents();
            String downPay = writableSheet.getCell(1,i).getContents();
            String loanAmount = writableSheet.getCell(2,i).getContents();
            String startMonth = writableSheet.getCell(3,i).getContents();
            String startYear = writableSheet.getCell(4,i).getContents();




        }




    }//end of main method
}//end of class
