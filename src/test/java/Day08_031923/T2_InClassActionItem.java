package Day08_031923;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T2_InClassActionItem {
    public static void main(String[] args) throws InterruptedException {
        //using try catch for each element to handle your errors

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //put few seconds wait
        Thread.sleep(2000);

        //create ArrayList for States
        ArrayList<String> states = new ArrayList<>();
        states.add("New York");
        states.add("California");
        states.add("New Jersey");
        //create an Arraylist<int> for # of adults
        ArrayList<Integer> adults = new ArrayList<Integer>();
        adults.add(2);
        adults.add(4);
        adults.add(3);

        for (int i = 0; i < states.size(); i++) {
            //navigate to hotels.com home page
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(2000);

            try {
                //webelement for goingTo button and click
                WebElement goingTo = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
                goingTo.click();
                System.out.println("clicking state search successfully");
            } catch (Exception e) {
                System.out.println("Unable to click state search" +e);
            }
            try {
                //search button
                WebElement search = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
                search.sendKeys(states.get(i));
                Thread.sleep(2000);
                driver.findElement(By.xpath("(//button[contains(@aria-label,'"+ states.get(i) +"')])[1]")).click();
                System.out.println("typed in search successfully");
            }catch (Exception e) {
                System.out.println("Unable to type in search" + e);
            }

            try {
                //change travelers to one and kid to 1 who is age 7
                WebElement traveler = driver.findElement(By.xpath("//button[@data-stid='open-room-picker']"));
                traveler.click();
                Thread.sleep(2000);
                System.out.println("clicked traveler successfully");
                WebElement addingTravelers = driver.findElement(By.xpath("//input[@aria-label='Adults ']//preceding::button[1]"));
                addingTravelers.click();

                WebElement addingChildren = driver.findElement(By.xpath("//input[@aria-label='Children Ages 0 to 17']//following::button[1]"));
                addingChildren.click();

                Thread.sleep(2000);
                WebElement childrenAgeDropdown = driver.findElement(By.xpath("//select[contains(@id,'children_age_selector')]"));
                //call select functionto store dropdown locator
                Select childAgeDropdown = new Select(childrenAgeDropdown);
                childAgeDropdown.selectByValue("7");
                Thread.sleep(2000);
                System.out.println("Changed children to age 7 successfully.");
                WebElement doneButton = driver.findElement(By.xpath("//button[@id='traveler_selector_done_button']"));
                doneButton.click();
            }catch (Exception e){
                System.out.println("unable to click traveler");
            }
            try {
                //webelement for searchbutton and click
                WebElement searchButton = driver.findElement(By.id("search_button"));
                searchButton.click();
                System.out.println("clicked search button successfully");
            }catch (Exception e) {
                System.out.println("unable to click traveler");
            }
            try {
                //store hotel into webelelment array list
                ArrayList<WebElement> hotelOption = new ArrayList<>(driver.findElements(By.xpath("//a[@data-stid='open-hotel-information']")));

                //printing size of total links, i==0 first link, i==1 3rd, i==2 2nd resort
                System.out.println(hotelOption.size());
                if(i==0) {
                    hotelOption.get(0).click();

                }
                if(i==1) {
                    hotelOption.get(2).click();

                }
                if(i==2) {
                    hotelOption.get(1).click();

                }
                System.out.println("clicked on hotel option");
            }catch (Exception e) {
                System.out.println("unable to click hotel option");
            }
            //call the window handles in array list and switch to the new tab
            ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab by index of 1
            driver.switchTo().window(tabs.get(1));

            //wait 10 seconds (sometimes it takes a while to load the options)
            Thread.sleep(10000);
            try {
                WebElement resortName = driver.findElement(By.xpath("//div[@data-stid='content-hotel-title']/h1"));
                System.out.println("resort name is " + resortName.getText());
            }catch (Exception e) {
                System.out.println("unable to print name of first hotel");
            }
            try {
                //capture price of hotel using findelements
                ArrayList<WebElement> hotelPriceOption = new ArrayList<>(driver.findElements(By.xpath("//div[@data-test-id='price-summary-message-line'][1]")));
                ////div[@data-stid='price-summary']/div/div/div/span/div]
                System.out.println("resort price per night is " + hotelPriceOption.get(1).getText());
            }catch (Exception e) {
                System.out.println("unable to print price of hotel");
            }

                try {
                //reserve a room
                driver.findElement(By.xpath("//button[@data-stid='sticky-button']")).click();
                System.out.println("clicked on reserve a room");
            }catch (Exception e) {
                System.out.println("unable to click reserve a room");
            }

                try {
                    //scroll in to the reserve button and set that as the initial point of the page
                    WebElement reserve = driver.findElement(By.xpath("(//button[@data-stid='submit-hotel-reserve'])[1]"));
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("arguments[0].scrollIntoView(true)", reserve);

                    Thread.sleep(2000);
                    jse.executeScript("arguments[0].click();", reserve);
                    System.out.println("scroll down and click reserve button");
                }catch (Exception e) {
                    System.out.println("unable to scroll down and click reserve button");
                }
            try {
                //pay for a room
                driver.findElement(By.xpath("//button[@data-stid='submit-hotel-reserve']/span[text()='Pay now']")).click();
                ////span[text()='Pay now']/..
                System.out.println("clicked on 'pay now' for a room");
            }catch (Exception e) {
                System.out.println("unable to click 'pay now' a room");
            }
            Thread.sleep(10000);
            try {
                //capture checkin date
                WebElement checkInDate = driver.findElement(By.xpath("(//td[contains(@class,'travel-dates-check-in')])[1]"));
                System.out.println("check in date for my booking is " + checkInDate.getText());
            }catch (Exception e) {
                System.out.println("unable to print check in date");
            }
            try {
                //capture checkout date
                WebElement checkOutDate = driver.findElement(By.xpath("(//td[contains(@class,'travel-dates-check-out')])[1]"));
                System.out.println("check out date for my booking is " + checkOutDate.getText());
            }catch (Exception e) {
                System.out.println("unable to print check out date");
            }


            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(tabs.get(0));

            }//end of loop
            driver.quit();

        }//end of main
    }//end of class
