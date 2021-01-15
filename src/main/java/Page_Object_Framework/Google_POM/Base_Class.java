package Page_Object_Framework.Google_POM;


import Reusable_library.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Class extends Abstract_Class {
    //constructor method to inherit the class name and you call the driver and logger
    //to be used locally for this class
    public Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor method

    //create static object method for page classes
    //google home
    public static Google_Home google_home(){
        Google_Home google_home = new Google_Home(driver);
        return google_home;
    } //end of google home object

    //google result page
    public static Google_Search_Result google_search_result(){
        Google_Search_Result google_search_result = new Google_Search_Result(driver);
        return google_search_result;
    } //end of google search result object




}//end of class
