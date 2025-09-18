package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementHelper {

    private final WebDriver driver;

    private final WebDriverWait wait;

    public ElementHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement waitVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator){
        waitClickable(locator).click();
    }

    public void insertText(By locator, String text){
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    public boolean isPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }
}
