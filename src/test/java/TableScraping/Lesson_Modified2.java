package TableScraping;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lesson_Modified2 extends BasePage {

    public void goToTableDemo() {
        driver.get("http://demo.guru99.com/test/table.html");
    }

    @Test
    public void tablesDemo() {
        goToTableDemo();
        // locate the table
        WebElement myTable = getElement(By.xpath("//tbody"));

        // locate rows of table
        List<WebElement> tableRows = myTable.findElements(By.tagName("tr"));

        // find number of rows in the table
        int rowCount = tableRows.size();
        System.out.println("Number of rows in table is : " + rowCount);
        System.out.println("<------------------------------------->");

        // this Outer, Vertical loop executes till the last row of the table
        for (int row = 0; row < rowCount; row++) {

            // locate column entries in each row
            List<WebElement> cellEntries = tableRows.get(row).findElements(By.tagName("td"));

            // find number of entries in each row
            int entryCount = cellEntries.size();

            // find number of cell entries per row
            System.out.println("Number of cell entries in row " + row + " is : " + entryCount);

            // this Inner, Horizontal loop executes till the last column of the table
            for (int columnEntry = 0; columnEntry < entryCount; columnEntry++) {

                // get text entries from each row cell
                String cellText = cellEntries.get(columnEntry).getText();
                System.out.println("Entry in cell " + columnEntry + " of row " + row + " is " + cellText);
            }
            System.out.println("<------------------------------------->");
        }
        driver.close();
    }
}
