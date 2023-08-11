package Day12_040223;

import Reusable_Methods.ReusableAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T2_GetElementCount extends ReusableAnnotations {
    @Test
    public void getNavListCount(){
        //navigating to USPS
        driver.navigate().to("https://www.usps.com");
        //store element list in an array list with common properties
        WebDriverWait wait = new WebDriverWait(driver,7);
        ArrayList<WebElement> navList = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]"))));
        System.out.println("Count: " + navList.size());
    }//end of test

}//end of class
