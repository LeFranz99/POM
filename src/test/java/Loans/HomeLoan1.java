package Loans;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomeLoan1 {
    /*all tests with annotation "@Test(groups = {"Smoke"})" will be included/excluded
    * as prescribed in the "run" tag on a specific xml file
     */
    @Test(groups = {"Smoke"})
    public void lowCostHomes() {
        System.out.println("Loans for Low cost homes");
        String expected = "Passed test";
        String actual = "Something";

        Reporter.log("expected ................." + expected);
        Reporter.log("actual ................." + actual);
        Assert.assertEquals(actual,expected);
    }

    @Test(groups = {"Smoke"})
    public void mediumCostHomes() {
        System.out.println("Loans for Medium cost homes");
        Assert.assertTrue(false);
    }
}
