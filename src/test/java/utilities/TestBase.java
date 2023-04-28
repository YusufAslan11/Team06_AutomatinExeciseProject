package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestBase {
    //TestBase class'ından Obje oluşturmanın önüne geçilmesi için abstract yapılabilir
    //Orn: TestBase base = new TestBase()
    //Bu class'a extends ettiğimiz test classlarından ulaşabiliriz
    protected static WebDriver driver;
    protected ExtentReports extentReports; //Raporlamayı başlatır
    protected ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    protected ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz

    @Before
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //----------------------------------------------------------------------------------------
        //extentReports = new ExtentReports();
        //String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        //String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        //extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        //extentReports.attachReporter(extentHtmlReporter);
//
        ////Raporda gözükmesini istediğimiz bilgiler için
        //extentReports.setSystemInfo("Browser", "Chrome");
        //extentReports.setSystemInfo("Tester", "Erol");
        //extentHtmlReporter.config().setDocumentTitle("Extent Report");
        //extentHtmlReporter.config().setReportName("Smoke Test Raporu");

    }

//    @After
//    public void tearDown() throws Exception {
//        bekle(3);
//        extentReports.flush();
//        driver.quit();
//    }

    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        driver.switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //Tüm Sayfa ScreenShot
    public static void tumSayfaResmi() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement ScreenShot
    public static void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenshot" + tarih + ".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Bu method ile herhangi bir elemente JS Executer kullanarak tıklayabilirim:
    public void clickByJS(WebElement element) {

        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
        jsExecuter.executeScript("arguments[0].click();", element);

    }

    //Bu method ile herhangi bir elemente JS Executer kullanarak ekranı kaydırma yapabilirim:
    public void scrollIntoView(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    //Bu method ile sayfayı en alta kayıdırabilirim:
    public void scrollEndJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //Bu method ile sayfayı en üste kayıdırabilirim:
    public void scrollTopJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //Bu method sendKeys() methodunun alternatifidir.
    public void typeWithJS(String text, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);

    }

    //Bu method ile attribute değerlerini alabilirim:
    public void getValueByJS(WebElement id) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String attribute_Value = js.executeScript("return document.getElementById('" + id + "').value").toString();
        System.out.println("Attribute Value: = " + attribute_Value);
//        NOT: document.querySelector("p").value;  -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR

    }

}


