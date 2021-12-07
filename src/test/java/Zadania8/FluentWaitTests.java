package Zadania8;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import static org.testng.Assert.*;

public class FluentWaitTests {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
    }

    @Test
    public void fluentWaitTest(){

        WebElement helloWorldMsg = driver.findElement(By.xpath("//h4[text()=\"Hello World!\"]"));

        assertFalse(helloWorldMsg.isDisplayed());

        FluentWait<WebDriver> fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15));
        fluentWait.pollingEvery(Duration.ofMillis(300));
        fluentWait.ignoring(NoSuchElementException.class);

        WebElement startBtn = driver.findElement(By.tagName("button"));
        startBtn.click();

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()=\"Hello World!\"]")));

        assertTrue(helloWorldMsg.isDisplayed());


    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
