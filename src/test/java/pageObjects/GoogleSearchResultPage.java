package pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchResultPage extends PageObject {

    @FindBy(xpath = "(//cite[@role='text'])[1]")
    WebElementFacade linkFirstResult;

    @Step
    public String get_first_result_link() {
    return linkFirstResult.getText();
    }
}
