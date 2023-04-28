package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercise_14 extends TestBase {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */




    @Test
    public void test_01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement mainPage=driver.findElement(By.xpath("(//div[@class='col-sm-4'])[1]"));
        String actualtitle=driver.getTitle();
        String expectedTitle="Automation Exercise";
        Assert.assertTrue(actualtitle.contains(expectedTitle));
        Assert.assertTrue(mainPage.isDisplayed());

        //4. Add products to cart

        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
        bekle(2);
        driver.findElement(By.xpath(" //*[@id=\"empty_cart\"]/p/a")).click();
        driver.findElement(By.xpath("//p[text()=\"Premium Polo T-Shirts'*\\]/a\""));


        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN);




    }
}
