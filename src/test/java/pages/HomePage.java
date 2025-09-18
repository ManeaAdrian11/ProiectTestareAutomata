package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ElementHelper;

public class HomePage {

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    private final WebDriver driver;

    private final ElementHelper helper;

    private final By backpack = By.cssSelector("#item_4_title_link > div");
    private final By cartIcon = By.cssSelector("#shopping_cart_container > a");
    private final By onesie = By.cssSelector("#item_2_title_link > div");
    private final By sortBtn = By.cssSelector ("#header_container > div.header_secondary_container > div > span > select");

    private final By backpackHomePage = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private final By bikelightHomePage = By.cssSelector("#add-to-cart-sauce-labs-bike-light");
    private final By bolttshirtHomePage = By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");
    private final By fleecejacketHomePage = By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket");
    private final By onesieHomePage = By.cssSelector("#add-to-cart-sauce-labs-onesie");
    private final By redshirtHomePage = By.cssSelector("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");


    public HomePage(WebDriver driver){
        this.driver = driver;
        helper = new ElementHelper(driver);
        LOG.info("HomePage inițializat");
    }

    public void openBackpack(){
        LOG.info("Deschid produsul 'Sauce Labs Backpack'");
        WebElement el =helper.waitVisible(backpack);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'Sauce Labs Backpack' a fost deschis");
    }
    public void openOnesie(){
        LOG.info("Deschid produsul 'Sauce Labs Onesie'");
        WebElement el =helper.waitVisible(onesie);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'Sauce Labs Onesie' a fost deschis");
    }



    public void addToCartBackpack(){
        LOG.info("Adaug in cos produsul 'Sauce Labs Backpack'");
        WebElement el =helper.waitVisible(backpackHomePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'Sauce Labs Backpack' a fost adaugat");
    }
    public void addToCartBikelight(){
        LOG.info("Adaug in cos produsul 'Sauce Labs Bike Light'");
        WebElement el =helper.waitVisible(bikelightHomePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'Sauce Labs Bike Light' a fost adaugat");
    }
    public void addToCartBolttshirt(){
        LOG.info("Adaug in cos produsul 'Sauce Labs Bolt T-Shirt'");
        WebElement el =helper.waitVisible(bolttshirtHomePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'Sauce Labs Bolt T-Shirt' a fost adaugat");
    }
    public void addToCartFleecejacket(){
        LOG.info("Adaug in cos produsul 'Sauce Labs Fleece Jacket'");
        WebElement el =helper.waitVisible(fleecejacketHomePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'Sauce Labs Fleece Jacket' a fost adaugat");
    }
    public void addToCartOnesie(){
        LOG.info("Adaug in cos produsul 'Sauce Labs Onesie'");
        WebElement el =helper.waitVisible(onesieHomePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'Sauce Labs Onesie' a fost adaugat");
    }
    public void addToCartRedShirt(){
        LOG.info("Adaug in cos produsul 'T-Shirt (Red)'");
        WebElement el =helper.waitVisible(redshirtHomePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        LOG.info("Produsul 'T-Shirt (Red)' a fost adaugat");
    }



    public void sortLowToHigh(){
        LOG.info("Sortare dupa pret de la mic la mare");
        new Select(helper.waitVisible(sortBtn)).selectByValue("lohi");
    }
    public void sortHighToLow(){
        LOG.info("Sortare dupa pret de la mare la mic");
        new Select(helper.waitVisible(sortBtn)).selectByValue("hilo");
    }
    public void sortZtoA(){
        LOG.info("Sortare alfabetica de la Z la A");
        new Select(helper.waitVisible(sortBtn)).selectByValue("za");
    }
    public void sortAtoZ(){
        LOG.info("Sortare alfabetica de la A la Z");
        new Select(helper.waitVisible(sortBtn)).selectByValue("az");
    }

    public void openMiniCart(){
        LOG.info("Deschid mini-cart-ul");
        helper.click(cartIcon);}
}


