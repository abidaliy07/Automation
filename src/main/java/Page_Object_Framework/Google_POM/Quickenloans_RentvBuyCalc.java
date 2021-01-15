package Page_Object_Framework.Google_POM;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quickenloans_RentvBuyCalc extends Abstract_Class {
    ExtentTest logger;

    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public Quickenloans_RentvBuyCalc(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }   //end of constructor method
//scroll down for rent vs buy calculator
        @FindBy(xpath = "//*[@name='location']")
        WebElement ZipCode;
        @FindBy(xpath = "//*[@name='creditScore']")
        WebElement CreditScore;
        @FindBy(xpath = "//*[@name='purchasePrice']")
        WebElement PurchasePrice;
        @FindBy(xpath = "//*[@id='downPaymentAmt']")
        WebElement DownPayment;
        @FindBy(xpath = "//*[@name='interestRate']")
        WebElement Interest;
        @FindBy(xpath = "//*[@id='rent']")
        WebElement MonthlyRent;
        @FindBy(xpath = "//*[@data-analytics-click='Calculate']")
        WebElement Calculate;
        @FindBy(xpath = "//*[@href='/calculator-affordability?qlsource=nav']")
        WebElement HomeAffordable; //shifting to home affordability calculator

    public Quickenloans_RentvBuyCalc ZipCode (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,ZipCode,userValue, logger, "Inputting ZipCode");
        return new Quickenloans_RentvBuyCalc(driver);
    } //Zipcode
    public Quickenloans_RentvBuyCalc CreditScore(String userValue){
        Reusable_Methods_Loggers_Page_Object.dropDownMenu(driver,CreditScore, userValue, logger, "Entering CreditScore");
        return new Quickenloans_RentvBuyCalc(driver);
    }//Entering CreditScore
    public Quickenloans_RentvBuyCalc PurchasePrice (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,PurchasePrice, userValue, logger, "Inputting Purchase Price");
        return new Quickenloans_RentvBuyCalc(driver);
    } //Purchase Price
    public Quickenloans_RentvBuyCalc DownPayment (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,DownPayment,userValue, logger, "Inputting Downpayment");
        return new Quickenloans_RentvBuyCalc(driver);
    } //downpayment amount
    public Quickenloans_RentvBuyCalc Interest (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,Interest,userValue, logger, "Inputting Interest Amount");
        return new Quickenloans_RentvBuyCalc(driver);
    } //Interest amount
    public Quickenloans_RentvBuyCalc MonthlyRent (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,MonthlyRent,userValue, logger, "Inputting Rent Amount");
        return new Quickenloans_RentvBuyCalc(driver);
    } //Rent amount
    public Quickenloans_RentvBuyCalc Calculate(){
        Reusable_Methods_Loggers_Page_Object.click(driver,Calculate, logger, "Change Calculator to Purchase");
        return new Quickenloans_RentvBuyCalc(driver);
    }//Calculate
    public Quickenloans_RentvBuyCalc HomeAffordable(){
        Reusable_Methods_Loggers_Page_Object.click(driver,HomeAffordable, logger, "Change Calculator to Purchase");
        return new Quickenloans_RentvBuyCalc(driver);
    }//Changing Calc to affordability calculator

}
