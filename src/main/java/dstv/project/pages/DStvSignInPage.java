package dstv.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;

public class DStvSignInPage extends BasePage {

    public void enterPassword(String moviePassword) {
        enterText(By.xpath("//input[@id='Password']"), moviePassword);
    }

    public void clickSignInButton() {
        clickElement(By.xpath("//button[@id='btnSubmit']"));
    }

    public String checkUserNameError() {
        return getElementText((By.xpath("//span[@id='EmailOrMobileNumber-error']")));
    }
}
