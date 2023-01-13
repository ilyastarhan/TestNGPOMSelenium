package clarusway.pages;

import clarusway.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class AmazonHomePageV1 {

    private WebDriver ldriver;

    public AmazonHomePageV1(WebDriver driver) {
        this.ldriver = driver;

        PageFactory.initElements(ldriver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement txtSearch;

    @FindBy(id = "nav-link-accountList")
    WebElement accountAndList;

    @FindBy(id = "nav_prefetch_yourorders")
    WebElement orders;

    @FindBy(id = "sp-cc-accept")
    WebElement cookies;


    public void searchFor(String key){
        txtSearch.sendKeys(key + Keys.ENTER);
    }
    public void cookiesAccept(){
        cookies.click();
    }

    public void navigateToOrders(){
        Actions actions = new Actions(ldriver);
        actions.moveToElement(accountAndList)
                .perform();

        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(orders)).click();

    }

}
