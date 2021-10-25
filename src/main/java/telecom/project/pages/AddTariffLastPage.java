package telecom.project.pages;

import frameWorkClasses.BasePage;
import org.openqa.selenium.By;

public class AddTariffLastPage extends BasePage {

    public String getPageHeader() {
        return getElementText(By.xpath("//h2"));

    }

}
