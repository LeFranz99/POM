package telecom.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.nio.file.Files;

public class TelecomHomePage extends BasePage {

    // method to click on Add Customer on Guru99 telecom site
    // click Add Customer link to navigate to Add Customer page
    public void clickAddCustomerLink() {
        clickElement(By.linkText("Add Customer"));
        //clickElement(By.xpath("//button[@text()='Add Customer']"));
    }

    public void clickAddTariffPlanToCustomerLink() {
        clickElement(By.linkText("Add Tariff Plan to Customer"));
    }
}

