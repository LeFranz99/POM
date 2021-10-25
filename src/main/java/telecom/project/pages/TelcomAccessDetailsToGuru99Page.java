package telecom.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;

public class TelcomAccessDetailsToGuru99Page extends BasePage {

    // get page header
    public String getPageHeading() {
        return getElementText(By.xpath("//h1[text()='Access Details to Guru99 Telecom']"));
    }

    public String getCustId(){
        return getElementText(By.xpath("//h3"));
    }
}
