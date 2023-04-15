package Reusable_Methods;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ReusableAnnotations {

    //you need to make your Webdriver driver variable static since we are calling it to our test class
    public static WebDriver driver;
    //declare report variable
    public static ExtentReports reports;
    //declare logger
    public static ExtentTest logger;

    //set before suite annotation method
    @BeforeSuite
    public void setDriver() {
        driver = ReusableMethods.defineChromeDriver();
        //set path to report
        reports = new ExtentReports("src/main/java/HTML_Report/automationReport.html",true);


    } //end of before suite

    //call before method annotation to capture each test name dynamically
    @BeforeMethod
    public void getTestName(Method methodName){
        //get name of the test
        logger = reports.startTest(methodName.getName());

    }//end of before method

        @AfterSuite
        public void quitDriver(){
            driver.quit();
            //end logger
            reports.endTest(logger);
            //write all logs back to iniital test report
            reports.flush();

    }//end of after suite

}//end of class
