package pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;


@DefaultUrl("https://www.google.co.in")
public class GoogleHomePage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleHomePage.class);

    @FindBy(css = "[title='Search']")
    WebElementFacade txtSearch;

    @FindBy(xpath = "//div/span[contains(text(),'chat gpt')]")
    WebElementFacade btnSearch;

    @FindBy(xpath = "//button[contains(text(),'No thanks')]")
    WebElementFacade btnNoThanks;

    @FindBy(xpath = "//span[contains(text(), 'username')]//following::td[1]")
    WebElementFacade txtUsername;

    enum GoogleSearchOptions {
        A, B, C
    }


    public void send_search(String searchWord) {
        (txtSearch).sendKeys(searchWord);
        LOGGER.info("sent txtSearch: " + txtSearch);
    }

    public void click_on_search_button() {
        (btnSearch).click();
        LOGGER.info("clicked btnSearch");
    }

    @Step
    public void click_on_no_thanks_button() {
        getDriver().switchTo().frame("callout");

        waitForCondition().until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'No thanks')]"))
        );

        (btnNoThanks).waitUntilClickable().click();
        LOGGER.info("clicked btnNoThanks");

        getDriver().switchTo().parentFrame();


    }

    private void switch_frame_call_out() {
        getDriver().switchTo().frame("callout");
        LOGGER.info("switched to callout frame");
    }

    public List<String> get_output() {
//        Single Element List⇒
        return Collections.singletonList("Successful");
    }


}
