package automationExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AutomationExercise_15 extends TestBase {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Signup / Login' button
//5. Fill all details in Signup and create account
//6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//7. Verify ' Logged in as username' at top
//8. Add products to cart
//9. Click 'Cart' button

    @Test
    public void automationTest15() {
        //1. Launch browser
        //TestBase classina extends yapilarak baslatildi.
        //2.Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("(//*[@id='header']//a)[5]")).click();

        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("fatMAz");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fatzalci@hotmail.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("120319fb",Keys.TAB);

        WebElement day = driver.findElement(By.xpath("(//select[@id = 'days'])"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByValue("29");
        WebElement month = driver.findElement(By.xpath("(//select[@id = 'months'])"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByIndex(5);
        WebElement year = driver.findElement(By.xpath("(//select[@id = 'years'])"));
        Select yearDropDown = new Select(year);
        yearDropDown.selectByValue("1985");
//        WebElement newsletter = driver.findElement(By.id("newsletter"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
//        actions.keyDown(newsletter,Keys.TAB).
//                keyDown(newsletter,Keys.TAB).
//                keyDown(newsletter,Keys.TAB).build().perform();
        driver.findElement(By.id("first_name")).sendKeys("Fatma");
        driver.findElement(By.id("last_name")).sendKeys("Tarim");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.id("company")).sendKeys("Apple");
        driver.findElement(By.id("address1")).sendKeys("USA");
        actions.sendKeys(Keys.TAB).perform();
        WebElement country = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(country);
        countryDropDown.selectByValue("United States");
        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("zipcode")).sendKeys("12364792");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.id("mobile_number")).sendKeys("0015067412569");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //7. Verify ' Logged in as username' at top
        //driver.findElement(By.id("dismiss-button")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        assertTrue(driver.findElement(By.xpath("//a//b")).isDisplayed());

        //8. Add products to cart
        driver.findElement(By.xpath("(//li//a)[2]")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='3'])[1]")).click();

        //9. Click 'Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();

    }
}

