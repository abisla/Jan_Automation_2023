package ZPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AskOmDch_TestScenario {
    public static void main(String[] args) {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguements for your webdriver
        ChromeOptions options = new ChromeOptions();
        //option variable must be passed inside chromeDriver in order for your driver to recoginze those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo homepage
        driver.navigate().to("https://www.mortgagecalculator.org");






    }//end of main
}//end of class



