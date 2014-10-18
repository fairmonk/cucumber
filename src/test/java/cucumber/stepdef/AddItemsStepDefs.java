package cucumber.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by misha on 10/16/2014.
 */
public class AddItemsStepDefs {
	
	public static WebDriver driver;
	

    @Given("^I navigated to sportsdirect site$")
    public void shouldNavigateToSportsdirect() throws Throwable {
        driver = new FirefoxDriver();
        driver.navigate().to("http://www.sportsdirect.com/mega-deal");
    }    

    @When("^I add Slazenger Hooded Jacket Junior$")
    public void shouldAddSlazengerHoodedJacketJuniorItem() throws Throwable {
    	driver.findElement(By.xpath("//img[@alt='Slazenger Hooded Jacket Junior']")).click();
    	Select select = new Select(driver.findElement(By.xpath("//div/select[@id='sizeDdl']")));
    	select.selectByVisibleText("7-8 (SB)");
    	driver.findElement(By.xpath("//a[@id='aAddToBag']")).click();
    	Thread.sleep(7000);
    }

    @When("^I add No Fear Classic Jacket Junior$")
    public void shoulAddNoFearClassicJacketJuniorItem() throws Throwable {
    	driver.navigate().back();
//    	driver.navigate().to("http://www.sportsdirect.com/mega-deal");
    	Thread.sleep(7000);
    	driver.findElement(By.xpath("//img[@alt='adidas Mid Season Jacket Junior Boys ']")).click();
    	Select select = new Select(driver.findElement(By.xpath("//div/select[@id='sizeDdl']")));
    	select.selectByVisibleText("7-8 (SB)");
    	driver.findElement(By.xpath("//a[@id='aAddToBag']")).click();
    	Thread.sleep(7000);   	
    }

    @Then("^I should have two items in my basket$")
    public void checkOnItemsInBasket() throws Throwable {
    	WebElement bagQuantity= driver.findElement(By.xpath("//span[@id='bagQuantity']"));
    	String quantity = bagQuantity.getText();
    	int bagValue = Integer.parseInt(quantity);
    	
    	assertEquals("Expected to have exactly two items in bag! but didn't ", 2, bagValue);
//    	driver.quit();
    }
    
    @Given("^I navigate to bag$")
	public void shouldNavigateToCart() throws Throwable {
    	driver.findElement(By.xpath("//a[@id='aBagLink']")).click();
	}

	@When("^I increase quantity for the first item by one$")
	public void shouldIncreaseQuantityByOne() throws Throwable {
		driver.findElement(By.xpath("//img[@alt='Add one item']")).click();	
	   
	}

	@When("^I press Update Bag$")
	public void shouldUpdateTotalItemsCount() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Update bag']")).click();
		Thread.sleep(3000);
	}

	@Then("^I should have an updated number of items$")
	public void checkThatTotalItemsNumberUpdated() throws Throwable {
		WebElement bagQuantity= driver.findElement(By.xpath("//span[@id='bagQuantity']"));
    	String quantity = bagQuantity.getText();
    	int bagValue = Integer.parseInt(quantity);
    	
    	assertEquals("Expected to have exactly two items in bag! but didn't ", 4, bagValue); //it's 4 because website adds another item by default -> a magazine
    	driver.quit();
	    
	}
}
