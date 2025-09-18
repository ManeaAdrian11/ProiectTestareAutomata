package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;


    @BeforeAll
    public static void setupDriver(){
        LOG.info("Configurare inițială WebDriverManager pentru Chrome...");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openBrowser(){
        LOG.info("Pornire browser Chrome în modul incognito...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        LOG.info("Browser Chrome pornit și maximizat. Implicit wait = 0s");
    }

    @AfterEach
    public void closeBrowser(){
        if (driver != null) {
            try {
                LOG.info("Închidere browser după test...");
                driver.quit();
                LOG.info("Browser închis cu succes.");
            } catch (Exception e) {
                LOG.error("Eroare la închiderea browserului: {}", e.getMessage(), e);
            }
        } else {
            LOG.warn("Driver null – nu există browser de închis.");
        }
    }
}
