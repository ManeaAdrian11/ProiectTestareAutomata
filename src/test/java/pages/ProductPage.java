package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ElementHelper;

public class ProductPage {

    private static final Logger LOG = LoggerFactory.getLogger(ProductPage.class);

    private final WebDriver driver;

    private final ElementHelper helper;

    private final By addToCart = By.id("add-to-cart");

    public ProductPage(WebDriver driver){
        this.driver = driver;
        helper = new ElementHelper(driver);
        LOG.info("ProductPage inițializat");
    }

    public void addToCart(){
        LOG.info("Încerc să adaug produsul în coș");
        WebElement btn = helper.waitClickable(addToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        LOG.info("Produsul a fost adăugat în coș");
    }
}
