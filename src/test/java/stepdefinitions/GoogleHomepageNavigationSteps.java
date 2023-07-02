package stepdefinitions;

import io.cucumber.java.en.And;
import pageObjects.GoogleHomePage;

public class GoogleHomepageNavigationSteps {

    GoogleHomePage googleHomePage;

    @And("I navigate to google homepage")
    public void iNavigateToGoogleHomepage() {
        googleHomePage.open();
    }
}
