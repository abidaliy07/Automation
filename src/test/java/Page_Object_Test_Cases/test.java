package Page_Object_Test_Cases;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Loggers;
import org.testng.annotations.Test;


 public class test extends Abstract_Class {

        @Test
        public void test() throws InterruptedException {
            driver.manage().deleteAllCookies();
            driver.navigate().to("https://www.quickenloans.com/");
            Reusable_Methods_Loggers.click(driver, "//*[@data-qa='nav-calc-main']", "Entering Calculator"); //quickenloanhome click calculator
            Reusable_Methods_Loggers.click(driver, "//*[@href='/mortgage-calculator?qlsource=nav']", "Entering Calculator"); //quickenloans click see all calculators
            Reusable_Methods_Loggers.click(driver, "//*[@data-qa='nav-calc-main']", "Entering Calculator"); //quickenloanhome click calculator
            Reusable_Methods_Loggers.click(driver, "//*[@href='/calculator-mortgage?qlsource=nav']", "Entering Calculator"); //quickenloans click mortgage calculator
            Thread.sleep(2000);
            //Reusable_Methods_Loggers.click(driver, "//*[@id='refinanceGoal']", "Entering Calculator"); //quickenloanhome click calculator
            //Reusable_Methods_Loggers.dropDownMenu(driver, "//*[@id='refinanceGoal']", "Take cash out of my home", logger, "Refinance type"); //quickenloanhome click calculator
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@name='purchasePrice']", logger, "Clicking home price");
            Reusable_Methods_Loggers.sendKeys(driver, "//*[@name='purchasePrice']", "850,000", logger, "Home Price");

        }
    }

