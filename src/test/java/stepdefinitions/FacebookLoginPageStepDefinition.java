package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.FacebookLoginPage;

public class FacebookLoginPageStepDefinition {

    FacebookLoginPage facebookLoginPage;

    @And("I navigate to facebook login page")
    public void iNavigateToFacebookLoginpage() {
        facebookLoginPage.open();
    }

    @When("I login with email {string} and password {string}")
    public void iLoginWithEmailAndPassword(String email, String password) {
        iNavigateToFacebookLoginpage();
        facebookLoginPage.send_email(email);
        facebookLoginPage.send_password(password);
        facebookLoginPage.click_on_login_button();
    }

    @Then("I should be able to see error message on Login Page as {string}")
    public void iShouldBeAbleToSeeErrorMessageAs(String expectedErrorMessage) {
        String errorMessage = facebookLoginPage.get_error_message();
        Assert.assertEquals(expectedErrorMessage,errorMessage);
    }

}
