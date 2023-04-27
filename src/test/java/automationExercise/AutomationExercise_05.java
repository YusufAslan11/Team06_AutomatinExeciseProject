package automationExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class AutomationExercise_05 extends TestBase {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and already registered email address
//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible


    @Test
    public void automationTest5() {
        //1. Launch browser
        //TestBase classina extends yapilarak baslatildi.
        //2.Navigate to url 'http://automationexercise.com'
         driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("(//*[@id='header']//a)[5]")).click();
        //5. Verify 'New User Signup!' is visible
        driver.findElement(By.xpath("//h2")).isDisplayed();
        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("fatma");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fatostarim@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        //8. Verify error 'Email Address already exist!' is visible
        WebElement errorMessage = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        assertTrue(errorMessage.isDisplayed());


    }
}
