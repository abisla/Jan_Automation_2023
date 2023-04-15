package Day07_031823;

import Reusable_Methods.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select {
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
        WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //call select functionto store dropdown locator
        //Select startMonthDropdown = new Select(strMonth);
        //select visible text
        //startMonthDropdown.selectByVisibleText("Apr");
        //select by value
        //startMonthDropdown.selectbyValue("4");
        //select by index
        //startMonthDropdown.selectByIndex(3);

        //ReusableMethods.selectByVisualText(driver,"//*[@name='param[start_month]']","Apr");
        //ReusableMethods.selectByVisualText(driver,strMonth,"Apr");

        //ReusableMethods.selectByIndex(driver,strMonth,3);
        ReusableMethods.selectByValue(driver,strMonth,"4");




    }//end of main
}//end of class
