package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise_04 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */
    @Test
    public void test_04(){
       // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement mainPage=driver.findElement(By.xpath("(//div[@class='col-sm-4'])[1]"));
        String actualtitle=driver.getTitle();
        String expectedTitle="Automation Exercise";
        Assert.assertTrue(actualtitle.contains(expectedTitle));
        Assert.assertTrue(mainPage.isDisplayed());


    }


}
