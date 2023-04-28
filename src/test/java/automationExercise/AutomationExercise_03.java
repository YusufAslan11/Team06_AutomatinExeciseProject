package automationExercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise_03 extends TestBase {


    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter incorrect email address and password
    //7. Click 'login' button
    //8. Verify error 'Your email or password is incorrect!' is visible

    @Test
    public void test03(){


        //1. Launch browser

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        boolean isVisible = homePage.isDisplayed();
        Assert.assertTrue("Home page is not visible",isVisible);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("(//*[.=' Signup / Login'])[2]")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertEquals("Login to your account",loginText.getText());

        //6. Enter incorrect email address and password
        Faker faker = new Faker();

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[.='Login']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement errorMessage = driver.findElement(By.xpath("//*[.='Your email or password is incorrect!']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        System.out.println(errorMessage.getText());

    }

}
