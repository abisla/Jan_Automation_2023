package ZPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AskOmDch_TestScenario {
    public AskOmDch_TestScenario(){
        System.out.println("i am a default constructor");
    }
    public AskOmDch_TestScenario(String name) {
      //  name = "amar";
        System.out.println("i am a parametrized constructor " + name);
    }
    public static void main(String[] args) {
        //set up your driver through web driver manager
//        WebDriverManager.chromedriver().setup();
//
//        //set your chrome options arguements for your webdriver
//        ChromeOptions options = new ChromeOptions();
//        //option variable must be passed inside chromeDriver in order for your driver to recoginze those conditions
//        WebDriver driver = new ChromeDriver(options);
//
//        //navigate to yahoo homepage
//        driver.navigate().to("https://www.mortgagecalculator.org");

        AskOmDch_TestScenario askOmDchTestScenario = new AskOmDch_TestScenario("amar");
        //constructor name is always the same as the class name
        //it is getting called while loading the class itself
        System.out.println(askOmDchTestScenario.substract());

        System.out.println(askOmDchTestScenario.name());



    }//end of main

    public int substract(){
        int a = 10;
        int b = 11;

        return a - b;

    }

    public void sum(){
        //when we have void we dont have a return
    }

    public String name(){
        String name = "Amar";
        return name;
    }

}//end of class



