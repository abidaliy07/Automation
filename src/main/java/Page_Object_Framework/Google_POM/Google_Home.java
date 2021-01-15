package Page_Object_Framework.Google_POM;



import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google_Home extends Abstract_Class {
    ExtentTest logger;
    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public Google_Home(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor method

    //locate search field
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    //locate google search button
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement searchButton;

    public Google_Home searchField(String userValue){
        Reusable_Methods_Loggers_Page_Object.sendKeys(driver,searchField,userValue,logger,"Search Field");
        return new Google_Home(driver);
    }//end of your search field method

    public Google_Home submitButton(){
        Reusable_Methods_Loggers_Page_Object.submit(driver,searchButton,logger,"Search Button");
        return new Google_Home(driver);
    }//end of your search button method




}//end of class
