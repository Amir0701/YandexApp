package activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class Settings {
    private AndroidDriver driver;
    private WebElement returnButton;
    private WebElement themeSwitch;

    public Settings(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getThemeSwitch() {
        return driver.findElementByXPath("//android.widget.Switch");
    }

    private WebElement getReturnButton() {
        return driver.findElementByAccessibilityId("Перейти вверх");
    }
    public void darkThemeOnOff() {
//        driver.tap(1,960, 790,300);
//        /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Switch
        themeSwitch = getThemeSwitch();
        themeSwitch.click();
    }
    public void returnToMail() {
        returnButton = getReturnButton();
        returnButton.click();
    }
}
