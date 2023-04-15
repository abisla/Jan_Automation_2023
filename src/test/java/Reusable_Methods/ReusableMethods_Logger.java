package Reusable_Methods;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

//we need log because we want to keep track of our execution steps, failure, success or if any intermettied issues happen
//but for all those cases, sout will not help us because that has limitation to our local computer only
//every time we will not run our test cases on our local system
//thats why when doing the code SOUT is not reccomended at all
//you cant store SOUT output

public class ReusableMethods_Logger {
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);

        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully entered a value on element "+ elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to enter a value on element "+ elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of sendkeys method

    //submit action is one of the type of void method
    public static void submitMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);

        }
    }//end of submit method

    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element " + elementName);
            logger.log(LogStatus.PASS,"Successfully captured a text from element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text from element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);

        }
        return  result;
    }//end of get text method

    //click action is one of the type of void method
    public static void clickMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);

        }
    }//end of click method

    //click action is one of the type of void method
    public static void clickMethodByIndex(WebDriver driver,String xpath,int index,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);

        }
    }//end of click method by index


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            //we are telling our driver to typecast (giving our driver the power) and to take a screenshot
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!! " + e);
        }
    }//end of getScreenshot method

    public static void clickOnApplyNow(WebDriver driver,String cardname,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@alt,'"+ cardname +" ')]//following::a[@data-lh-name='ApplyNowCategoryPage'][1]"))).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);

        }
    }//end of click method

    public static void selectByVisualText(WebDriver driver,String xpath,ExtentTest logger, String textToBeSelected){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement dropDownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select select = new Select(dropDownElement);
            select.selectByVisibleText(textToBeSelected);
            System.out.println("Successfully clicked on element " + textToBeSelected);
            logger.log(LogStatus.PASS,"Successfully selected on element " + textToBeSelected);
        } catch (Exception e) {
            System.out.println("Unable to select on element " + textToBeSelected + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to select on element " + textToBeSelected + ": " + e);
        }
    }//end of select method

}
