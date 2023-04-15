package ZPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_1 {
    public static void main(String[] args) {
        //wait 2-3 seconds

        ////set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();
        //define the chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

        //alternate to thread sleep
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //div[@id='search-results']//following::a[contains(@class,'linkUnderline')]


        //a[contains(@class,'linkUnderline')]

        int favoriteTemp = 75;
        int currentTemp = 60;
        String opinion;

        if(currentTemp < favoriteTemp-30) {
            opinion = "Its pretty darn cold";
        } else if (currentTemp < favoriteTemp -20) {
            opinion = "its mild out";
        }else if(currentTemp > favoriteTemp + 10) {
            opinion = "its hot out";
        }

//a[@class='linkUnderline-1_h4g']

    }//end of main
}//end of class
