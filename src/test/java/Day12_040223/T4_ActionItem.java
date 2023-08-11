package Day12_040223;

import Reusable_Methods.ReusableAnnotations;
import Reusable_Methods.ReusableMethods;
import org.testng.annotations.Test;

public class T4_ActionItem extends ReusableAnnotations {

    @Test(priority = 1)
    public void generalCoverageLink() throws InterruptedException {
        //navigating to USPS
        driver.navigate().to("https://www.fideliscare.org");

        ReusableMethods.clickMethod(driver,"//div[@class='tool dropdown search']","search button");

        ReusableMethods.sendKeysMethod(driver,"//*[@aria-label='Search']","get dental coverage","search input");
        Thread.sleep(2000);

        ReusableMethods.clickMethod(driver,"//button[@aria-label='Execute Search']","search submit");

       String searchResultText = ReusableMethods.captureTextMethod(driver,"//div[@class='gsc-result-info']","search results");
       //we only want numbers 0-9 and we are replacing all other values with blank
        //regex is a string operation
        System.out.println(searchResultText.replaceAll("[^0-9]",""));



        ReusableMethods.clickMethod(driver,"//b[contains(text(),'Get Dental Coverage')][1]","get dental coverage");
        //a[contains(@data-tracking-control-name, 'menu_learning')]


    }
    @Test(priority = 2)
    public void switchTabs(){

        ReusableMethods.switchToTabByIndex(driver,1);

        ReusableMethods.sendKeysMethod(driver,"//input[@id='firstName']","amar","first name");
        ReusableMethods.sendKeysMethod(driver,"//input[@id='lastName']","bisla","last name");
        ReusableMethods.sendKeysMethod(driver,"//input[@id='zipCode']","11364","zipcode");
        ReusableMethods.selectByVisualText(driver,"//*[@id='county']","Queens");
        ReusableMethods.sendKeysMethod(driver,"//input[@id='phoneNumber']","999-999-9999","phone number");
        ReusableMethods.sendKeysMethod(driver,"//input[@id='email']","him@gmail.com","email");

        ReusableMethods.scrollByPixel(driver,0,3000);
        ReusableMethods.clickMethod(driver,"//input[@id='contactMe']/..","contact me checkbox");
        ReusableMethods.clickMethod(driver,"//button[@type='submit']","contact me submit");

       String thankYouForSubmission = ReusableMethods.captureTextMethod(driver,"//*[@class='alert alert-success']","Thank you for submission");
        System.out.println(thankYouForSubmission);

        driver.close();

    }
    @Test(priority = 3)
    public void switchBack(){
        ReusableMethods.switchToTabByIndex(driver,0);

        //2 elements for this
        //when index wrapping xpaths need to put small parenthesis before parent tag
        //div[@class='tool dropdown login'])[1]
                //a[contains(text(),'Login')]

        ReusableMethods.clickMethod(driver,"(//div[@class='tool dropdown login'])[1]","login");

        ReusableMethods.clickMethod(driver,"//a[@href='https://members.fideliscare.org/en-us/fidelislogin']","member portal button");

        //insert switch tab
        ReusableMethods.switchToTabByIndex(driver,1);

        String helpfulHintsTitle = ReusableMethods.captureTextMethod(driver,"//h2[@class='card-title']","helpful hints");
        System.out.println(helpfulHintsTitle);

        ReusableMethods.findByElements(driver,"(//div[@class='tipsContentText'])[1]//following::li",5);

        //String helpfulHintsTitleBody = ReusableMethods.captureTextMethod(driver,"(//div[@class='tipsContentText'])[1]","paragraph");
        //System.out.println(helpfulHintsTitleBody);

       //ArrayList<WebElement> paragraphHelpfulHints = (ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='tipsContentText'])[1]//following::li"));
       //== is when we are comparing something & = is when we do some assignment
        //first is value initiliazation, second is condition checking, if condition is true then it will only go in for loop, if false wont run.
        //Third Once loop completed it will implement the counter (you can increase or decrease according to need
        // i++ means i + 1
       //for(int i=0; i<=5;i++){
           //paragraphHelpfulHints.get(i).getText();
       //    System.out.println(paragraphHelpfulHints.get(i).getText());
      // }

      // for(int i=5; i>=0;i--){
          // System.out.println(paragraphHelpfulHints.get(i).getText());
       //}

    }
}
