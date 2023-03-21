package settings.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import settings.drivers.BrowserstackMobileDriver;
import settings.drivers.LocalMobileDriver;

public class TestConfiguration {

    private final Config CONFIG;
    public static String login;
    public static String userPassword;
    public static String urlApplicationBrowserstack;
    public static String urlBrowserstack;
    public static String device;
    public static String osVersion;
    public static String project;
    public static String buildNumber;
    public static String buildName;
    public static String appPackage;
    public static String appActivity;
    public static String host;


    public TestConfiguration(String deviceHost) throws Exception {
        switch (deviceHost) {
            case "browserstack": {
                this.CONFIG = ConfigFactory.create(BrowserStackMobileConfig.class, System.getProperties());
                break;
            }
            case "emulation": {
            }
            case "real": {
                this.CONFIG = ConfigFactory.create(MobileConfig.class, System.getProperties());
                break;
            }
            case "selenoid": {
                this.CONFIG = ConfigFactory.create(SelenoidMobileConfig.class, System.getProperties());
                break;
            }
            default: {
                throw new Exception("Не верное окружение");
            }
        }

        this.init();

    }

    public void init() throws Exception {
        if (CONFIG instanceof BrowserStackMobileConfig) {
            userPassword = ((BrowserStackMobileConfig) CONFIG).getPassword();
            login = ((BrowserStackMobileConfig) CONFIG).getLogin();
            urlApplicationBrowserstack = ((BrowserStackMobileConfig) CONFIG).getUrlApplicationBrowserstack();
            urlBrowserstack = ((BrowserStackMobileConfig) CONFIG).getUrlBrowserstack();
            device = ((BrowserStackMobileConfig) CONFIG).getDevice();
            osVersion = ((BrowserStackMobileConfig) CONFIG).getOsVersion();
            project = ((BrowserStackMobileConfig) CONFIG).getProject();
            buildNumber = ((BrowserStackMobileConfig) CONFIG).getBuildNumber();
            buildName = ((BrowserStackMobileConfig) CONFIG).getBuildName();
            Configuration.browser = BrowserstackMobileDriver.class.getName();

        } else if (CONFIG instanceof MobileConfig) {
            host = ((MobileConfig) CONFIG).getHost();
            device = ((MobileConfig) CONFIG).getDevice();
            osVersion = ((MobileConfig) CONFIG).getOsVersion();
            appPackage = ((MobileConfig) CONFIG).getAppPackage();
            appActivity = ((MobileConfig) CONFIG).getAppActivity();
            Configuration.browser = LocalMobileDriver.class.getName();

        } else if (CONFIG instanceof SelenoidMobileConfig) {
            throw new Exception("Находится в разрботке.");
        }
    }
}
