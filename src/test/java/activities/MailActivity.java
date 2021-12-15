package activities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MailActivity {
    private AndroidDriver driver;
    private WebElement menuButton;

    public MailActivity(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement getMenuButton() {
        return driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Открыть меню\"]");
        //return driver.findElementByAccessibilityId("Открыть меню");
    }

    private WebElement getSendButton() {
        return driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"Папка Отправленные, 0 непрочитанных\"]");
    }
    public void sendedMailsCheck() {
        menuButton = getMenuButton();
        menuButton.click();
        //"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]
        getSendButton().click();
    }

    public void settingsOpen() throws InterruptedException {
        menuButton = getMenuButton();
        menuButton.click();
        waiting(1000);

        driver.swipe(300,1700,300,100,500);
        waiting(1000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.tap(1,200,1430, 300);
    }

    public void exit() {
        driver.tap(1,200,1680,300);
    }

    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }
}
