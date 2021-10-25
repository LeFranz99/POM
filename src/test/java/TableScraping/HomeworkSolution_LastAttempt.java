package TableScraping;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkSolution_LastAttempt extends BasePage {

    public void goTowebTableElements() {
        driver.get("http://demo.guru99.com/test/web-table-element.php");
    }

    @Test
    public void Test2_printEntryInSpecificCellInTable() {
        goTowebTableElements();

//To locate table.
        WebElement mytable = driver.findElement(By.xpath("//tbody"));

        //To locate rows of table.
        List < WebElement > tableRows = mytable.findElements(By.tagName("tr"));

        //To count rows in table.
        System.out.println("<-------------------------------------------------->");
        int rowCount = tableRows.size();
        System.out.println("Number of rows in table is : " + rowCount);
        System.out.println("<-------------------------------------------------->");
        //List<WebElement> rowColumns = tableRows.get(row).findElements(By.tagName("td"));

        // find number of columns in the row
        //int columns = rowColumns.size();

        String celltext = "";
        int row, column = 0;


        //Loop will execute for all the rows of the table
        for (row = 0; row < 4; row++) {

            //To locate columns(cells) of that specific row.
            List < WebElement > Columns_row = tableRows.get(row).findElements(By.tagName("td"));



            //Loop will execute till the last cell of that specific row.
            for (column = 0; column < 4; column++) {
                //To retrieve text from the cells.
                celltext = Columns_row.get(column).getText();

            }
        }
        //System.out.println("Number of cells In Row " + row + " are " + columns_count);
        System.out.println("Cell Value Of row number " + row + " and column number " + column + " Is " + celltext);
    }
}
