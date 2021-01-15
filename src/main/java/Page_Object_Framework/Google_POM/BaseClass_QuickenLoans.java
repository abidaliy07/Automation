package Page_Object_Framework.Google_POM;

import Reusable_library.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass_QuickenLoans extends Abstract_Class {
    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public BaseClass_QuickenLoans(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor method
    public static Quickenloans_Home quickenloans_home(){
        Quickenloans_Home quickenloans_home = new Quickenloans_Home(driver);
        return quickenloans_home;
    } //end of quickenloans_home
    public static Quickenloans_SeeAllCalc seeAllCalc(){
        Quickenloans_SeeAllCalc seeAllCalc = new Quickenloans_SeeAllCalc(driver);
        return seeAllCalc;
    } //end of seeAll_Calc

    public static Quickenloans_RefinanceCalc refinanceCalc(){
        Quickenloans_RefinanceCalc refinanceCalc = new Quickenloans_RefinanceCalc(driver);
        return refinanceCalc;
    } //end of quickenloans_refinance
    public static Quickenloans_PurchaseCalculator purchaseCalculator(){
        Quickenloans_PurchaseCalculator purchaseCalculator = new Quickenloans_PurchaseCalculator(driver);
        return purchaseCalculator;
    } //end of quickenloans_purchase
    public static Quickenloans_RentvBuyCalc rentvBuyCalc(){
        Quickenloans_RentvBuyCalc rentvBuyCalc = new Quickenloans_RentvBuyCalc(driver);
        return rentvBuyCalc;
    } //end of quickenloans_rentvBuyCalc



}
