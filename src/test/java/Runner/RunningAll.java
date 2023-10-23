package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Step",
        plugin = {"html:target/HTML_report.html", "json:target/JSON_report.json", "junit:target/XML_report.xml"}
)

public class RunningAll {

}
