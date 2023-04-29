package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutomationExercise_09 {


        //•	1. Launch browser
        //•	2. Navigate to url 'http://automationexercise.com'
        //•	3. Verify that home page is visible successfully
        //•	4. Click on 'Products' button
        //•	5. Verify user is navigated to ALL PRODUCTS page successfully
        //•	6. Enter product name in search input and click search button
        //•	7. Verify 'SEARCHED PRODUCTS' is visible
        //•	8. Verify all the products related to search are visible

        @Test
        public void test09() throws InterruptedException {
            //•	1. Launch browser
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //•	2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");

            //•	3. Verify that home page is visible successfully
            WebElement homePage= driver.findElement(By.xpath("//*[@aria-hidden='false']"));
            Assert.assertTrue(homePage.isDisplayed());

            //•	4. Click on 'Products' button
            driver.findElement(By.xpath("//a[@href='/products']")).click();



            //•	5. Verify user is navigated to ALL PRODUCTS page successfully
            driver.navigate().refresh();//çıkan reklam için reklamı kapatıyor
            driver.findElement(By.xpath("//a[@href='/products']")).click();

            String actualData=driver.getCurrentUrl();
            System.out.println(actualData);
            String expectedData="https://automationexercise.com/products";
            Assert.assertEquals(expectedData,actualData);

            //•	6. Enter product name in search input and click search button

            WebElement searchBox=driver.findElement(By.xpath("//input[@id='search_product']"));
            searchBox.sendKeys("Men Tshirt");
            driver.findElement(By.xpath("//*[@id='submit_search']")).click();

            //•	7. Verify 'SEARCHED PRODUCTS' is visible
            WebElement searchedProducts= driver.findElement(By.xpath("//*[@class='title text-center']"));
            Assert.assertTrue(searchedProducts.isDisplayed());

            //•	8. Verify all the products related to search are visible
            driver.navigate().back();
            List<WebElement> allProducts  =  driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));

            for (WebElement w:allProducts) {
                Assert.assertTrue(w.isDisplayed());
                Thread.sleep(300);
            }


        }
}
