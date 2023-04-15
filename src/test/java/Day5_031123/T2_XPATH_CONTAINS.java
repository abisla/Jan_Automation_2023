package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_XPATH_CONTAINS {
    public static void main(String[] args) throws InterruptedException {

                //set up your driver through web driver manager
                WebDriverManager.chromedriver().setup();

                //define the chrome driver that you will use for testing
                WebDriver driver = new ChromeDriver();

                //navigate to yahoo Home
                driver.navigate().to("https://www.yahoo.com");

                Thread.sleep(2000);

                //using xpath contains click on the mail link by ignoring the white space on text property of element
                driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();


            }//end of main
}//end of class
