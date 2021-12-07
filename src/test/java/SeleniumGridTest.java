import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;
public class SeleniumGridTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        InternetExplorerOptions capability = new InternetExplorerOptions();
        capability.enablePersistentHovering();
        capability.ignoreZoomSettings();
        capability.setCapability("version","8");
        try{
        driver = new RemoteWebDriver(new URL(" http:/192.168.1.4:4444/wd/hub"), capability);
        }catch (MalformedURLException e ){
            throw new IllegalStateException("Cannot create URL", e);
        }
    }

    @Test
    public void searchInDuckDuckGoTest() {
        driver.navigate().to("https://duckduckgo.com/");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("JavaStart");
        driver.findElement(By.id("search_form_input_homepage")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
