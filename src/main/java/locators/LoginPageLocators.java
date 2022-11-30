package locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By
    emailInput = By.id("email-input"),
    passwordInput = By.id("password-input"),
    loginButton = By.id("login-button"),
    successMessage = By.className("success"),
    errorMessage = By.className("error"),
    invalidMessage = By.className("validation")
    ;
}
