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

        tumSayfaResmi();

        //4. Click on 'Signup / Login' button
      driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

      //  5. Verify 'Login to your account' is visible

        WebElement login=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        bekle(2);
        webElementResmi(login);
        Assert.assertTrue(login.isDisplayed());

        //6. Enter correct email address and password
        WebElement email=driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys("ttyusuf18@gmail.com");
        WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
        pass.sendKeys("14561456");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible

       WebElement logged=driver.findElement(By.xpath("//i[@class='fa fa-user']"));

        Assert.assertTrue(logged.isDisplayed());

        //9. Click 'Logout' button

        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        bekle(3);

        //10. Verify that user is navigated to login page
        tumSayfaResmi();
        bekle(2);

        WebElement mainPage1=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(mainPage1.isDisplayed());






    }


}
