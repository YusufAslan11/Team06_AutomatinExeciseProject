package automationExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class AutomationExercise_17 extends TestBase {

    @Test
    public void test17() {

    //     1. Tarayıcıyı başlatın
    //      2. 'http://automationexercise.com' URL'sine gidin
            driver.get("http://automationexercise.com");


    //     3. Ana sayfanın başarıyla göründüğünü doğrulayın

        WebElement anaSayfa = driver.findElement(By.xpath("//body"));
        assertTrue(anaSayfa.isDisplayed());

  }

}

