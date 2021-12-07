package Zadania9.Zadanie1.page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class MainCatalog {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[contains(text(),'FI-SW-01')]")
    private WebElement AngelFishProduct;

    public MainCatalog(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public AngelFishCatalog clickAngelFishProduct(){
        WaitForElement.waitUntilElementIsClickable(AngelFishProduct);
        AngelFishProduct.click();
        logger.info("Clicked on Angel Fish Product Button");
        return new AngelFishCatalog();
    }
}
