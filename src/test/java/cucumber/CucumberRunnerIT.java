package cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by misha on 10/16/2014.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"pretty"},
        features = {"src\\test\\java\\cucumber\\features\\"},
        glue = { "src\\test\\java\\cucumber\\stepdef" }
)
public class CucumberRunnerIT {


}
