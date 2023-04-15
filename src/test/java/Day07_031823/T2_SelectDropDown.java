package Day07_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_SelectDropDown {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguements for your webdriver
        ChromeOptions options = new ChromeOptions();
        //option variable must be passed inside chromeDriver in order for your driver to recoginze those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo homepage
        driver.navigate().to("https://www.mortgagecalculator.org");

        //wait few seconds
        Thread.sleep(2000);

        //select start month as April from dropdown using Select Function
        //store the start month locator as an WebElement
        driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();
        //click on dropdown value by using xpath text
        driver.findElement(By.xpath("//*[text()='Apr']")).click();

    }//end of main
}//end of class
