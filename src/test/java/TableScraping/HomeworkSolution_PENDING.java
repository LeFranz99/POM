package TableScraping;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkSolution_PENDING extends BasePage {

    public void goTowebTableElements() {
        driver.get("http://demo.guru99.com/test/web-table-element.php");
    }

    @Test
    public void Test2_printEntryInSpecificCellInTable() {
        goTowebTableElements();
        // locate the table
        WebElement myTable = getElement(By.xpath("//tbody"));

        // locate rows of table
        List<WebElement> tableRows = myTable.findElements(By.tagName("tr"));
        // count number of rows in the table
        int rowCount = tableRows.size();
        String TextInCell = "";
        // this Outer, Vertical loop executes till the last row of the table
        for (int row = 0; row < 3; row++) {
            List<WebElement> rows = myTable.findElements(By.tagName("tr"));
            for (int column = 0; column < 3; column++) {
                List<WebElement> cellEntries = tableRows.get(3).findElements(By.tagName("td"));
                cellEntries.get(3);
            }
            // get text entry in cell #4
            String cellText = rows.get(3).getText();
            TextInCell = cellText;

        }
        System.out.println(TextInCell);
    }
}
