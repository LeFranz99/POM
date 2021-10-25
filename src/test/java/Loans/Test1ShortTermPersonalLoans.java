package Loans;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1ShortTermPersonalLoans {

    @Test
    public void categoryOnePersonalLoans() {
        System.out.println("R100 to R500");

    }

    @Test
    public void categoryTwoPersonalLoans() {
        System.out.println("R5100 to R1000");
    }

    @Parameters({"URL"})
    @Test
    public void paramMethod(String URL){
        System.out.println("This is the URL parameter" + URL);
    }

}
