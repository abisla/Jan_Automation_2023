package Day14_040923;

import Reusable_Methods.ReusableAnnotations;
import Reusable_Methods.ReusableMethods;
import Reusable_Methods.ReusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionItem_Loggers extends ReusableAnnotations {

    @Test(priority = 1)
     public void logIntoChaseFailure(){
            logger.log(LogStatus.INFO,"Navigate to Chase credit card page");
    //navigate to staples home page
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //click on sign in
        ReusableMethods_Logger.clickMethod(driver,"//a[@data-pt-name='hd_sign_in']",logger,"sign in header");
        //Enter username and password
        ReusableMethods_Logger.sendKeysMethod(driver,"//input[@id='userId-text-input-field']","amarbisla123",logger,"username");
        ReusableMethods_Logger.sendKeysMethod(driver,"//input[@id='password-text-input-field']","password123",logger,"password");
        ReusableMethods_Logger.clickMethod(driver,"//button[@id='signin-button']",logger,"sign in");

        ReusableMethods_Logger.captureTextMethod(driver,"//*[@id='inner-logon-error']",logger,"error message");

}//end of test 1

    @Test(priority = 2)
    public void logIntoChaseSuccess() {
        logger.log(LogStatus.INFO, "Navigate to Chase credit card page");
        //navigate to staples home page
        driver.navigate().to("https://creditcards.chase.com/all-credit-cards?jp_ltg=chsecate_allcards&CELL=6TKV");
        //click on sign in
        ReusableMethods_Logger.clickMethod(driver, "//a[@data-pt-name='hd_sign_in']", logger, "sign in header");
        //Enter username and password
        ReusableMethods_Logger.sendKeysMethod(driver, "//input[@id='userId-text-input-field']", "amarbisla123", logger, "username");
        ReusableMethods_Logger.sendKeysMethod(driver, "//input[@id='password-text-input-field']", "password123", logger, "password");
        ReusableMethods_Logger.clickMethod(driver, "//button[@id='signin-button']", logger, "sign in");
    //I lost my wallet and couldnt reset my password to log in successfully but I will get this updated with the proper capture text of a successful login

    }//end t2
        @Test(priority = 3)
    public void applyNowFromAllCreditCardPage(){
            logger.log(LogStatus.INFO,"Navigate to Staples home page");
        //created a method where I can apply for a specific credit card by changing the name from the method
        ReusableMethods_Logger.clickOnApplyNow(driver,"Chase Freedom Unlimited",logger,"freedom unlimited card");
        ReusableMethods_Logger.clickOnApplyNow(driver,"Chase Freedom Flex",logger,"flex credit card");
        ReusableMethods_Logger.clickOnApplyNow(driver,"Chase Freedom Student",logger,"student");
        ReusableMethods_Logger.clickOnApplyNow(driver,"Slate Edge",logger,"slate card");
        ReusableMethods_Logger.clickOnApplyNow(driver,"Chase Sapphire Preferred",logger,"sapphire preferred card");

    }//end t3

    @Test(priority = 4)
    public void submitUserInfoForApplyNow(){
        logger.log(LogStatus.INFO,"Navigate to Staples home page");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='blx-nameBlock-firstName-label']","Amar",logger,"first name");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='blx-nameBlock-lastName-text-validate-input-field']","Bisla",logger,"last name");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='dateOfBirth-text-validate-input-field']","02/23/1997",logger,"DOB");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='mothersMaidenName-text-validate-input-field']","Jas",logger,"mothers maiden name");
        ReusableMethods_Logger.selectByVisualText(driver,"//*[@id='select-taxIdType-select-validate']",logger,"Social Security Number");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='maskedSocialSecurityNumber-text-validate-input-field']","051-22-1232",logger,"ss");
        ReusableMethods_Logger.selectByVisualText(driver,"//*[@id='select-addressType-blx-residentialAddressBlock-select-validate']",logger,"Domestic");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='streetAddress-blx-residentialAddressBlock-text-validate-input-field']","6943 226th st",logger,"st add");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='zipCode-blx-residentialAddressBlock-text-validate-input-field']","11364",logger,"zipcode");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='city-blx-residentialAddressBlock-text-validate-input-field']","Bayside",logger,"city");
        ReusableMethods_Logger.selectByVisualText(driver,"//*[@id='select-state-blx-residentialAddressBlock-select-validate']",logger,"New York");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='emailAddressId-text-validate-input-field']","bislajared@gmail.com",logger,"email");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='phoneNumberId-text-validate-input-field']","3476983533",logger,"phone #");

        ReusableMethods_Logger.clickMethod(driver,"//*[@id='input-socialSecurityAdministrationDisclosureAcceptance']",logger,"checkbox1");
        ReusableMethods_Logger.selectByVisualText(driver,"//*[@id='select-residenceOwnership-select-validate']",logger,"own");
        ReusableMethods_Logger.selectByVisualText(driver,"//*[@id='select-primaryIncomeSourceName-select-validate']",logger,"employed");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='grossAnnualIncome-text-validate-input-field']","50000",logger,"income");
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='input-navigationAdvisory']",logger,"checkbox2");
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='//*[@id='SUBMIT-nav-ctr-btn']']",logger,"submit");

    }//end t4

    @Test(priority = 5)
    public void compareCards(){
        logger.log(LogStatus.INFO,"Navigate to Staples home page");
    ReusableMethods_Logger.clickMethod(driver,"(//*[@class='compare-btn'])[1]",logger,"compare1");
    ReusableMethods_Logger.clickMethod(driver,"(//*[@class='compare-btn'])[2]",logger,"compare2");
    ReusableMethods_Logger.clickMethod(driver,"(//*[@class='//*[@class='btn promo-btn compare-cards-button']",logger,"compare cards popup button");
        ReusableMethods_Logger.captureTextMethod(driver,"(//*[@class='c1 compare-card-column col-4 split-ctrl'])[5]",logger,"column1");
        ReusableMethods_Logger.captureTextMethod(driver,"(//*[@class='c2 compare-card-column col-4 split-ctrl'])[5]",logger,"column2");

    //capture differences on earning rewards section
    }//end t5

    @Test(priority = 6)
    public void notEnrolledSignUpNowError(){
        logger.log(LogStatus.INFO,"Navigate to Staples home page");
        driver.navigate().to("https://secure08ea.chase.com/web/auth/enrollment#/enroll/onlineEnrollment/gettingStarted/index?LOB=");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='accountIdentifier-text-validate-input-field']","22222222222222",logger,"account number");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='socialSecurityNumber-text-validate-input-field']","051221333",logger,"ss number");
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='userId-text-validate-input-field']","abisla123",logger,"username");
        ReusableMethods_Logger.captureTextMethod(driver,"//*[@id='inner-identificationError']",logger,"error not enrolled");

        String name = "amar";
        //Output want rama


    }//end of test 6

}//end of class

//        String titles = driver.getTitle();
//        System.out.println(titles);
//        //replace title with new page in home page down below
//        Assert.assertEquals(titles,"home page");

//one test case successful login capture title
//other negative test on not being able to sign in and recieving an message informing wrong pw/username
//should navigate to correct url then be able to confirm the title

//a[@data-lh-name='ApplyNowCategoryPage']
//img[contains(@alt,'Chase Freedom Unlimited')]//following::a[@data-lh-name='ApplyNowCategoryPage'][1]
