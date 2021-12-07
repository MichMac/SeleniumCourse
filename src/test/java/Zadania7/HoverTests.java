package Zadania7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class HoverTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement figure1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));
        WebElement figure2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]"));
        WebElement figure3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(figure1).perform();

        sleep();

        WebElement firstUserCaption = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement secondUserCaption = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement thirdUserCaption = driver.findElement(By.xpath("//div[3]/div/h5"));

        assertEquals(firstUserCaption.getText(),"name: user1");
        assertEquals(secondUserCaption.getText(),"");
        assertEquals(thirdUserCaption.getText(),"");

        actions.moveToElement(figure2).perform();

        sleep();

        assertEquals(firstUserCaption.getText(),"");
        assertEquals(secondUserCaption.getText(),"name: user2");
        assertEquals(thirdUserCaption.getText(),"");

        actions.moveToElement(figure3).perform();

        sleep();

        assertEquals(firstUserCaption.getText(),"");
        assertEquals(secondUserCaption.getText(),"");
        assertEquals(thirdUserCaption.getText(),"name: user3");

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    public void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
