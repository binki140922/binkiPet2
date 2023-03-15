package settings.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

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


    public TestConfiguration(String deviceHost) {
        if (deviceHost.equals("browserstack")) {
            this.CONFIG = ConfigFactory.create(BrowserStackMobileConfig.class, System.getProperties());
            init();
        } else if (deviceHost.equals("emulation") || deviceHost.equals("real")) {
            this.CONFIG = ConfigFactory.create(MobileConfig.class, System.getProperties());
        } else if (deviceHost.equals("selenoid")) {
            this.CONFIG = ConfigFactory.create(SelenoidMobileConfig.class, System.getProperties());
        } else
            this.CONFIG = null;


    }

    public void init() {
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

        } else if (CONFIG instanceof MobileConfig) {
            host = ((MobileConfig) CONFIG).getHost();
            device = ((MobileConfig) CONFIG).getDevice();
            osVersion = ((MobileConfig) CONFIG).getOsVersion();
            appPackage = ((MobileConfig) CONFIG).getAppPackage();
            appActivity = ((MobileConfig) CONFIG).getAppActivity();

        } else if (CONFIG instanceof SelenoidMobileConfig) {


        }

    }
}
