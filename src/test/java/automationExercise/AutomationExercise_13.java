package automationExercise;

import org.junit.Test;
import org.openqa.selenium.*;

import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationExercise_13 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'View Product' for any product on home page
    //5. Verify product detail is opened
    //6. Increase quantity to 4
    //7. Click 'Add to cart' button
    //8. Click 'View Cart' button
    //9. Verify that product is displayed in cart page with exact quantity

    @Test
    public void test13(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());

        //4. Click 'View Product' for any product on home page
        WebElement product = driver.findElement(By.xpath("//a[@href='/product_details/2']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",product);

        bekle(2);
        product.click();

        //Google reklamlarindan dolayi iki tane İç içe iframe var.Sirayla Iframe'lere gecis yapiyoruz
        //ve cikan reklami kapatiyoruz
        closeGoogleAds();


        //5. Verify product detail is opened
        WebElement productDetails = driver.findElement(By.xpath("//*[@class='product-details']"));
        assertTrue(productDetails.isDisplayed());

        //6. Increase quantity to 4
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.click();
        bekle(2);
        quantity.sendKeys(Keys.BACK_SPACE+"4");

        //7. Click 'Add to cart' button
        bekle(2);
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //8. Click 'View Cart' button
        bekle(2);
        driver.findElement(By.xpath("//a[.='View Cart']")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        product = driver.findElement(By.xpath("//a[@href='/product_details/2']")); // product WebElement'i bayatladigi icin tekrar locate alma islemi uyguluyoruz
        assertTrue(product.isDisplayed());

        String quantityInCart = driver.findElement(By.xpath("//button[@class='disabled']")).getText();

        assertEquals("4",quantityInCart);

    }

    public void closeGoogleAds(){
        boolean case1 = true;
        boolean case2 = true;

        try {
            WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='aswift_4']")); //case 1
        } catch (NoSuchElementException e) {
            case1 = false;
        }

        try {
            WebElement iframe2 = driver.findElement(By.xpath("//iframe[@id='aswift_5']")); //case 2
        } catch (NoSuchElementException e) {
            case2 = false;
        }

        if (case1){
            driver.switchTo().frame("aswift_4");
            driver.switchTo().frame("ad_iframe");
            driver.findElement(By.xpath("//*[.='Close'][1]")).click();
            case2 = false;
        }
        else if (case2) {
            driver.switchTo().frame("aswift_5");
            driver.findElement(By.xpath("//*[@id='dismiss-button']/div/svg")).click();

        }
    }


}
