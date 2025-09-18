package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ElementHelper;

public class CheckoutPage {

    private static final Logger LOG = LoggerFactory.getLogger(CheckoutPage.class);

    private final ElementHelper helper;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");

    private final By continueBtn = By.id("continue");
    private final By orderTotal = By.cssSelector("#checkout_summary_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div");
    private final By totalPrice = By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_total_label");
    private final By finishBtn = By.id("finish");
    private final By thankYou = By.cssSelector("#checkout_complete_container > h2");


    public CheckoutPage(WebDriver driver){
        helper = new ElementHelper(driver);
        LOG.info("CheckoutPage inițializat");
    }

    public void nameAndCode(){
        LOG.info("Completare nume si cod postal...");
        helper.insertText(firstName, "Sefu");
        helper.insertText(lastName, "Calu");
        helper.insertText(postalCode, "123456");
        LOG.info("Completat cu succes nume si cod postal.");
    }

    public void Continue(){
        LOG.info("Apăs pe butonul 'Continue'");
        helper.click(continueBtn);}

    public String getTotal(){
        String total = helper.waitVisible(orderTotal).getText();
        LOG.info("Totalul comenzii afișat: {}", total);
        return total;
    }
    public String getTotalPrice(){
        String total = helper.waitVisible(totalPrice).getText();
        LOG.info("Totalul comenzii afișat: {}", total);
        return total;

    }

    public void Finish (){
        LOG.info("Apăs pe butonul 'Finish'");
        helper.click(finishBtn);}

    public String getConfirmation(){
        String msg = helper.waitVisible(thankYou).getText();
        LOG.info("Mesaj de confirmare primit: {}", msg);
        return msg;
    }

}
