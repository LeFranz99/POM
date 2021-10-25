package telecom.tests;

import frameWorkClasses.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import telecom.project.pages.*;

public class POMApproaches extends BasePage{

    String CustID, expected, actual;

    TelecomHomePage telecomHomePage = new TelecomHomePage();
    TelecomAddCustomerPage telecomAddCustomerPage = new TelecomAddCustomerPage();
    TelcomAccessDetailsToGuru99Page telcomAccessDetailsToGuru99Page = new TelcomAccessDetailsToGuru99Page();
    AddTariffPlanToCustomerPage_v2 addTariffPlanToCustomerPage_v2 = new AddTariffPlanToCustomerPage_v2(driver);

    // Pre-condition method1
    public void AddActiveCustomer() {
        telecomHomePage.goHome();
        telecomHomePage.clickAddCustomerLink();
        telecomAddCustomerPage.clickDoneRadionButton();
        telecomAddCustomerPage.setFirstName("Kapudi");
        telecomAddCustomerPage.setLastName("Leshaba");
        telecomAddCustomerPage.setEmailAddress("kleshaba@ilabqa.com");
        telecomAddCustomerPage.setAddress("1 Pretoria Main Rd" + "\n" + "Buccleuch" + "\n" + "Sandton" + "\n" + "9020");
        telecomAddCustomerPage.setMobileNumber("0747777777");
        telecomAddCustomerPage.clickSubmitButton();
    }

    // Test case 1:
    @Test
    public void Test1_GIVEN_ActiveCustomer_WHEN_Submit_THEN_ActiveIsDisplayed() {

        // generate customer Id and grab it before leaving "Details to Guru99" page
        AddActiveCustomer();
        CustID = telcomAccessDetailsToGuru99Page.getCustId();

        telecomHomePage.goHome();

        telecomHomePage.clickAddTariffPlanToCustomerLink();
        addTariffPlanToCustomerPage_v2.setCustomerId(CustID);
        addTariffPlanToCustomerPage_v2.clickSubmitButton();

        // verify the page displays ACTIVE text
        expected = "ACTIVE";
        actual = addTariffPlanToCustomerPage_v2.getTextOnPage();
        Assert.assertEquals(actual, expected);
    }

}
