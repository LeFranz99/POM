package telecom.tests;

import frameWorkClasses.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import telecom.project.pages.*;

public class TelecomTestsAssignment2 extends BasePage{

    String CustID, expected, actual;

    TelecomHomePage telecomHomePage = new TelecomHomePage();
    TelecomAddCustomerPage telecomAddCustomerPage = new TelecomAddCustomerPage();
    TelcomAccessDetailsToGuru99Page telcomAccessDetailsToGuru99Page = new TelcomAccessDetailsToGuru99Page();
    AddTariffPlanToCustomerPage addTariffPlanToCustomer = new AddTariffPlanToCustomerPage();
    AddTariffLastPage lastPage = new AddTariffLastPage();

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

    // Pre-condition method2
    public void AddInActiveCustomer() {
        telecomHomePage.goHome();
        telecomHomePage.clickAddCustomerLink();
        telecomAddCustomerPage.clickPendingRadionButton();
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
        // enter generated customer Id
        addTariffPlanToCustomer.enterCustomerId(CustID);
        addTariffPlanToCustomer.clickSubmitButton();

        // verify the page displays ACTIVE text
        expected = "INACTIVE";      // MUST FAIL
        actual = addTariffPlanToCustomer.getTextOnPage();
        Assert.assertEquals(actual, expected);
    }

    // Test case 2:
    @Test
    public void Test2_GIVEN_InactiveCustomer_WHEN_Submit_THEN_INACTIVE_IsDisplayed() {

        // generate customer Id and grab it before leaving "Details to Guru99" page
        AddInActiveCustomer();
        CustID = telcomAccessDetailsToGuru99Page.getCustId();

        telecomHomePage.goHome();

        telecomHomePage.clickAddTariffPlanToCustomerLink();
        addTariffPlanToCustomer.enterCustomerId(CustID);
        addTariffPlanToCustomer.clickSubmitButton();

        // verify the page displays INACTIVE text
        expected = "INACTIVE";
        actual = addTariffPlanToCustomer.getTextOnPage();
        Assert.assertEquals(actual, expected);
    }

    // Test case 3:
    @Test
    public void Test3_GIVEN_ActiveCustomer_WHEN_Submit_THEN_AtLeastOneApprovedTariffPlanIsDisplayed() {

        // generate customer Id and grab it before leaving "Details to Guru99" page
        AddActiveCustomer();
        CustID = telcomAccessDetailsToGuru99Page.getCustId();
        telecomHomePage.goHome();
        telecomHomePage.clickAddTariffPlanToCustomerLink();
        addTariffPlanToCustomer.enterCustomerId(CustID);
        addTariffPlanToCustomer.clickSubmitButton();

        // then verify at least one tariff record exists
        expected = addTariffPlanToCustomer.checkIfTariffPlanDisplayed();
        actual = "Select Tariff Plans";
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }

    // Test case 4:
    @Test
    public void Test4_GIVEN_AtLeastOneApprovedTariffPlanIsSelected_WHEN_AddTariff_THEN_SuccessMessageDisplayed() {
        // 691184
        // generate customer Id and grab it before leaving "Details to Guru99" page
        AddActiveCustomer();
        CustID = telcomAccessDetailsToGuru99Page.getCustId();
        telecomHomePage.goHome();
        telecomHomePage.clickAddTariffPlanToCustomerLink();
        addTariffPlanToCustomer.enterCustomerId(CustID);
        addTariffPlanToCustomer.clickSubmitButton();
        addTariffPlanToCustomer.scrollScrollToTable();
        addTariffPlanToCustomer.selectTariff();
        addTariffPlanToCustomer.addTariffPlan();
        expected = "Congratulation Tariff Plan assigned";
        actual = lastPage.getPageHeader();
        Assert.assertEquals(actual, expected);
    }
}
