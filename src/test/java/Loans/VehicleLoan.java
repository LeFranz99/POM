package Loans;

import org.testng.annotations.*;

public class VehicleLoan {
@Test
    public void TC01_vehicleLoan1(){
        System.out.println("First Vehicle Loan");
    }
@Test
    public void TC02_vehicleLoan2(){
        System.out.println("Second Vehicle Loan");
    }

    @Test
    public void TC03_fraudLoan1(){
        System.out.println("Third Vehicle Loan");
    }

    @Test
    public void TC04_fraudLoan2(){
        System.out.println("Fourth Vehicle Loan");
    }

@BeforeTest
    public void cleanDB(){
        System.out.println("Clean DB Before test execution");
    }

    @AfterTest
    public void closeSession(){
        System.out.println("Clean DB After test execution");
    }

    @BeforeSuite
    public void beforMyTestSuite(){
        System.out.println("Start of suite");
    }

    @AfterSuite
    public void afterMyTestSuite(){
        System.out.println("End of suite");
    }

}
