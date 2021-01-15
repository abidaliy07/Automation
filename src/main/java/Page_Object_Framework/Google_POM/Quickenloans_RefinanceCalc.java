package Page_Object_Framework.Google_POM;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quickenloans_RefinanceCalc extends Abstract_Class {
    ExtentTest logger;
    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public Quickenloans_RefinanceCalc(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }   //end of constructor method
    //Click on I want to...inside RefinanceCalc
    @FindBy(xpath = "//*[@id='refinanceGoal']")
    WebElement RefinanceChoice;
    //Click on Refinanchoice
    @FindBy(xpath = "//*[@href='/calculator-refinance?qlsource=nav']")
    WebElement MortgageBalance;

    @FindBy(xpath = "//*[@id='cashOut']")
    WebElement CashoutAmount;

    @FindBy(xpath = "//*[@id='homeValue']")
    WebElement HomeValue;

    @FindBy(xpath = "//*[@id='zip']")
    WebElement ZipCode;

    @FindBy(xpath = "//*[@id='creditScore']")
    WebElement CreditScore;

    @FindBy(xpath = "//*[@id='calculateButton']")
    WebElement CalculateButton;

    @FindBy(xpath = "//*[@href='/calculator-mortgage?qlsource=nav']")
    WebElement ChangingCalcType;






    public Quickenloans_RefinanceCalc RefinanceChoice (String uservalue){
        Reusable_Methods_Loggers_Page_Object.dropDownMenu(driver,RefinanceChoice, uservalue , logger,"Clicking on Refinance Choice");
        return new Quickenloans_RefinanceCalc(driver);
    }//Choosing RefinanceType

    public Quickenloans_RefinanceCalc MortgageBalance (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,MortgageBalance,userValue, logger, "Clicking on Mrtge Balance");
        return new Quickenloans_RefinanceCalc(driver);
    }//Entering MortgageBalance

    public Quickenloans_RefinanceCalc CashoutAmount (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,CashoutAmount, userValue, logger, "Entering Cashout Amount");
        return new Quickenloans_RefinanceCalc(driver);
    }//Entering Cashout Amount

    public Quickenloans_RefinanceCalc HomeValue(String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,HomeValue,userValue, logger, "Entering HomeValue");
        return new Quickenloans_RefinanceCalc(driver);
    }//Entering HomeValue

    public Quickenloans_RefinanceCalc ZipCode(String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,ZipCode,userValue, logger, "Entering Zipcode");
        return new Quickenloans_RefinanceCalc(driver);
    }//Entering Zipcode

    public Quickenloans_RefinanceCalc CreditScore(String userValue){
        Reusable_Methods_Loggers_Page_Object.dropDownMenu(driver,CreditScore,userValue, logger, "Entering CreditScore");
        return new Quickenloans_RefinanceCalc(driver);
    }//Entering CreditScore

    public Quickenloans_RefinanceCalc CalculateButton(){
        Reusable_Methods_Loggers_Page_Object.click(driver,CalculateButton, logger, "Clicking Calculate");
        return new Quickenloans_RefinanceCalc(driver);
    }//Entering CreditScore

    public Quickenloans_RefinanceCalc ChangeCalcType(){
        Reusable_Methods_Loggers_Page_Object.click(driver,ChangingCalcType, logger, "Change Calculator to Purchase");
        return new Quickenloans_RefinanceCalc(driver);
    }//Changing Calc to PurchaseMortgage


}
