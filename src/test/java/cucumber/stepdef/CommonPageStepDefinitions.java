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

//    @Before("@driverSetUp")
//    public void testSetUp(){
//        driver = new FirefoxDriver();
//    }
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


    private WebElement getMyWebElement(String link)
    {
        XpathLocator locator = new XpathLocator();
        WebElement webElement = null;

        if (link.equals("mega deals")){
            webElement = driver.findElement(By.xpath(locator.megadeals));
        }
        else if(link.equals("my bag")) {
            webElement = driver.findElement(By.xpath(locator.mybag));
        }
        else if (link.equals("Item1")){
            webElement = driver.findElement(By.xpath(locator.item1));
        }
        else if (link.equals("Item2")){
            webElement = driver.findElement(By.xpath(locator.item2));
        }
        else if (link.equals("two") || link.equals("four")){
            webElement = driver.findElement(By.xpath(locator.quantity));
        }
        else if (link.equals("1")){
            webElement = driver.findElement(By.xpath(locator.number));
        }
        else if (link.equals("1") || link.equals("Update Bag")){
            webElement = driver.findElement(By.xpath(locator.updateBag));
        }

        return webElement;
    }
}