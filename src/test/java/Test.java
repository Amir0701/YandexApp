import activities.AuthorizationActivity;
import activities.MailActivity;
import activities.Settings;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test {
    private AndroidDriver driver;
    private AuthorizationActivity authorizationActivity;
    private Settings settings;
    private MailActivity mailActivity;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        AppiumInspector appiumInspector = new AppiumInspector("ru.yandex.mail", "ru.yandex.mail.ui.LoginActivity");
        DesiredCapabilities capabilities = appiumInspector.setUp();
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        authorizationActivity = new AuthorizationActivity(driver);
        settings = new Settings(driver);
        mailActivity = new MailActivity(driver);
    }

    @org.testng.annotations.Test
    public void test() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        waiting(3000);
        //authorizationActivity.chooseYandexMail();
        //authorizationActivity.inputLogin();
        //authorizationActivity.inputPassword();
        authorizationActivity.goToMail();
        //waiting(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        mailActivity.sendedMailsCheck();
        //waiting(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mailActivity.settingsOpen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        settings.darkThemeOnOff();
        waiting(3000);

        settings.returnToMail();
        waiting(3000);

        mailActivity.exit();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }
}
