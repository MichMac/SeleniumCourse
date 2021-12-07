package Zadania9.Zadanie1.page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class SidebarContent {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@id=\"SidebarContent\"]/a[1]/img")
    private WebElement fishLink;

    public SidebarContent(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public MainCatalog clickFishLink(){
        WaitForElement.waitUntilElementIsClickable(fishLink);
        fishLink.click();
        logger.info("Clicked on Fish Link");
        return new MainCatalog();
    }
}
