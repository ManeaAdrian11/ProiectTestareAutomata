package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ElementHelper;

public class MiniCartPage {

    private static final Logger LOG = LoggerFactory.getLogger(MiniCartPage.class);

    private final ElementHelper helper;

    private final By checkoutBtn = By.id("checkout");

    public MiniCartPage(WebDriver driver){
        helper = new ElementHelper(driver);
        LOG.info("MiniCartPage inițializat");
    }

    public void proceedToCheckout(){
        LOG.info("Apăs pe butonul 'Proceed to Checkout' din mini-cart");
        helper.click(checkoutBtn);
        LOG.info("Am apăsat pe 'Proceed to Checkout'");
    }

}
