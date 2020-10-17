package Reusable_library;


import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods {
    public static WebDriver getDriver (){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }


    public static void click(WebDriver driver, String locator, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 35);
        try {
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        } catch (Exception error) {
            System.out.print("Unable to click on element " + error);
        }

    }//end of void method

    public static void sendKeys(WebDriver driver, String locator, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        try {
            System.out.println("Sending Keys " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception error) {
            System.out.print("Unable to send keys " + error);
        } //end of catch

    }//end of sendKeys method

    public static void submit(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println(("Submitting " + elementName));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        } catch (Exception error) {
            System.out.println(("Unable to submit on element " + error));
        } //end of catch
    } //end of submit method

    public static String captureText(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String text = "";
        try {
            System.out.println("Capturing text " + elementName);
            text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
        } catch (Exception error) {
            System.out.println("Unable to capture text " + error);
        } //end of catch
        return text;
    }//end of method

    public static void dropDown(WebDriver driver, String locator, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        try {
            System.out.println("Select text from drop down " + elementName);
            WebElement dDownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dd = new Select(dDownElement);
            dd.selectByVisibleText(userValue);
        } catch (Exception error) {
            System.out.println("Unable to select drop down " + error);
        }
    }// end of drop down method
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,9);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
        }
    }//end of click by index method

    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,9);
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
    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,35);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
        }
    }//end of click method
}//end of class








