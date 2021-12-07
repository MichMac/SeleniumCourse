package Zadania7;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class FileUploadTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest(){
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        WebElement uploadFileButton = driver.findElement(By.id("file-submit"));

        chooseFileButton.sendKeys("C:\\test.txt");

        sleep();

        uploadFileButton.click();

        String fileNameCheck = driver.findElement(By.id("uploaded-files")).getText();

        sleep();

        assertEquals(fileNameCheck,"test.txt");

    }


    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    public void sleep(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
