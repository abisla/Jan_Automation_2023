package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Yahoo_Search {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> sports = new ArrayList<>();
        sports.add("basketball");
        sports.add("golfing");
        sports.add("football");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.yahoo.com");

        for (int i = 0; i < sports.size(); i++) {
            driver.navigate().to("https://www.yahoo.com");
            driver.manage().window().maximize();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@name='p']")).sendKeys(sports.get(i));

            //click on bing search button
            driver.findElement(By.xpath("//*[@id='ybar-search']")).submit();


            //set up the ArrayList of hobbies
//        ArrayList<String> hobbies = new ArrayList<>();
//        hobbies.add("golfing");
//        hobbies.add("yoga");
//        hobbies.add("cooking");
//        hobbies.add("basketball");
//
//        //set up your driver through web driver manager
//        WebDriverManager.chromedriver().setup();
//
//        //define the chrome driver that you will use for testing
//        WebDriver driver = new ChromeDriver();
//
//        //navigate to Bing Home
//        driver.navigate().to("https://www.yahoo.com");
//
////iterate through the list of hobbies and print out search number for each hobby
//        for(int i=0; i<hobbies.size(); i++){
//            //navigate to bing home page
//            driver.navigate().to("https://www.yahoo.com");
//
//            //maximize the browser
//            //driver.manage().window().maximize(); //for windows
//            //driver.manage().window().fullscreen(); //for mac
//
//            //wait for 2 seconds
//            Thread.sleep(2000);
//
//            //enter keyword golfing into search field
//            driver.findElement(By.xpath("//*[@name='p']")).sendKeys(hobbies.get(i));
//
//            //click on bing search button
//            driver.findElement(By.xpath("//*[@id='ybar-search']")).submit();
//
//            //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
//            Thread.sleep(2000);
//            //capture the search results using .getText()
//            String result = driver.findElement(By.xpath("//*[@class=' fz-14 1h-22 ']")).getText();
//            //System.out.println("Search results: " + result);
//
//
//            //print out only the number
//            String[] arrayResult = result.split(" ");
//            System.out.println("For " + hobbies.get(i) + " the search number is " + arrayResult[1]);
//
//        }//end of loop


        }//end of main
    }//end of class
}
