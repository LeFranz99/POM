package TableScraping;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Lesson20210930 extends BasePage {


    public void goToTableDemo() {
        driver.get("http://demo.guru99.com/test/table.html");
    }

    @Test
    public void tablesDemo() {
        goToTableDemo();
        // to locate rows of table
        WebElement myTable = getElement(By.xpath("//tbody"));
        // locate rows of table
        List<WebElement> rows_table = myTable.findElements(By.tagName("tr"));
        //to calculate number of rows of table
        int rows_count = rows_table.size();
        // This Outer, horizontal loop executes till the last row of the table
        for (int row = 0; row < rows_count; row++) {
            // locate column(cells) of that specific table
            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
            // to calculate number of columns (cells). In that specific table.
            int columns_count = columns_row.size();
            System.out.println("Number of cells in Row " + row + " are : " + columns_count);
            // loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                // to retrieve text from that specific cell.
                String cellText = columns_row.get(column).getText();
                System.out.println("Cell Value of row number " + row + " and column number " + column + " is " + cellText);

            }
        }
    }
}
