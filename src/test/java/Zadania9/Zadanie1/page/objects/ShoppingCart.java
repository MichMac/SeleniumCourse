package Zadania9.Zadanie1.page.objects;


import Zadania9.page.objects.LoginPage;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class ShoppingCart {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href$='newOrderForm=']")
    private WebElement proceedToCheckoutBtn;

    public ShoppingCart() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public LoginPage clickProceedToCheckout(){
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
        logger.info("Clicked on Proceed to Checkout Button");
        return new LoginPage();
    }
}
