package Loans;

import org.testng.annotations.Test;

public class HomeLoan2 {
@Test(enabled = false)
    public void highCostHomes(){
        System.out.println("Loans for high cost homes");
    }
    @Test(enabled = true)
    public void executiveHomes(){
        System.out.println("Loans for very high cost homes");
    }
}
