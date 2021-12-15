package activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AuthorizationActivity {
    AndroidDriver driver;
    private WebElement nextButton;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement goToMailButton;

    public AuthorizationActivity(AndroidDriver driver){
        this.driver = driver;
    }

    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }

    public WebElement chooseYandexMail() {
        return driver.findElementById("ru.yandex.mail:id/list_yandex");
    }

    private WebElement getLoginField() {
        return driver.findElementById("ru.yandex.mail:id/edit_login");
    }
    private WebElement getNextButton() {
        return driver.findElementById("ru.yandex.mail:id/button_next");
    }
    private WebElement getPasswordField() {
        return driver.findElementById("ru.yandex.mail:id/edit_password");
    }
    private WebElement getGoToMailButton() {
        return driver.findElementById("ru.yandex.mail:id/go_to_mail_button");
    }

    public void inputLogin(){
        loginField = getLoginField();
        loginField.sendKeys("usmonamir");
        nextButton = getNextButton();
        nextButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void inputPassword(){
        passwordField = getPasswordField();
        passwordField.sendKeys("amir0036");
        nextButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void goToMail(){
        goToMailButton = getGoToMailButton();
        goToMailButton.click();
    }
}
