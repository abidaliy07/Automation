package Day12_101020;

import Reusable_library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions_TestNg {
    @Test
    public void assertions() throws InterruptedException {
        WebDriver driver = Reusable_Methods.getDriver();

        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        //verify google title using hard assert
        //Assert.assertEquals("GOOGLE", driver.getTitle());
        //verify google title using soft assertion
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals("GOOGLE", driver.getTitle());
        //enter keyword on search
        Reusable_Methods.sendKeys(driver,"//*[@name='q']", "cars", "Cars");

        softAssert.assertAll();



    }











}//end of java class
