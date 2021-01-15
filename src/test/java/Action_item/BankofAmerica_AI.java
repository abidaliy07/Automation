package Action_item;

import Reusable_library.Abstract_Class;
import org.testng.annotations.Test;

public class BankofAmerica_AI extends Abstract_Class {

    @Test
    public void Bank_of_America() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.bankofamerica.com");


    }
}
