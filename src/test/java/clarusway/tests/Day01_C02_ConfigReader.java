package clarusway.tests;

import clarusway.utilities.ConfigReader;
import clarusway.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Day01_C02_ConfigReader {
    @Test
    public void readConfig(){
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("google_url"));
        Driver.closeDriver();
    }
}
