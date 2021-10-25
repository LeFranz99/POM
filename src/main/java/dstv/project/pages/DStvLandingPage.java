package dstv.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;

public class DStvLandingPage extends BasePage {
    //private By addCustomerLink = By.linkText("Add Customer");

    // method to greet the user on landing on the DSTv site
    public void greetUser() {
        System.out.println("Welcome to DSTv.");
    }

    // method to click sign-in icon on DStv's Home Page
    public void clickSignInIcon() {
        clickElement(By.xpath("//img[@alt='Sign in']"));
    }

}
