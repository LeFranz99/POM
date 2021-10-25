package Grouping;

import org.testng.annotations.Test;

public class HomeLoan2 {
    @Test(groups = {"Smoke"})
    public void highCostHomes() {
        System.out.println("Loans for high cost homes");
    }

    @Test(groups = {"Regression"})
    public void executiveHomes() {
        System.out.println("Loans for very high cost homes");
    }
}
