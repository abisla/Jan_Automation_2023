package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XPATH_TEST {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

        //navigate to Google Home
        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);

        //click on about text link using xpath text()
        driver.findElement(By.xpath("//*[text()='About']")).click();
    }//end of main
}//end of class
