package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class AutomationExercise_19 {



        //•	1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        //•	3. Click on 'Products' button
        //•	4. Verify that Brands are visible on left side bar
        //•	5. Click on any brand name
        //•	6. Verify that user is navigated to brand page and brand products are displayed
        //•	7. On left side bar, click on any other brand link
        //•	8. Verify that user is navigated to that brand page and can see products

        @Test
        public void test19() {

            //•	1. Launch browser
            WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // 2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");

            //•	3. Click on 'Products' button
            WebElement products = driver.findElement(By.xpath(" //a[@href='/products']"));
            products.click();

            //•	4. Verify that Brands are visible on left side bar
            driver.navigate().refresh();//reklamı kapatık
            WebElement brands = driver.findElement(By.xpath("//h2[text()='Brands']"));
            Assert.assertTrue(brands.isDisplayed());

            //•	5. Click on any brand name
            driver.findElement(By.xpath("//a[text()='Polo']")).click();

            //•	6. Verify that user is navigated to brand page and brand products are displayed
            WebElement poloBrandProductsText = driver.findElement(By.xpath("(//h2)[3]"));
            Assert.assertTrue(poloBrandProductsText.isDisplayed());

            List<WebElement> poloProducts = driver.findElements(By.xpath("//img[@alt='ecommerce website products']"));

            for (WebElement w : poloProducts) {
                Assert.assertTrue(w.isDisplayed());

            }

            //•	7. On left side bar, click on any other brand link

            WebElement babyhug = driver.findElement(By.xpath("//a[text()='Babyhug']"));
            babyhug.click();

            //•	8. Verify that user is navigated to that brand page and can see products
            String actualTitle = driver.getTitle();
            System.out.println(actualTitle);
            String expectedTitle = "Automation Exercise - Babyhug Products";
            Assert.assertEquals(expectedTitle, actualTitle);

            List<WebElement> babyProducts = driver.findElements(By.xpath("//img[@alt='ecommerce website products']"));

            for (WebElement w : babyProducts) {
                Assert.assertTrue(w.isDisplayed());

            }
        }
    }
