package Day09_032523;

import Reusable_Methods.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T4_ReusableMethods {
    public static void main(String[] args) throws InterruptedException {

        //on your test classes you still to declare the webdriver command you to use
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to ups website
        driver.navigate().to("http://www.ups.com/us");

        //declare the explicit wait command
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //click on shipping
        //your explicit wait condition replaces your driver.findElement(s)
        //presenceOfAllElementsLocatedBy is same as findElements
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='mainNavDropdown1']"))).get(0).click();

        //click on Schedule a Pickup
        //when you see element not interactable exception then you have to use Thread.sleep for few seconds before
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Schedule a Pickup']"))).click();

        //enter a tracking number on the box
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='tracknumlist']"))).sendKeys("1234455555");



    }//end of main
    }//end of class
