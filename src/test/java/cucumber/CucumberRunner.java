package cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by misha on 10/16/2014.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"pretty","json:target/json/output.json", "html:target/html/"},
        features = {"src/test/java/cucumber/features/"},
        glue = { "cucumber.stepdef" }
)
public class CucumberRunner {


}
