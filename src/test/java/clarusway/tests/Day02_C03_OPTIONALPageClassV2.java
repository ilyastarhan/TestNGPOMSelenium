package clarusway.tests;

import clarusway.pages.AmazonHomePageV1;
import clarusway.pages.SauceDemoHomePage;
import clarusway.pages.SauceDemoLoginPage;
import clarusway.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.lock.qual.EnsuresLockHeld;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.WillCloseWhenClosed;
import java.time.Duration;

public class Day02_C03_OPTIONALPageClassV2 {

    @Test
    public void test(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com.tr/");

        // Driver objemiz static degil ise bu driver objemizi page class imizda kullanmak adina constructor kullaniriz
        AmazonHomePageV1 homePage = new AmazonHomePageV1(driver);

        //homePage.searchFor("modem");
        homePage.cookiesAccept();

        homePage.searchFor("msi laptop");
        homePage.navigateToOrders();
    }


}