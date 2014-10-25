package cucumber.stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by misha on 10/25/2014.
 */
public class AbstractPageStepDefinition {

    protected static WebDriver driver;

    protected WebDriver getDriver(){
        if(driver == null){
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
