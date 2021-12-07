package Zadania8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.time.Duration;

import static org.testng.Assert.*;

public class ExplicitWaitTests {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement(){
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        removeBtn.click();

        WaitUntil(checkbox);

        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");

    }

    @Test
    public void waitForPresenceOfTheElement(){
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement removeOrAddBtn = driver.findElement(By.xpath("//button[1]"));
        WaitUntil waitUntil = new WaitUntil(driver);

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        removeOrAddBtn.click();

        waitUntil.waitUntilElementIsInVisible(checkbox);

        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");

        removeOrAddBtn.click();

        waitUntil.waitUntilElementIsInVisible(checkbox);

        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());


    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    public void WaitUntil(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
