package telecom.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;

public class TelecomAddCustomerPage extends BasePage {

    // get page header
    public String getPageHeading() {
        return getElementText(By.xpath("//h1"));
    }

    public void clickDoneRadionButton() {
        clickElement(By.xpath("//label[@for='done']"));
    }

    public void clickPendingRadionButton() {
        clickElement(By.xpath("//label[@for='pending']"));
    }

    public void setFirstName(String name) {
        enterText(By.xpath("//input[@id='fname']"), name);
    }

    public void setLastName(String surname) {
        enterText(By.xpath("//input[@id='lname']"), surname);
    }

    public void setEmailAddress(String email) {
        enterText(By.xpath("//input[@id='email']"), email);
    }

    public void setAddress(String address) {
        enterText(By.xpath("//textarea[@id='message']"), address);
    }

    public void setMobileNumber(String mobile) {
        enterText(By.xpath("//input[@id='telephoneno']"), mobile);
    }

    public void clickSubmitButton() {
        clickElement(By.xpath("//input[@value='Submit' and @name='submit']"));
    }

    public String switchToAlert() {
        return driver.switchTo().alert().getText();
    }

    // special characters errors
    public String getSpecialCharacterErrorText() {
        return getElementText(By.cssSelector("label#message3"));
    }

}