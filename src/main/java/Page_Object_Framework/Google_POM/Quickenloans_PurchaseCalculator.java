package Page_Object_Framework.Google_POM;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quickenloans_PurchaseCalculator extends Abstract_Class {
    ExtentTest logger;

    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public Quickenloans_PurchaseCalculator(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }   //end of constructor method

    @FindBy(xpath = "//*[@id='purchasePrice']")
    WebElement PurchasePrice;
    @FindBy(xpath = "//*[@name='downPayment']")
    WebElement Dpayment;
    @FindBy(xpath = "//*[@name='term']")
    WebElement LoanTerm;
    @FindBy(xpath = "//*[@name='rate']")
    WebElement Interest;
    @FindBy(xpath = "//*[@name='taxes']")
    WebElement Taxes;
    @FindBy(xpath = "//*[@name='insurance']")
    WebElement HomeInsurance;
    @FindBy(xpath = "//*[@name='hoa']")
    WebElement HOA;
//shift to rent vs buy calculator
    @FindBy(xpath = "//*[@href='/rent-vs-buy-calculator?qlsource=nav']")
    WebElement RentvBuy;

    public Quickenloans_PurchaseCalculator PurchasePrice (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,PurchasePrice,userValue, logger, "Inputting Purchase Price");
        return new Quickenloans_PurchaseCalculator(driver);
    } //purchaseprice

    public Quickenloans_PurchaseCalculator Dpayment (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,Dpayment,userValue, logger, "Inputting Downpayment");
        return new Quickenloans_PurchaseCalculator(driver);
    } //downpayment amount

    public Quickenloans_PurchaseCalculator LoanTerm (String userValue){
        Reusable_Methods_Loggers_Page_Object.dropDownMenu(driver,LoanTerm,userValue, logger, "Entering Loan Term");
        return new Quickenloans_PurchaseCalculator(driver);
    } //loanterm
    public Quickenloans_PurchaseCalculator Interest (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,Interest,userValue, logger, "Inputting Interest Amount");
        return new Quickenloans_PurchaseCalculator(driver);
    } //Interest amount

    public Quickenloans_PurchaseCalculator Taxes (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,Taxes,userValue, logger, "Inputting Tax Amount");
        return new Quickenloans_PurchaseCalculator(driver);
    } //Tax amount
    public Quickenloans_PurchaseCalculator HomeInsurance (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,HomeInsurance,userValue, logger, "Inputting Home Insurance Amount");
        return new Quickenloans_PurchaseCalculator(driver);
    } //Home Insurance
    public Quickenloans_PurchaseCalculator HOA (String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,HOA,userValue, logger, "Inputting HOA Amount");
        return new Quickenloans_PurchaseCalculator(driver);
    } //HOA amount
    public Quickenloans_PurchaseCalculator RentvBuy(){
        Reusable_Methods_Loggers_Page_Object.click(driver,RentvBuy, logger, "Change Calculator to Purchase");
        return new Quickenloans_PurchaseCalculator(driver);
    }//Changing Calc to RentvsBuy


}




