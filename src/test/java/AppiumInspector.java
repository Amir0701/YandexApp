import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumInspector {
    private String appPackage;
    private String appActivity;

    public AppiumInspector(String appPackage, String appActivity){
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    public DesiredCapabilities setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("deviceName", "samsung SM-G935F");
        capabilities.setCapability("deviceName", "Pixel 6");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        //capabilities.setCapability("udid", "ce0516056c29de3703");
        capabilities.setCapability("udid", "19291FDF600AXW");
        //capabilities.setCapability("app","C:\\Users\\Amir\\Downloads\\Yandex Mail_v8.3.2_apkpure.com.apk");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        return capabilities;
    }
}
