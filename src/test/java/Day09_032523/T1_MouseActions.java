package Day09_032523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguements for your webdriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        //option variable must be passed inside chromeDriver in order for your driver to recoginze those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo homepage
        driver.navigate().to("https://www.usps.com");

        Thread.sleep(2000);

        //declare and define mouse action
        Actions mouseAction = new Actions(driver);

        //hover to send tab to open up submodules/functinalities
        try {
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            //perform is the way to club all our actions together
            mouseAction.moveToElement(sendTab).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to Send Tab: " + e);
        }

        //click on tracking use mouse click
        try {
            WebElement sendTab = driver.findElements(By.xpath("//*[text()='Tracking']")).get(0);
            mouseAction.moveToElement(sendTab).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to Send Tab: " + e);
        }
        try {
            WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
            mouseAction.moveToElement(trackingField).click().sendKeys("1234576").perform();
        } catch (Exception e) {
            System.out.println("Unable to type on Tracking Input: " + e);
        }

        try {
            WebElement trackButton = driver.findElement(By.xpath("//button[@type='submit']"));
            mouseAction.moveToElement(trackButton).click().build().perform();
        } catch (Exception e) {
            System.out.println("Unable to type on Tracking Input: " + e);
        }
        Thread.sleep(2000);
        driver.quit();





    }//end of main
}//end of class
