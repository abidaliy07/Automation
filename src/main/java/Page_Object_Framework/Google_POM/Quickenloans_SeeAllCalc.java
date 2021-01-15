package Page_Object_Framework.Google_POM;
import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quickenloans_SeeAllCalc extends Abstract_Class{
    ExtentTest logger;
    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public Quickenloans_SeeAllCalc(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }   //end of constructor method
    //Click on SeeAllCalc
    @FindBy(xpath = "//*[@href='/mortgage-calculator?qlsource=nav']")
    WebElement SeeAllCalc;
    //Click om Refi
    @FindBy(xpath = "//*[@href='/calculator-refinance?qlsource=nav']")
    WebElement ClickRefiCalc;

    public Quickenloans_SeeAllCalc SeeAllCalc(){
        Reusable_Methods_Loggers_Page_Object.click(driver,SeeAllCalc,logger,"Clicking See All Calculators");
        return new Quickenloans_SeeAllCalc(driver);
    }//end of your Click SeeAllCalc

    public Quickenloans_SeeAllCalc RefiCalc(){
        Reusable_Methods_Loggers_Page_Object.click(driver,ClickRefiCalc,logger,"Clicking RefiCalc");
        return new Quickenloans_SeeAllCalc(driver);
    }//end of your Click RefiCalc //going to refi calc from SeeAllCalc Page

}
