import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty",
                "junit:target/JUnitReports.xml", "html:target/HtmlReports.html",
                "json:target/JSONReport.json"}, monochrome = true,
        tags = "@regressionLogin"
)
public class CucumberRunner {
}
