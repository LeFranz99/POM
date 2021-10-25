package TableScraping;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.List;

public class Homework20210930 extends BasePage {

    public void goTowebTableElements() {
        driver.get("http://demo.guru99.com/test/web-table-element.php");
    }
// Test case 1:
    //Method to print number of rows and number of table entries
   @Test
    public void Test1_printNumberOfRowsAndEntriesInTable() {
        goTowebTableElements();

        // get table element
        WebElement dataTable = getElement(By.xpath("//tbody"));
        //System.out.println(driver.getPageSource());

        // locate rows of the dataTable
        List<WebElement> tableRows = dataTable.findElements(By.tagName("tr"));

        // find the number of rows on dataTable
        int rowCount = tableRows.size();

        // print the number of rows on dataTable
        System.out.println("Number of rows in dataTable is : " + rowCount);

        // locate columns on dataTable
        List<WebElement> tableColumns = dataTable.findElements(By.tagName("td"));

        // find number of columns or cell entries on dataTable
        int tableColumnEntries = tableColumns.size();

        // print the number of rows on dataTable
        System.out.println("<---------------------------------------------------->");
        System.out.println("Number of table entries in dataTable is : " + tableColumnEntries);
        System.out.println("<---------------------------------------------------->");
    }
    // Test case 2:
    // Method to print entry of cell 4,4
    @Test
    public void Test2_printEntryInSpecificCellInTable() {
        goTowebTableElements();

        // get and print cell content in specific row and column
        WebElement cellEntry = getElement(By.xpath("//table/tbody/tr[4]/td[4]"));
        System.out.println("<----------------------------------------------->");
        System.out.println("Entry in column 4 of row 4 is : " + cellEntry.getText());
        System.out.println("<----------------------------------------------->");
    }

    // Test case 3:
    //Method to print number of rows and columns in a table
    @Test
    public void Test3_printNumberOfRowsAndColumnsInTable() {
        goTowebTableElements();
        // locate the table
        WebElement myTable = getElement(By.xpath("//tbody"));

        // locate rows of table
        List<WebElement> tableRows = myTable.findElements(By.tagName("tr"));

        // find number of rows in the table
        int rowCount = tableRows.size();

        System.out.println("Number of rows in table is : " + rowCount);

        // loop only once
        for (int row = 0; row < 1; row++) {
            // locate column in the first row
            List<WebElement> rowColumns = tableRows.get(row).findElements(By.tagName("td"));

            // find number of columns in the row
            int columns = rowColumns.size();

            // find number of cell entries per row
            System.out.println("--------------------------------------------------");
            System.out.println("Number of columns in row " + row + " is : " + columns);
            System.out.println("--------------------------------------------------");
        }
    }
}