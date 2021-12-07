package Zadania9.Zadanie1;

import Zadania9.Zadanie1.page.objects.SidebarContent;
import Zadania9.page.objects.LandingPage;
import Zadania9.tests.TestBase;

import driver.DriverUtils;
import org.testng.annotations.Test;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertEquals;


public class ShoppingCartTest extends TestBase {


    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout(){

        DriverUtils.navigateToPage(APPLICATION_URL);

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        SidebarContent sidebarContent = new SidebarContent();
        String expectedResult = sidebarContent
                .clickFishLink()
                .clickAngelFishProduct()
                .clickOnAddToCartSmallAngelfish()
                .clickProceedToCheckout()
                .getWarningMessage();

        assertEquals(expectedResult,"You must sign on before attempting to check out. Please sign on and try checking out again.");

    }
}
