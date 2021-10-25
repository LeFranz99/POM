package telecom.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AddTariffPlanToCustomerPage extends BasePage {

    public void enterCustomerId(String custId) {
        enterText(By.xpath("//input[@id='customer_id']"), custId);
    }

    public void clickSubmitButton() {
        clickElement(By.xpath("//input[@class='fit' and @name='submit']"));
    }

    // get page text
    public String getTextOnPage() {
        return getElementText(By.xpath("//font[contains(text(),'ACTIVE')]"));
    }

    public String checkIfTariffPlanDisplayed() {
        return getElementText(By.cssSelector("table.alt thead tr th b"));
    }

    public void scrollScrollToTable() {
        WebElement tableElement = driver.findElement(By.xpath("//table[@class='alt']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableElement);

//        WebElement tableElement = driver.findElement(By.xpath("//table[@class='alt']"));
//        String script = "arguments[0].scrollIntoView();";
//        ((JavascriptExecutor) driver).executeScript(script, tableElement);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)", "");

    }

    public void selectTariff() {
        //clickElement(By.cssSelector("input[name='tariff_plan']"));
        clickElement(By.xpath("//tbody/tr[1]/td[1]"));
    }

    public void addTariffPlan() {
        clickElement(By.xpath("//input[@value='Add Tariff Plan to Customer']"));
    }
}

