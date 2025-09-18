package test;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwagLabsTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(SwagLabsTest.class);

    @Test @Order(1) @Tag("Test Pozitiv")
    @DisplayName("Test 1")
    public void Test1(){
        LOG.info("STEP: Open the site and login");
        LogInPage login = new LogInPage(driver);
        login.open();
        login.fillCredentialsStandard("standard_user","secret_sauce");
        login.Login();

        LOG.info("STEP: Open home and product page");
        HomePage home = new HomePage(driver);
        home.openBackpack();

        LOG.info("STEP: Add product to cart");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        home.openMiniCart();

        LOG.info("STEP: Proceed to checkout");
        MiniCartPage mini =new MiniCartPage(driver);
        mini.proceedToCheckout();

        LOG.info("STEP: Fill name and zip code");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.nameAndCode();
        checkout.Continue();

        LOG.info("STEP: Verify total and place order");
        String total = checkout.getTotal();
        LOG.info("Displayed total: {}", total);
        assertEquals("$29.99", checkout.getTotal());

        checkout.Finish();

        LOG.info("STEP: Verify confirmation");
        String confirm = checkout.getConfirmation();
        LOG.info("Confirmation: {}", confirm);
        assertEquals("Thank you for your order!", confirm);
    }

    @Test @Order(2) @Tag("Test Pozitiv")
    @DisplayName("Test 2")
    public void Test2(){
        LOG.info("STEP: Open the site and login");
        LogInPage login = new LogInPage(driver);
        login.open();
        login.fillCredentialsStandard("standard_user","secret_sauce");
        login.Login();

        LOG.info("STEP: Open home , sort products and open product page");
        HomePage home = new HomePage(driver);
        home.sortLowToHigh();
        home.openOnesie();

        LOG.info("STEP: Add product to cart");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        home.openMiniCart();

        LOG.info("STEP: Proceed to checkout");
        MiniCartPage mini =new MiniCartPage(driver);
        mini.proceedToCheckout();

        LOG.info("STEP: Fill name and zip code");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.nameAndCode();
        checkout.Continue();

        LOG.info("STEP: Verify total and place order");
        String total = checkout.getTotal();
        LOG.info("Displayed total: {}", total);
        assertEquals("$7.99", checkout.getTotal());

        checkout.Finish();

        LOG.info("STEP: Verify confirmation");
        String confirm = checkout.getConfirmation();
        LOG.info("Confirmation: {}", confirm);
        assertEquals("Thank you for your order!", confirm);

    }

    @Test @Order(3) @Tag("Test Pozitiv")
    @DisplayName("Test 3")
    public void Test3(){
        LOG.info("STEP: Open the site and login");
        LogInPage login = new LogInPage(driver);
        login.open();
        login.fillCredentialsStandard("standard_user","secret_sauce");
        login.Login();

        LOG.info("STEP: Adding 3 products to cart");
        HomePage home = new HomePage(driver);
        home.addToCartBackpack();
        home.addToCartBikelight();
        home.addToCartBolttshirt();
        home.openMiniCart();

        LOG.info("STEP: Proceed to checkout");
        MiniCartPage mini =new MiniCartPage(driver);
        mini.proceedToCheckout();

        LOG.info("STEP: Fill name and zip code");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.nameAndCode();
        checkout.Continue();

        LOG.info("STEP: Verify total and place order");
        String total = checkout.getTotal();
        LOG.info("Displayed total: {}", total);
        assertEquals("Total: $60.45", checkout.getTotalPrice());

        checkout.Finish();

        LOG.info("STEP: Verify confirmation");
        String confirm = checkout.getConfirmation();
        LOG.info("Confirmation: {}", confirm);
        assertEquals("Thank you for your order!", confirm);
    }

    @Test @Order(4) @Tag("Test Pozitiv")
    @DisplayName("Test 4")
    public void Test4(){
        LOG.info("STEP: Open the site and login");
        LogInPage login = new LogInPage(driver);
        login.open();
        login.fillCredentialsStandard("standard_user","secret_sauce");
        login.Login();

        LOG.info("STEP: Open home and try all sorting buttons");
        HomePage home = new HomePage(driver);
        home.sortLowToHigh();
        home.sortHighToLow();
        home.sortZtoA();
        home.sortAtoZ();

        LOG.info("STEP: Adding all products to cart");
        home.addToCartBackpack();
        home.addToCartBikelight();
        home.addToCartBolttshirt();
        home.addToCartFleecejacket();
        home.addToCartOnesie();
        home.addToCartRedShirt();
        home.openMiniCart();

        LOG.info("STEP: Proceed to checkout");
        MiniCartPage mini =new MiniCartPage(driver);
        mini.proceedToCheckout();

        LOG.info("STEP: Fill name and zip code");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.nameAndCode();
        checkout.Continue();

        LOG.info("STEP: Verify total and place order");
        String total = checkout.getTotalPrice();
        LOG.info("Displayed total: {}", total);
        assertEquals("Total: $140.34", checkout.getTotalPrice());

        checkout.Finish();

        LOG.info("STEP: Verify confirmation");
        String confirm = checkout.getConfirmation();
        LOG.info("Confirmation: {}", confirm);
        assertEquals("Thank you for your order!", confirm);
    }

    @Test @Order(5) @Tag("Test Negativ")
    @DisplayName("Test 5")
    public void Test5(){
        LOG.info("STEP: Open the site and login");
        LogInPage login = new LogInPage(driver);
        login.open();
        login.fillCredentialsProblem("problem_user","secret_sauce");
        login.Login();

        LOG.info("STEP: Open home and product page");
        HomePage home = new HomePage(driver);
        home.openBackpack();

        LOG.info("STEP: Add product to cart");
        ProductPage product = new ProductPage(driver);
        product.addToCart();
        home.openMiniCart();

        LOG.info("STEP: Proceed to checkout");
        MiniCartPage mini =new MiniCartPage(driver);
        mini.proceedToCheckout();

        LOG.info("STEP: Fill name and zip code");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.nameAndCode();
        checkout.Continue();

        LOG.info("STEP: Verify total and place order");
        String total = checkout.getTotal();
        LOG.info("Displayed total: {}", total);
        assertEquals("$29.99", checkout.getTotal());

        checkout.Finish();

        LOG.info("STEP: Verify confirmation");
        String confirm = checkout.getConfirmation();
        LOG.info("Confirmation: {}", confirm);
        assertEquals("Thank you for your order!", confirm);
    }
}
