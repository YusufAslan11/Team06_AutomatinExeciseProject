package automationExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class AutomationExercise_07 extends TestBase {

    @Test
    public void test07 (){
        //  1. Tarayıcıyı başlatın
        //  2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//body"));
        assertTrue(anaSayfa.isDisplayed());

        // 4. 'Test Durumları' düğmesine tıklayın
        driver.findElement(By.xpath("(//button[@type='button'][1])")).click();

        // 5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın

       WebElement testSenoryalarıSayfası = driver.findElement(By.xpath("//body[@style]"));
       assertTrue(testSenoryalarıSayfası.isDisplayed());


    }


}
