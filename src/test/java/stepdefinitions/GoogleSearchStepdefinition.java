package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import pageObjects.GoogleHomePage;
import pageObjects.GoogleSearchResultPage;

import java.util.List;

public class GoogleSearchStepdefinition {
    GoogleHomePage googleHomePage;

    @Steps
    GoogleSearchResultPage googleSearchResultPage;

    @When("I search for {string}")
    public void iSearchFor(String searchWord) {
        googleHomePage.click_on_no_thanks_button();
        googleHomePage.send_search(searchWord);
        googleHomePage.click_on_search_button();
        List<String> output = googleHomePage.get_output();
    }

    @Then("I should see Chat GPT url in result")
    public void iShouldSeeChatGPTUrlInResult() {
        String actualUrl = googleSearchResultPage.get_first_result_link();
        String chatGptUrl = "https://openai.com";

        Serenity.recordReportData().withTitle("Actual URL").andContents(actualUrl);
        Serenity.recordReportData().withTitle("Expected URL").andContents(chatGptUrl);

        Assert.assertTrue(actualUrl.contains(chatGptUrl));
    }

}

