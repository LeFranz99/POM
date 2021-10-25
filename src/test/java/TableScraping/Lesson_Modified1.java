package TableScraping;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Lesson_Modified1 extends BasePage {
    /*
    |1|2|3|
    |4|5|6|
    |5|6| |
    |6|7|8|
    |7| | |
     */
    public void goToTableDemo() {
        driver.get("http://demo.guru99.com/test/table.html");
    }

   // @Test
    public void tablesDemo() {
        goToTableDemo();
        // locate the table
        WebElement myTable = getElement(By.xpath("/html/body/table/tbody"));

        // locate rows of table
        List<WebElement> tableRows = myTable.findElements(By.tagName("tr"));

        //find number of rows in the table
        int rowCount = tableRows.size();
        System.out.println("Number of table rows is : " + rowCount);
        System.out.println("<------------------------------------->");

        // this Outer, horizontal loop executes till the last row of the table
        for (int row = 0; row < rowCount; row++) {

            // locate column entries in each row
            List<WebElement> cellEntries = tableRows.get(row).findElements(By.tagName("td"));

            //find number of entries in each row
            int entryCount = cellEntries.size();
            System.out.println("Number of entries in row index " + row + " is : " + entryCount);

            // this Inner, vertical loop executes till the last column of the table
          for (int columnEntry = 0; columnEntry < entryCount; columnEntry++) {

                // get text entries from each row cell
                String cellText = tableRows.get(columnEntry).getText();
               // System.out.println("Cell values in row index " + row + " : " + cellText);
              System.out.println("Cell Value of row number " + row + " and column number " + columnEntry + " is " + cellText);
                System.out.println("<------------------------------------->");
                row++;
            }
        }
       // driver.close();*/
        }
    }
