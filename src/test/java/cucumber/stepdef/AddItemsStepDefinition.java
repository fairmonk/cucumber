package cucumber.stepdef;

import cucumber.stepdef.helpers.XpathLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by misha on 10/16/2014.
 */
public class AddItemsStepDefinition extends AbstractPageStepDefinition{

    WebDriver driver = getDriver();

    @When("^I add item \"(.*?)\"$")
    public void shouldFindElementAndAddToBag(String link) throws Throwable {
        getMyWebElement(link).click();
        Thread.sleep(3000);
        setSize('s');
        driver.findElement(By.xpath(XpathLocator.addToBag)).click();
        Thread.sleep(5000);
    }

    @Then("^I should have \"(.*?)\" items in my bag$")
    public void checkNumberOfItemsInBag(String amount) throws Throwable {
    	String quantity = getMyWebElement(amount).getText();
        int quantityInt = Integer.parseInt(quantity);
    	int bagValue = Integer.parseInt(quantity);

    	assertEquals("Expected to have exactly" + amount + " items in my bag! but failed ", quantityInt, bagValue);

    }

    @When("^I increase quantity for item by \"(.*?)\"$")
    public void shouldClickANumberOfTimes(String number) throws Throwable {
        int n = Integer.parseInt(number);

        for (int i=0; i<n; i++){
            getMyWebElement(number).click();
        }
    }

}