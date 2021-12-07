package Zadania9.Zadanie1.page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class AngelFishCatalog {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement smallAngelfishAddToCartBtn;

    public AngelFishCatalog(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public ShoppingCart clickOnAddToCartSmallAngelfish(){
        WaitForElement.waitUntilElementIsClickable(smallAngelfishAddToCartBtn);
        smallAngelfishAddToCartBtn.click();
        logger.info("Clicked on Add to Cart Small Angel Fish Button");
        return new ShoppingCart();
    }
}

