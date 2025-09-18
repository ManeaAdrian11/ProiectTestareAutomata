package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ElementHelper;

public class LogInPage {

    private static final Logger LOG = LoggerFactory.getLogger(LogInPage.class);

    private final WebDriver driver;

    private final ElementHelper helper;

    private final By Username = By.id("user-name");
    private final By Password = By.id("password");
    private final By Login = By.id("login-button");

    public LogInPage(WebDriver driver){
        this.driver = driver;
        helper = new ElementHelper(driver);
        LOG.info("Pagina LogIn inițializată");
    }

    public void open(){
        String url = "https://www.saucedemo.com/";
        LOG.info("Deschid pagina principală: {}", url);
        driver.get(url);
    }

    public void fillCredentialsStandard(String username, String password){
        LOG.info("Completez Nume de utilizator : {} și Parola: {} pentru utilizator standard", username, password);
        helper.insertText(Username, "standard_user" );
        helper.insertText(Password, "secret_sauce" );
        LOG.debug("Nume de utilizator și Parola introduse cu succes");
    }

    public void fillCredentialsProblem(String username, String password){
        LOG.info("Completez Nume de utilizator : {} și Parola: {} pentru utilizator Problem", username, password);
        helper.insertText(Username, "problem_user" );
        helper.insertText(Password, "secret_sauce" );
        LOG.debug("Nume de utilizator și Parola introduse cu succes");
    }

    public void Login(){
        helper.click(Login);
        LOG.info("Login cu success");
    }


}
