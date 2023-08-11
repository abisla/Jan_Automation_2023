package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ActionItem_Week3 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11375");
        zipcode.add("11374");
        zipcode.add("11373");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        for (int i = 0; i < zipcode.size(); i++) {
            driver.navigate().to("https://www.weightwatchers.com");

            sleep(2000);

            driver.findElement(By.xpath("//a[@icon='location']")).click();

            sleep(2000);

            driver.findElement(By.xpath("//span[text()='In-Person']")).click();
            sleep(2000);

            WebElement searchinput = driver.findElement(By.xpath("//input[@title='location-search']"));

            searchinput.clear();
            searchinput.sendKeys(zipcode.get(i));

            sleep(2000);

            driver.findElement(By.xpath("//button[@aria-label='Submit']")).click();

            sleep(2000);

            ArrayList<WebElement> searchlink = new ArrayList<>(driver.findElements(By.xpath("//a[@class='linkUnderline-1_h4g']")));

            System.out.println(searchlink.size());
            if (i == 0) {
                searchlink.get(1).click();
            }
            if (i == 1) {
                searchlink.get(2).click();
            }
            if (i == 2) {
                searchlink.get(0).click();

                String address1 = driver.findElement(By.xpath("//h1[contains(@class,'locationName')]//following::div[2]")).getText();
                String address2 = driver.findElement(By.xpath("//h1[contains(@class,'locationName')]//following::div[3]")).getText();

                WebElement address3 = driver.findElement(By.xpath("//h1[contains(@class,'locationName')]//following::div[2]"));
                System.out.println(address3.getText());

                String address4 = address3.getText();


                System.out.println(address1 + " " + address2);

                WebElement inPersonWorkshop = driver.findElement(By.xpath("//div[text()='Upcoming In-Person Workshops schedule']"));
                JavascriptExecutor jse = (JavascriptExecutor) driver;

                jse.executeScript("arguements[0].scrollIntoView(true)", inPersonWorkshop);
                ArrayList<WebElement> inPersonStudioTable = new ArrayList<>(driver.findElements(By.xpath("//div[@id='studioWorkshopSchedule']/div//following-sibling::div[contains(@class,'scheduleContainerMobile')]/div/span")));

                for (int k = 0; k < inPersonStudioTable.size(); k++) {
                    System.out.println(inPersonStudioTable.get(k).getText());

//        //create an ArrayList of zipcode
//        ArrayList<String> zipcode = new ArrayList<>();
//        zipcode.add("11364");
//        zipcode.add("11365");
//        zipcode.add("11363");
//
//
//        //set up your driver through web driver manager
//        WebDriverManager.chromedriver().setup();
//
//        //set your chrome options arguements for your webdriver
//        ChromeOptions options = new ChromeOptions();
//
//        //add incognito mode to option
//        options.addArguments("incognito");
//
//        //option variable must be passed inside chromeDriver in order for your driver to recoginze those conditions
//        WebDriver driver = new ChromeDriver(options);
//        //maximize the browser
//        driver.manage().window().maximize();
//        for (int i =0; i< zipcode.size(); i++) {
//            //navigate to WeightWatchers Home
//            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
//
//            //wait 2-3 seconds
//            sleep(2000);
//
//            //click on Find A Workshop
//            driver.findElement(By.xpath("//a[@icon='location']")).click();
//            //wait 2-3 seconds
//            sleep(2000);
//
//            //click on In Person
//            driver.findElement(By.xpath("//span[text()='In-Person']")).click();
//
//            //Enter zipcode & Pass //assign searchInput to driver
//            WebElement searchInput = driver.findElement(By.xpath("//input[@title='location-search']"));
//
//            //clear and send zipcodes to search field
//
//                searchInput.clear();
//                searchInput.sendKeys(zipcode.get(i));
//
//
//            //wait 2 seconds
//            sleep(2000);
//
//            //click on submit
//            driver.findElement(By.xpath("//button[@aria-label='Submit']")).click();
//
//            //wait 2 seconds
//            sleep(2000);
//
//            ArrayList<WebElement> searchlink = new ArrayList<>(driver.findElements(By.xpath("//a[@class='linkUnderline-1_h4g']")));
//
//            //printing size of total links
//            System.out.println(searchlink.size());
//            if(i==0) {
//                searchlink.get(1).click();
//
//            }
//            if(i==1) {
//                searchlink.get(2).click();
//
//            }
//            if(i==2) {
//                searchlink.get(0).click();
//
//            }
//
//                    //searchlink.get(i).click();
//                    String address1 = driver.findElement(By.xpath("//h1[contains(@class,'locationName')]//following::div[2]")).getText();
//                    String address2 = driver.findElement(By.xpath("//h1[contains(@class,'locationName')]//following::div[3]")).getText();
//
//                    System.out.println(address1 + " " + address2);
//               // }
//
//            /*driver.navigate().back();}
//            else if(i==1){
//            searchlink.get(i).click();
//            //driver.navigate().back();
//            }else if(i==2){
//            searchlink.get(i).click();
//        }*/
//            //}
//
//
//            Thread.sleep(2000);
//            WebElement InPersonWorkshopSchedule = driver.findElement(By.xpath("//div[text()='Upcoming In-Person Workshops schedule']"));
//            //scroll to bottom to click
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//            //scroll using pixels
//            jse.executeScript("arguments[0].scrollIntoView(true)", InPersonWorkshopSchedule);
//
//            ArrayList<WebElement> InPersonStudioTable = new ArrayList<>(driver.findElements(By.xpath("//div[@id='studioWorkshopSchedule']/div//following-sibling::div[contains(@class,'scheduleContainerMobile')]/div/span")));
//            for (int k = 0; k < InPersonStudioTable.size(); k++) {
//                System.out.println("In Person Studio TimeTable " + InPersonStudioTable.get(k).getText());
//                ;
//
//
//            }
//
//            sleep(2000);
//
//
//            //driver.quit();
//
//        }


                }//end of main
            }//end of class
        }
    }
    }

