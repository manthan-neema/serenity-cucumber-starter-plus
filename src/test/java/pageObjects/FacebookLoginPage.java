package pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@DefaultUrl("https://www.facebook.com/")
public class FacebookLoginPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacebookLoginPage.class);

    @FindBy(css = "[name='login']")
    WebElementFacade btnLogin;

    @FindBy(xpath = "//input[@id='email']")
    WebElementFacade txtEmail;

    @FindBy(xpath = "//input[@id='pass']")
    WebElementFacade txtPassword;

    @FindBy(css = "._9ay7")
    WebElementFacade hrdEmailError;

    public void send_email(String email) {
        (txtEmail).sendKeys(email);
        LOGGER.info("sent txtemail: " + txtEmail);
    }

    public void send_password(String password) {
        (txtPassword).sendKeys(password);
        LOGGER.info("sent txtpassword: " + txtPassword);
    }

    public void click_on_login_button() {
        (btnLogin).click();
        LOGGER.info("clicked btnLogin");
    }

    public String get_error_message(){
        return hrdEmailError.getText();
    }
}
