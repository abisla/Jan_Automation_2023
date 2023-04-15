package Reusable_Methods;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class ReusableMethods {


        //create a return method to return the webdriver you going to use on your test classes
        //static command allows your method to be global
        public static WebDriver defineChromeDriver() {
            //set up your driver through web driver manager
            WebDriverManager.chromedriver().setup();

            //set your chrome options arguments for your web driver
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("incognito");
            //options.addArguments("headless");

            //define the chrome driver that you will use for automation test
            //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
            WebDriver driver = new ChromeDriver(options);

            //set maximized for mac users
            driver.manage().window().maximize();

            return driver;
        }



            //return method will execute your statements along with returning some conditions/values
            //example of return methods are only WebDriver method and getText action

            //void method will only perform the action but wont return anything
            //return method will execute your statements along with returning some conditions/value
            //example of return methods are only WebDriver method & getText action

            //void method will only perform the action but won't return anything
            //void actions are click, sendKeys, scrolling, submit, select, mouse hover, clear

            //click action is one of the type of void method
           public static void clickMethod(WebDriver driver,String xpath,String elementName){
                WebDriverWait wait =  new WebDriverWait(driver,10);
                try{
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
                    System.out.println("Successfully clicked on element " + elementName);
                } catch (Exception e) {
                    System.out.println("Unable to click on element " + elementName + ": " + e);
                }
            }//end of click method

    //submit action is one of the type of void method
    public static void submitMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + ": " + e);
        }
    }//end of submit method

    //click action is one of the type of void method
    public static void clickMethodByIndex(WebDriver driver,String xpath,int index,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method by index

    //click action is one of the type of void method
    public static void sendKeysMethod(WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }//end of sendkeys method

    public static void hitEnter(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(Keys.ENTER);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }//end of sendkeys method
    //click action is one of the type of void method
    public static void sendKeysMethodByIndex(WebDriver driver,String xpath,String userValue,int index,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }

        //capture a text and return it using return method
    //public is our access modifier, everyone can access this
    //static can directly refer to this from our class name
    //String is our return type in this particular method, can be integer, webdriver, element etc how we want to capture
    //capturetextmethod is our method name
    // everything inside small parenthesis is called as method parameter (instructions for our method) what things we need to get our instructions done
        public static String captureTextMethod(WebDriver driver,String xpath,String elementName){
            WebDriverWait wait =  new WebDriverWait(driver,10);
            String result = null;
            try{
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                result = element.getText();
                System.out.println("Successfully captured a text from element " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to capture text from element " + elementName + ": " + e);
            }
            return result;
        }//end of get text method

    public static void selectByVisualText(WebDriver driver,String xpath,String textToBeSelected){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement dropDownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select select = new Select(dropDownElement);
            select.selectByVisibleText(textToBeSelected);
            System.out.println("Successfully clicked on element " + textToBeSelected);
        } catch (Exception e) {
            System.out.println("Unable to select on element " + textToBeSelected + ": " + e);
        }
    }//end of select method

    public static void selectByVisualText(WebDriver driver,WebElement element,String textToBeSelected){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(element)));
            select.selectByVisibleText(textToBeSelected);
            System.out.println("Successfully clicked on element " + textToBeSelected);
        } catch (Exception e) {
            System.out.println("Unable to select on element " + textToBeSelected + ": " + e);
        }
    }//end of select method

    public static void selectByIndex(WebDriver driver, WebElement element, int indexToBeSelected){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(element)));
            select.selectByIndex(indexToBeSelected);
            System.out.println("Successfully clicked on element " + indexToBeSelected);
        } catch (Exception e) {
            System.out.println("Unable to select on element " + indexToBeSelected + ": " + e);
        }
    }//end of select method

    public static void selectByValue(WebDriver driver,WebElement element,String valueToBeSelected){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(element)));
            select.selectByValue(valueToBeSelected);
            System.out.println("Successfully clicked on element " + valueToBeSelected);
        } catch (Exception e) {
            System.out.println("Unable to select on element " + valueToBeSelected + ": " + e);
        }
    }//end of select method

    public static void scrollTillElement(WebDriver driver, WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("arguments[0].scrollIntoView(true) ", element);
            System.out.println("successfully scrolled to element ");
        } catch (Exception e) {
            System.out.println("unable to scroll to element ");
        }
    }

    public static void scrollTillElement(WebDriver driver,String xpath,String elementName){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true) ", element);
            System.out.println("successfully scrolled to element " + elementName);
        } catch (Exception e) {
            System.out.println("unable to scroll to element " + elementName);
        }
    }

    public static void jseClick(WebDriver driver,String xpath,String elementName){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].click();", element);
            System.out.println("successfully clicked to element " + elementName);
        } catch (Exception e) {
            System.out.println("unable to click to element " + elementName);
        }
    }


    public static void moveToElementAndClick(WebDriver driver, WebElement element){
        Actions mouseAction = new Actions(driver);
        try {
            mouseAction.moveToElement(element).click().build().perform();
            System.out.println("successfully moved to element ");
        } catch (Exception e) {
            System.out.println("unable to move to element ");
        }
    }

    public static void moveToElementAndClick(WebDriver driver,String xpath,String elementName){
        Actions mouseAction = new Actions(driver);
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(element).click().build().perform();
            System.out.println("successfully moved to element " + elementName);
        } catch (Exception e) {
            System.out.println("unable to move to element " + elementName);
        }
    }

    //any radio button or checkboxes
    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, String elementName){
        //store the xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element  " + elementName + " " + e);
        }//end of exception


    }//end of verifyBooleanStatement

    public static void switchToTabByIndex(WebDriver driver,int index){
            //storing tabs into an array list so we can reference through index
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());

        //passing parameters into a string
        try{
            //we have tabs available so we can switch to the tab with provided index
            driver.switchTo().window(tabs.get(index));
            System.out.println("Successfully able to switch to "+index+ "tab");
        } catch (Exception e) {
            System.out.println("Unable to switch "+index+" tab: " + e);
        }
    }//end of switch tabs method by index

    public static void scrollByPixel(WebDriver driver, int x, int y){
        //scroll to bottom to click on mortgage rate
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        try{
            //scroll using pixels
            jse.executeScript("scroll(x,y)");

            System.out.println("Successfully able to scroll by pixel " );
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixel " + e);
        }
    }// end of scrollbyPixel method

    public static void findByElements(WebDriver driver,String xpath, int size){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            ArrayList<WebElement> elements = (ArrayList<WebElement>)wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
            for(int i=0; i<=size;i++){
                //elements.get(i).getText();
                System.out.println(elements.get(i).getText());
            }
            System.out.println("Successfully printed element text " );
        } catch (Exception e) {
            System.out.println("Unable to print element text "  + e);
        }

    }

    public static void findByElements(WebDriver driver,String xpath){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            ArrayList<WebElement> elements = (ArrayList<WebElement>)wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
            for(int i=0; i<= elements.size();i++){
                //elements.get(i).getText();
                System.out.println(elements.get(i).getText());
            }
            System.out.println("Successfully printed element text " );
        } catch (Exception e) {
            System.out.println("Unable to print element text "  + e);
        }

    }

    public static void clickOnCardApplyNowButton(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method

//overloaded method when we have two of the same methods with same name but with two different parameters








}//end of sendkeys method
    //end of click method






