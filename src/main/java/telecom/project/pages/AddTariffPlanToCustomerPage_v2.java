package telecom.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTariffPlanToCustomerPage_v2 {

    // APPROACH 1:
    /* uses encapsulation PLUS declaring each page elements at the top of the page...
       ... each element has a method to interaction with
       may also use not inherit the driver object, but create its constructor on each page class */
    BasePage basePage = new BasePage();

    private WebDriver driver;
    private By customerIdField = By.id("customer_id");

    public AddTariffPlanToCustomerPage_v2(WebDriver driver) {
        this.driver = driver;
    }
    public void setCustomerId(String custId) {
        driver.findElement(customerIdField).sendKeys(custId);
    }

    // APPROACH 2:
    /*uses property file to maintain page elements
     some use Utility class in the utility package for property reader method*/

    public void clickSubmitButton() {
        driver.findElement(By.xpath(basePage.getDataConfigProperties("SubmitButton"))).click();
    }

    // APPROACH 3:
    // this one I've just learnt with Inspired Academy: keeps reusable methods on the basePage class
    public String getTextOnPage() {
        return basePage.getElementText(By.xpath("//font[contains(text(),'ACTIVE')]"));
    }

    // APPROACH 4:
    /*
     one using Page Factory - also, each element has a method to interaction with
     and each page elements are paced at the top of the page
     */

}

