package cucumber.stepdef;

import cucumber.stepdef.helpers.XpathLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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

    protected WebElement getMyWebElement(String link)
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

    protected void setSize(char size)
    {
        switch (size){
            case 's':
                Select select = new Select(driver.findElement(By.xpath(XpathLocator.sizeDropDown)));
                select.selectByVisibleText(XpathLocator.sizeElementText);
                break;
        }
    }

}
