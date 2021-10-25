package telecom.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import telecom.project.pages.TelcomAccessDetailsToGuru99Page;
import telecom.project.pages.TelecomAddCustomerPage;
import telecom.project.pages.TelecomHomePage;

public class TelecomTestsAssignment1 {

    TelecomHomePage telecomHomePage = new TelecomHomePage();
    TelecomAddCustomerPage telecomAddCustomerPage = new TelecomAddCustomerPage();
    TelcomAccessDetailsToGuru99Page telcomAccessDetailsToGuru99Page = new TelcomAccessDetailsToGuru99Page();

    @Test
    public void TestCase1_GIVEN_UserNavigatesTo_AddCustomerPage_THEN_CorrectHeaderTextDisplayed() {

        // navigate to Home Page
        telecomHomePage.goHome();

        // wait for page to fully load
        //telecomHomePage.waitForUrl(???); WHERE and WHEN TO CALL THIS METHOD, and WHAT DO WE PASS AS LOCATOR?

        // click on Add Customer link
        telecomHomePage.clickAddCustomerLink();

        // Assert that the page heading is Add Customer
        String expectedHeader = "Add Customer";
        String actualHeader = telecomAddCustomerPage.getPageHeading();
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    // Test case 1
    @Test
    public void TestCase2_GIVEN_InvalidDataEntered_THEN_WarningMessageDisplayed() {

        //GIVEN : user is on the Guru99 telecom page
        telecomHomePage.goHome();

        // WHEN : user clicks on Add Customer link
        telecomHomePage.clickAddCustomerLink();

        // AND : user selects Done radio button under Background Check
        telecomAddCustomerPage.clickDoneRadionButton();

        // AND: user enters invalid data under Billing address
        telecomAddCustomerPage.setFirstName("Kapudi?");
        telecomAddCustomerPage.setLastName("Leshaba/");
        telecomAddCustomerPage.setEmailAddress("kleshaba.ilabqa.com");
        telecomAddCustomerPage.setAddress("1 Pretoria Main Road, Buccluech, Sandton, 9020<");
        telecomAddCustomerPage.setMobileNumber("074 777 7777:");

        // THEN : warning message displayed
        String expectedSpecialCharactersError = "Special characters are not allowed";
        String actualSpecialCharacter = telecomAddCustomerPage.getSpecialCharacterErrorText();
       Assert.assertEquals(actualSpecialCharacter , expectedSpecialCharactersError, "Expected error text don't match actual");
    }

    // Test case 2
    @Test
    public void TestCase3_GIVEN_InvalidDataEntered_THEN_AlertPops_WHEN_SubmitButtonClicked() {
        // GIVEN : user is on the Guru99 telecom page
        telecomHomePage.goHome();

        // WHEN : user clicks on Add Customer link
        telecomHomePage.clickAddCustomerLink();

        // AND : user selects Done radio button under Background Check
        telecomAddCustomerPage.clickDoneRadionButton();

        // AND: user enters invalid data under Billing address
        telecomAddCustomerPage.setFirstName("Kapudi");
        telecomAddCustomerPage.setLastName("Leshaba");
        telecomAddCustomerPage.setEmailAddress("kleshaba@ilabqa.com");
        telecomAddCustomerPage.setAddress("1 Pretoria Main Road, Buccluech, Sandton, 9020<");
        telecomAddCustomerPage.setMobileNumber("0747777777");

        // AND : user clicks SUBMIT button
        telecomAddCustomerPage.clickSubmitButton();

        // THEN : alert popup is displayed
        String expectedAlertText = "please fill all fields";
        String actualAlertText = telecomAddCustomerPage.switchToAlert();
        Assert.assertEquals(actualAlertText,expectedAlertText, "alert popped up is not as expected");

        telecomHomePage.closePopUp();
    }

    // Test case 3
    @Test
    public void TestCase4_GIVEN_ValidDataEntered_THEN_UserProceedsToNextPage_WHEN_SubmitButtonClicked() {
        //GIVEN : user is on the Guru99 telecom page
        telecomHomePage.goHome();

        // WHEN : user clicks on Add Customer link
        telecomHomePage.clickAddCustomerLink();

        // AND : user selects Done radio button under Background Check
        telecomAddCustomerPage.clickDoneRadionButton();

        // AND: user enters valid data under Billing address
        telecomAddCustomerPage.setFirstName("Kapudi");
        telecomAddCustomerPage.setLastName("Leshaba");
        telecomAddCustomerPage.setEmailAddress("kleshaba@ilabqa.com");
        telecomAddCustomerPage.setAddress("1 Pretoria Main Rd" + "\n" + "Buccluech" + "\n" + "Sandton" + "\n" + "9020");
        telecomAddCustomerPage.setMobileNumber("0747777777");

        // AND: user clicks on SUBMIT button
        telecomAddCustomerPage.clickSubmitButton();

        // THEN : next page with the header "Access Details to Guru99 Telecom" opens
        String expectedHeader = "Access Details to Guru99 Telecom";
        String actualHeader = telcomAccessDetailsToGuru99Page.getPageHeading();
        Assert.assertEquals(actualHeader, expectedHeader);
    }

/*  @AfterSuite
    public void cleanUp(){
        telecomHomePage.cleanup();
    }*/
}