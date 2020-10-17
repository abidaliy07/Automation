package Day5_091320;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_options {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options= new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);

        //navigate to google page
        System.out.println("Navigating to google home page");
        driver.navigate().to("https://www.google.com");
        //delay 2 seconds
        Thread.sleep(2000);
        //capture the home page title and verify it matches teh expected title
        //Which is Google
        String actualTitle= driver.getTitle(); //actualTitle here captures the real title from website
        //verify it matches the expected title
        if(actualTitle == "GOOGLE"){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        } //end of conditional statement

    }


}
