package cucumber.stepdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.stepdef.helpers.XpathLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

/**
 * Created by misha on 10/16/2014.
 */
public class CommonPageStepDefinitions extends AbstractPageStepDefinition{

    WebDriver driver = getDriver();

    @After("@driverQuit")
    public void testShutDown(){
        driver.quit();
    }

    @Given("^I'm on the sportsdirect site$")
    public void shouldNavigateToHomePage()
    {
        driver.navigate().to("http://www.sportsdirect.com");
    }

    @When("^I navigate to \"(.*?)\" page$")
    public void shouldNavigateToPageOnClickEvent(String pageName) throws InterruptedException {
        if (pageName.equals("back")) {
            driver.navigate().back();
            Thread.sleep(3000);
        }
        else{
            getMyWebElement(pageName).click();
            Thread.sleep(3000);
        }
    }

    @When("^I press \"(.*?)\"$")
	public void shouldClickOnElement(String element) throws Throwable {
		getMyWebElement(element).click();
		Thread.sleep(3000);
	}
}