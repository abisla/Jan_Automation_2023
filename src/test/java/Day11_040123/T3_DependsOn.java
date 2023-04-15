package Day11_040123;

import Reusable_Methods.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T3_DependsOn {
    public class T2_GoogleSearchTestNG_Priorties {
        WebDriver driver;

        //create before suite method to define your chrome driver
        @BeforeSuite
        public void setUpDriver() {
            driver = ReusableMethods.defineChromeDriver();
        } //end of before suite

        //@Test is a replacement of the main method to execute your code
        @Test(priority = 1)
        public void searchForBmw() {
            //navigate to google home
            driver.navigate().to("https://www.google.com");
            //enter bmw into search field
            ReusableMethods.sendKeysMethod(driver, "//*[@name='q']", "bmw", "Search Field");
            ReusableMethods.submitMethod(driver, "//*[@name='btnK']", "Google Search");
        }
        //depends on, one method has dependency on another method, unless the depends on method is not passed. this current method will not execute
        @Test(priority = 2)
        public void captureSearchNumberBmw() {
            //submit
            String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']", "Search Results");
            String[] arrayResult = result.split(" ");
            System.out.println("Search number for BMW: " + arrayResult[1]);
        }//end of test 2


        //
        @Test(dependsOnMethods = "searchForBmw")
        public void captureSearchNumbersForBMW() {
            //capture text and print out #
            String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']", "Search Results");
            String[] arrayResult = result.split(" ");
            System.out.println("Search number for BMW: " + arrayResult[1]);
        }

        @Test(dependsOnMethods = {"searchForBmw", "captureSearchNumberForBmw"})
        public void clickOnFinance() {
            ReusableMethods.clickMethod(driver, " //div[text()='Finance']", "Finance");
        }//end of test 3

        //quit the driver
        @AfterSuite
        public void quitDriver() {
            driver.quit();

        }//end of suite
    }
}

