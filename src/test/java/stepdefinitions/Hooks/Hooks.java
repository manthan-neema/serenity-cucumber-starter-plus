package stepdefinitions.Hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Hooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    @BeforeAll
    public static void print_environment_variables() {
        LOGGER.info("Serenity Variables:");
        List<String> serenityVariable = Serenity.environmentVariables().getKeys();

        for (String key : serenityVariable
        ) {
            LOGGER.info("variable name: " + key + " value: " + Serenity.environmentVariables().getProperty(key));
        }
    }

    @Before
    public void print_information(Scenario scenario) {
        LOGGER.info("@Before hook");

        LOGGER.info("Current Scenario ID: " + scenario.getId());
        LOGGER.info("Current Scenario URI: " + scenario.getUri());
        LOGGER.info("Current Scenario Name: " + scenario.getName());
        LOGGER.info("Current Scenario Tags: " + scenario.getSourceTagNames());
    }

    @AfterStep
    public void take_screenshot(Scenario scenario) {
        LOGGER.info("@AfterStep hook");
        if (Serenity.getDriver().toString().contains("Uninitialised")) {
            LOGGER.info(Serenity.getDriver().toString());
        } else {
            byte[] screenshot = ((TakesScreenshot) Serenity.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
            LOGGER.info("screenshot attached");
        }
    }
}