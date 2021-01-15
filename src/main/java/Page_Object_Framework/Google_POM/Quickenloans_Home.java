package Page_Object_Framework.Google_POM;


import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quickenloans_Home extends Abstract_Class {
    ExtentTest logger;
    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public Quickenloans_Home(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor method
    //Click Calculator
    @FindBy(xpath = "//*[@data-qa='nav-calc-main']")
    WebElement Calculator;
    public Quickenloans_Home Calc(){
        Reusable_Methods_Loggers_Page_Object.click(driver,Calculator,logger,"Clicking on Calculators");
        return new Quickenloans_Home(driver);
    }//end of clicking calculator method
}
