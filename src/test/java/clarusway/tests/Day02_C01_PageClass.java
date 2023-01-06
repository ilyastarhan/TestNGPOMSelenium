package clarusway.tests;

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

public class Day02_C01_PageClass {


    @Test
    public void test() {
        WebDriver driver = Driver.getDriver();


        //  Navigate to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
        //  Enter the user name as standard_user
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //  Enter the password as secret_sauce
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //  Click on login button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //  Choose price low to high with soft Assert.
        Select dropDown = new Select(driver.findElement(By.tagName("select")));
        dropDown.selectByValue("lohi");
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));

        List<Double> productPrices = itemPrices.stream()
                .map(t-> t.getText().substring(1))
                .map(t-> Double.parseDouble(t))
                .collect(Collectors.toList());
        boolean flag = true;
        for (int i = 0; i < productPrices.size()-1; i++) {
            if(productPrices.get(i)>productPrices.get(i+1)){
                flag = false;
                break;
            }
        }
        SoftAssert sft = new SoftAssert();
        sft.assertTrue(flag);
        sft.assertAll();

        //  Verify item prices are sorted from low to high with hard Assert.
        Assert.assertTrue(flag);
        Driver.closeDriver();
    }
}