package loginPage;

import helperMethods.LoginPageHelper;
import locators.LoginPageLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Setup;
import stringVariables.LoginPageVariables;

public class LoginPage extends Setup{
    LoginPageHelper loginPageHelper = new LoginPageHelper();
    WebDriverWait wait;

    @BeforeEach
    public void driverSetup() throws Exception {
        Setup setupBrowser = new Setup();
        setupBrowser.setup("chrome");
        driver.get(BASIC_URL);
        wait = new WebDriverWait(driver, 5);

    }
    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }

    @Test
    public void testEmailId() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.emailInput));
        String actual = driver.findElement(LoginPageLocators.emailInput).getAttribute("id");
        Assertions.assertEquals(LoginPageVariables.expectedEmailInputId, actual);
    }
    @Test
    public void testPasswordId() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.emailInput));
        String actual = driver.findElement(LoginPageLocators.passwordInput).getAttribute("id");
        Assertions.assertEquals(LoginPageVariables.expectedPasswordInputId, actual);
    }
    @Test
    public void testButtonId() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.emailInput));
        String actual = driver.findElement(LoginPageLocators.loginButton).getAttribute("id");
        Assertions.assertEquals(LoginPageVariables.expectedButtonId, actual);
    }
    @Test
    public void testValidCredentials() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.emailInput));
        loginPageHelper.inputValidEmailAndPassword(LoginPageLocators.emailInput, LoginPageLocators.passwordInput, LoginPageVariables.validLogin, LoginPageVariables.validPassword);
        loginPageHelper.clickLoginButton(LoginPageLocators.loginButton);
        String actual = driver.findElement(LoginPageLocators.successMessage).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.successMessage));
        Assertions.assertEquals(LoginPageVariables.expectedSuccessMessage, actual);
    }
    @Test
    public void testInvalidCredentials() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.emailInput));
        loginPageHelper.inputValidEmailAndPassword(LoginPageLocators.emailInput, LoginPageLocators.passwordInput, LoginPageVariables.wrongLogin, LoginPageVariables.validPassword);
        loginPageHelper.clickLoginButton(LoginPageLocators.loginButton);
        String actual = driver.findElement(LoginPageLocators.errorMessage).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.errorMessage));
        Assertions.assertEquals(LoginPageVariables.expectedErrorMessage, actual);
    }
    @Test
    public void testEmailValidation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.emailInput));
        loginPageHelper.inputValidEmailAndPassword(LoginPageLocators.emailInput, LoginPageLocators.passwordInput, LoginPageVariables.invalidLogin, LoginPageVariables.validPassword);
        loginPageHelper.clickLoginButton(LoginPageLocators.loginButton);
        String actual = driver.findElement(LoginPageLocators.invalidMessage).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.invalidMessage));
        Assertions.assertEquals(LoginPageVariables.expectedInvalidMessage, actual);
    }
    @Test
    public void testEmptyValidation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.emailInput));
        loginPageHelper.clickLoginButton(LoginPageLocators.loginButton);
        String actualEmailMessage = driver.findElement(By.cssSelector("div[class='validation error']:first-of-type")).getText();
        String actualPasswordMessage = driver.findElement(By.cssSelector("div[class='validation error']:last-of-type")).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPageLocators.invalidMessage));
        Assertions.assertEquals(LoginPageVariables.expectedEmptyEmail, actualEmailMessage);
        Assertions.assertEquals(LoginPageVariables.expectedEmptyPassword, actualPasswordMessage);
    }
}
