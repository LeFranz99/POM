package DataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLesson {

    @Test(dataProvider = "getData")
    public void homeLoan1FraudTest(String username, String lastname) {
        System.out.println("Home Loan1 Fraud Test");
        System.out.println(username + " " + lastname);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];

        // first set
        data[0][0] = "firstSetUsername";
        data[0][1] = "firstSetLastname";

        // second set
        data[1][0] = "secondSetUsername";
        data[1][1] = "secondSetLastname";

        // third set
        data[2][0] = "thirdSetUsername";
        data[2][1] = "thirdSetLastname";

        return data;
    }

    @Test(dataProvider = "loadData")
    public void homeLoan2FraudTest(String name, String surname, String addressLine1, String suburb, String city) {
        System.out.println("Home Loan2 Affordability Test");
        System.out.println(name + ", " + surname + ", " + addressLine1 + ", " + suburb + ", " + city);
    }

    @DataProvider
    public Object[][] loadData() {
        Object[][] data = new Object[10][5];

        // 1st set
        data[0][0] = "name";
        data[0][1] = "surname";
        data[0][2] = "addressLine1";
        data[0][3] = "suburb";
        data[0][4] = "city";

        // 2nd set
        data[1][0] = "name";
        data[1][1] = "surname";
        data[1][2] = "addressLine1";
        data[1][3] = "suburb";
        data[1][4] = "city";

        // 3rd set
        data[2][0] = "name";
        data[2][1] = "surname";
        data[2][2] = "addressLine1";
        data[2][3] = "suburb";
        data[2][4] = "city";

        // 4th set
        data[3][0] = "name";
        data[3][1] = "surname";
        data[3][2] = "addressLine1";
        data[3][3] = "suburb";
        data[3][4] = "city";

        // 5th set
        data[4][0] = "name";
        data[4][1] = "surname";
        data[4][2] = "addressLine1";
        data[4][3] = "suburb";
        data[4][4] = "city";

        // 6th set
        data[5][0] = "name";
        data[5][1] = "surname";
        data[5][2] = "addressLine1";
        data[5][3] = "suburb";
        data[5][4] = "city";

        // 7th set
        data[6][0] = "name";
        data[6][1] = "surname";
        data[6][2] = "addressLine1";
        data[6][3] = "suburb";
        data[6][4] = "city";

        // 8th set
        data[7][0] = "name";
        data[7][1] = "surname";
        data[7][2] = "addressLine1";
        data[7][3] = "suburb";
        data[7][4] = "city";

        // 9th set
        data[8][0] = "name";
        data[8][1] = "surname";
        data[8][2] = "addressLine1";
        data[8][3] = "suburb";
        data[8][4] = "city";

        // 10th set
        data[9][0] = "name";
        data[9][1] = "surname";

        return data;
    }
}
