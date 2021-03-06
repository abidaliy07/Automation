package Reusable_library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Reusable_Methods_Loggers_Page_Object {

    public static WebDriver getDriver() throws IOException, InterruptedException {
        //kill all chrome driver instance before opening a new one
        Thread.sleep(1000);
        //Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        //mac/windows
        //Runtime.getRuntime().exec("pgrep 'chromedriver' | xargs kill");
        //another way
        /*
        String cmds[] = {"killall","chromedriver"};
        Runtime.getRuntime().exec(cmds)
         */
        Thread.sleep(1000);
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver87.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here
        return driver;
    }//end of get driver

    //reusable method to click on any element on any websites
    public static void click(WebDriver driver, WebElement locator, ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            wait.until(ExpectedConditions.visibilityOf((locator))).click();
        }catch (Exception err){
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName);
        }//end of exception
    }//end of click method

    //reusable method to click on any element on any websites
    public static void clickByIndex(WebDriver driver, WebElement locator,int indexNumber,ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            wait.until(ExpectedConditions.visibilityOfAllElements(locator)).get(indexNumber).click();
        }catch (Exception err){
            logger.log(LogStatus.FAIL,"Unable to click on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of click method

    //reusable method to type on any element on any websites
    public static void sendKeys(WebDriver driver,WebElement locator, String userValue, ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            logger.log(LogStatus.INFO,"Typing on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            element.sendKeys("");
            element.sendKeys(Keys.BACK_SPACE);
            element.clear();
            Thread.sleep(2000);
            element.sendKeys(userValue);
        }catch (Exception err){
            System.out.println("Unable to type on element " + err);
            logger.log(LogStatus.FAIL,"Unable to type on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of sendkeys method

    //reusable method to submit on any element on any websites
    public static void submit(WebDriver driver, WebElement locator,ExtentTest logger, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            System.out.println("Submitting on element " + elementName);
            logger.log(LogStatus.INFO,"Submitting on element " + elementName);
            wait.until(ExpectedConditions.visibilityOf(locator)).submit();
        }catch (Exception err){
            System.out.println("Unable to submit on element " + err);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception
    }//end of submit method

    //reusable method to capture a value/text from a page
    public static String captureResult(WebDriver driver, WebElement locator,ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            System.out.println("Capturing text on element " + elementName);
            logger.log(LogStatus.INFO,"Capturing text on element " + elementName);
            result = wait.until(ExpectedConditions.visibilityOf(locator)).getText();
        }catch (Exception err){
            System.out.println("Unable to capture text on element " + err);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + err);
            getScreenShot(driver,logger,elementName);
        }//end of exception

        return result;
    }//end of get result method

    //method to select from drop down menu
    public static void dropDownMenu(WebDriver driver, WebElement locator, String userInput, ExtentTest logger,String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try
        {
            System.out.println("Selecting " + userInput + elementName);
            logger.log(LogStatus.INFO,"Capturing text on element " + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.visibilityOf(locator));
            Select selectDropDown= new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);

        }
        catch (Exception err)
        {
            System.out.println("Unable to select from drop down " + err);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + err);
        }
    }//end of drop down by text method

    //method to click on an element
   // public static void mouseClick(WebDriver driver, WebElement locator, ExtentTest logger, String elementName){
       // WebDriverWait wait = new WebDriverWait(driver,10);
       // Actions actions = new Actions(driver);
       // try{
           // System.out.println("Mouse clicking a value on element " + elementName);
           // logger.log(LogStatus.INFO," Mouse clicking a value on element" + elementName);
           // WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
           // actions.moveToElement(element).click().perform();
      //  } catch (Exception e) {
      //      System.out.println("Unable to mouse click element " + elementName + " " + e);
      //      logger.log(LogStatus.FAIL,"Unable to mouse click on element " + e);
       // }
   // }//end of click method

    //method to click on an element
    public static void mouseHover(WebDriver driver,String locator,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse hovering a value on element " + elementName);

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse hovering element " + elementName + " " + e);
            // getsc
        }
    }//end of click method

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver wDriver,ExtentTest logger,String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src/main/java/HTML_Report/Screenshots/";
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots/" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of screenshot method
    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            System.out.println("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
        }
    }//end of type and submit method

}//end of java class