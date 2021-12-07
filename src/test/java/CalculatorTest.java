import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;



public class CalculatorTest {

    //Dane wejściowe
    public static final int FIRST_NUMBER = 5;
    public static final int SECOND_NUMBER = 4;

    Calculator calculator = new Calculator();

    //Wyniki oczekiwane
    private int correctExceptedResult = 9;
    private int incorrectExceptedResult = 10;

    @Test
    public void AssertTrue(){

        int givenValue = calculator.add(FIRST_NUMBER,SECOND_NUMBER);

        assertTrue(givenValue == correctExceptedResult);
    }

    @Test
    public void AssertFalse(){

        int givenValue = calculator.add(FIRST_NUMBER,SECOND_NUMBER);

        assertFalse(givenValue == incorrectExceptedResult);
    }

    @Test
    public void AssertEquals(){

        int givenValue = calculator.add(FIRST_NUMBER,SECOND_NUMBER);

        assertEquals(givenValue,correctExceptedResult);
    }

}
