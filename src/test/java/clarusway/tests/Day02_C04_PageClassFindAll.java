package clarusway.tests;

import clarusway.pages.HtmlGoodiesHomePage;
import clarusway.pages.SauceDemoLoginPage;
import clarusway.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day02_C04_PageClassFindAll {



    @Test
    public void test(){
        WebDriver driver = Driver.getDriver();

        driver.get("https://www.saucedemo.com/");
        SauceDemoLoginPage homePage = new SauceDemoLoginPage();
        Assert.assertEquals(3, homePage.inputElements.size());
        driver.close();

    }
}
