package dstv.tests;

import dstv.project.pages.DStvSignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import dstv.project.pages.DStvLandingPage;

public class DStvTests {
    // instantiate the page objects
    DStvLandingPage lp = new DStvLandingPage();
    DStvSignInPage si = new DStvSignInPage();

    @Test
    public void GIVEN_NavigationToSignInPage_WHEN_OnlyPasswordEntered_AND_SignInButtonClicked_THEN_Error() {

        // GIVEN: user landing on Home page
        //      : page greets user
        lp.greetUser();
        //      : user clicks on User icon
        lp.clickSignInIcon();
        //      : user enters password
        si.enterPassword("Password123");

        // WHEN : user clicks Sign-in button
        si.clickSignInButton();
        String actual = si.checkUserNameError();
        String expected = "Email or Mobile number is requiredx";

        // THEN : system validates error message displayed
        Assert.assertEquals(actual, expected);
    }
    // THEN : Selenium closes browser after all tests are run
/*    @AfterSuite
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        lp.cleanup();

    }*/
}
