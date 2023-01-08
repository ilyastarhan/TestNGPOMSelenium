package clarusway.tests;

import clarusway.pages.HtmlGoodiesHomePage;
import clarusway.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day02_C03_PageClass {



    @Test
    public void test() throws InterruptedException {
        WebDriver driver = Driver.getDriver();

       // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
       // Fill in capitals by country.
        HtmlGoodiesHomePage homePage = new HtmlGoodiesHomePage();
        Actions action = new Actions(driver);
       action.dragAndDrop(homePage.copenhag, homePage.denmark)
               .dragAndDrop(homePage.rome,homePage.italy)
               .dragAndDrop(homePage.oslo,homePage.norway)
               .dragAndDrop(homePage.seoul, homePage.sKorea)
               .dragAndDrop(homePage.madrid, homePage.spain)
               .dragAndDrop(homePage.washington,homePage.usa)
               .dragAndDrop(homePage.stockholm, homePage.sweden)
               .perform();
    //   for (int i = 0; i < homePage.countrys.size(); i++) {
    //       action.dragAndDrop(homePage.capitals.get(i),homePage.countrys.get(i)).perform();
    //   }
      //  for (WebElement each : homePage.countrys){
      //      System.out.println("country = " + each.getText());
      //  }
     //  for (WebElement each : homePage.capitals){
     //      System.out.println("capital = " + each.getText());
     //  }

    }
}
