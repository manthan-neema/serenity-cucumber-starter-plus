package testRunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", // verbose output
                // "usage" ,// time taken by each Step Definition,
                // "message:json:target/serenity-reports/xray.json",
                "html:target/serenity-reports/cucumber_report.html", "json:target/serenity-reports/xray.json",
                "junit:target/serenity-reports/junit.xml", "testng:target/serenity-reports/testng.xml",
                "rerun:target/serenity-reports/rerun.txt"},

        // the console output is readable as it should be
        monochrome = true,

        features = "@target/serenity-reports/rerun.txt", glue = "stepdefinitions"
// ,dryRun = true
// , tags = NO TAGS AS FAILEDRERUNNER
)
public class AllFailedJUnitReRunner {

}
