package Day10_032623;

import Reusable_Methods.ReusableMethods;
import org.openqa.selenium.WebDriver;



public class BestBuy_ActionItem {
    public static void main(String[] args) throws InterruptedException {

        //set up driver
        WebDriver driver = ReusableMethods.defineChromeDriver();
//        driver.manage().deleteAllCookies();
        //navigate to staples home page
        driver.navigate().to("https://www.bestbuy.com");

        //Iphone into search field
        //driver.findElement(By.xpath("//*[id='gh-search-input']"))
        ReusableMethods.sendKeysMethod(driver,"//input[@id='gh-search-input']","iphone","Search Field");

        //click on the search icon
        ReusableMethods.clickMethod(driver,"//button[@title='submit search']","Search Icon");

        //select by text best-selling
        ReusableMethods.selectByVisualText(driver,"//*[@id='sort-by-select']","Best Selling");
        Thread.sleep(2000);

        //select by index
        ReusableMethods.clickMethodByIndex(driver,"//a[@class='image-link']",1,"firstIphoneFromList");

        //internet running slow
        Thread.sleep(2000);
        //scroll by element
        ReusableMethods.scrollTillElement(driver,"//button[@data-qa='learn-more-button']","totalTechButton");

        //internet running slow
        Thread.sleep(2000);
        //click on add to cart
        ReusableMethods.clickMethod(driver,"(//button[contains(@class,'add-to-cart-button')])[1]","addToCartButton");

        //capture text
        System.out.println(ReusableMethods.captureTextMethod(driver,"//div[@class='sub-total v-fw-medium']","cartSubtotal"));


        Thread.sleep(2000);
        //mousehover
        ReusableMethods.moveToElementAndClick(driver,"//button[@class='c-button-link continue-shopping']","continueShoppingButton");
        //button[@class='c-button-link continue-shopping']

    }//end of main
}//end of class
