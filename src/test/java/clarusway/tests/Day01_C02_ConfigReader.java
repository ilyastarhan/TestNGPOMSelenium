package clarusway.tests;

import clarusway.utilities.ConfigReader;
import clarusway.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day01_C02_ConfigReader {
    @Test
    public void readConfig(){
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("google_url"));
        Driver.closeDriver();

    }
}
