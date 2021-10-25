package DataProviders;

import frameWorkClasses.ReadExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReadExcelLesson {

    ReadExcel readExcel= new ReadExcel();

    @DataProvider(name = "getTestData")
    public Object[][] readFromExcel() throws IOException {

        String excelFileDirectory = readExcel.getDataConfigProperties("excelDataDir");
       Object[][] arrayObject = readExcel.getExcelData(excelFileDirectory + "TestData.xlsx", "Sheet1");

        return arrayObject;
    }

    @Test(dataProvider = "getTestData")
    public void readExcelTest(String name, String surname, String gender) {
        System.out.println("Personal details");
        System.out.println(name + ", " + surname + ", " + gender);
    }
}
