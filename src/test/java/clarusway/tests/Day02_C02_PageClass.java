package clarusway.tests;

import clarusway.pages.SauceDemoHomePage;
import clarusway.pages.SauceDemoLoginPage;
import clarusway.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Day02_C02_PageClass {


    @Test
    public void pageClassTest(){
        WebDriver driver = Driver.getDriver();
        //  Navigate to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
        //  Enter the user name as standard_user
        SauceDemoLoginPage lp = new SauceDemoLoginPage();
        lp.txtUsername.sendKeys("standard_user");

        //  Enter the password as secret_sauce
        lp.txtPassword.sendKeys("secret_sauce");
        //  Click on login button.
        lp.btnLogin.click();

        //  Choose price low to high with soft Assert.
        SauceDemoHomePage homePage = new SauceDemoHomePage();
        Select select = new Select(homePage.filterDropdown);
        select.selectByValue("lohi");
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("low to high"));
        Driver.closeDriver();
    }

}
