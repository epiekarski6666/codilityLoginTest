package helperMethods;

import org.openqa.selenium.By;
import setup.Setup;

public class LoginPageHelper extends Setup {

    public void clickLoginButton(By locator) {
        driver.findElement(locator).click();
    }
    public void inputValidEmailAndPassword(By emailInput, By passwordInput, String login, String password){
        driver.findElement(emailInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
    }

}
