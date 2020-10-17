package Action_item;

import Reusable_library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_item5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);

        //Array List for first and last names
        ArrayList <String> firstName = new ArrayList<>();
        firstName.add("Paul");
        firstName.add("George");
        firstName.add("Wayne");

        ArrayList <String> lastName = new ArrayList<>();
        lastName.add("Scholes");
        lastName.add("Best");
        lastName.add("Rooney");
        //array list for month, day and year
        ArrayList <String> Month = new ArrayList<>();
        Month.add ("November");
        Month.add("May");
        Month.add("October");

        ArrayList <String> Day = new ArrayList<>();
        Day.add ("16");
        Day.add("22");
        Day.add("24");

        ArrayList <String> DOB = new ArrayList<>();
        DOB.add ("1974");
        DOB.add("1946");
        DOB.add("1985");
        //Arraylist for ssn
        ArrayList <String> ssn = new ArrayList<>();
        ssn.add("000000");
        ssn.add("111111");
        ssn.add("222222");
        //ZipCode arraylist
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11423");
        zipCode.add("10803");
        zipCode.add("10003");
        //navigate to uhc.com
        driver.navigate().to("https://www.uhc.com");
        //verify title
        String actualTitle = driver.getTitle();
        if (actualTitle == "Health insurance plans") {
            System.out.println("The title matches");
        } else {
            System.out.println("The title does not match. Actual title is " + actualTitle);
    } //end of title
        //click on doctor
        Reusable_Methods.click(driver, "//*[@aria-label='Find a Doctor']", "Find a Doc");
        //click on sign in
        Reusable_Methods.click(driver, "//*[@id='btn-sign-in']", "Sign in");
        //Switching tabs
        ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));
        //Click on register
        Reusable_Methods.click(driver, "//*[@id='registerbutton']", "Sign in");

        //Loop starts to go through arrayList
        for (int i=0; i<firstName.size(); i++) {
            //fill in the registration tab
            Reusable_Methods.sendKeys(driver, "//*[@id='firstName']", firstName.get(i), "First Name");
            Thread.sleep(2000);
            Reusable_Methods.sendKeys(driver,"//*[@id='lastName']", lastName.get(i), "Last Name");
            Thread.sleep(2000);
            Reusable_Methods.dropDown(driver,"//*[@name='dob_month']", Month.get(i), "Enter First Name");
            Thread.sleep(2000);
            Reusable_Methods.sendKeys(driver,"//*[@id='dob_day']", Day.get(i),"Enter birth day");
            Thread.sleep(2000);
            Reusable_Methods.sendKeys(driver,"//*[@id='dob_year']", DOB.get(i),"Enter birth year");
            Thread.sleep(2000);
            Reusable_Methods.click(driver,"//*[@for='ssn']","Click on Social security");
            Thread.sleep(2000);
            Reusable_Methods.sendKeys(driver,"//*[@id='ssnLastSixDigits']",ssn.get(i),"Enter ssn");
            Thread.sleep(2000);
            Reusable_Methods.sendKeys(driver,"//*[@id='zipCode']",zipCode.get(i),"Enter zip code");
            Thread.sleep(2000);
            Reusable_Methods.click(driver,"//*[@id='submitBtn']","Click on continue");

            String error= Reusable_Methods.captureText(driver,"//*[@id='plainText_error']","Capture error messsage");
            System.out.println(error);

        }// end of for loop
        } // end of method


}//end of class
