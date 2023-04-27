package automationExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class AutomationExercise_25 extends TestBase {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Scroll down page to bottom
//5. Verify 'SUBSCRIPTION' is visible
//6. Click on arrow at bottom right side to move upward
//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

    @Test
    public void automationTest25(){
        //1. Launch browser
        //TestBase classina extends yapilarak baslatildi.
        //2.Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        assertTrue(homePage.isDisplayed());

        //4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//p[@class='pull-left']")));

        //5. Verify 'SUBSCRIPTION' is visible
        assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());

        //6. Click on arrow at bottom right side to move upward
        WebElement scrollUp = driver.findElement(By.id("scrollUp"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",scrollUp);

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        assertTrue(driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']")).isDisplayed());
    }

}
