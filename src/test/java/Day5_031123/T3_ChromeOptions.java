package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguements for your webdriver
        ChromeOptions options = new ChromeOptions();
        //add maximize for windows
        //options.addArguments("start-maximized");
        //add --kiosk for mac
        //options.addArguments("--kiosk");

        //add incognito mode to option
        options.addArguments("incognito");

        //add options to run your driver on the background(headless)
        //options.addArguments("headless");

        //define the chrome driver that you will use for testing
        //option variable must be passed inside chromeDriver in order for your driver to recoginze those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo Home
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(2000);

        //click on mail link
        driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();

        Thread.sleep(2000);

        //print out sign in to yahoo text
        String result =  driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).getText();
        System.out.println("Result: " + result);


    }//end of main
}//end of class
