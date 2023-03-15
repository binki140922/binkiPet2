package settings.config;

import org.aeonbits.owner.ConfigFactory;

public class TestConfiguration {

    private final MobileConfig CONFIG;
    public static String login;
    public static String userPassword;
    public static String urlApplicationBrowserstack;
    public static String urlBrowserstack;
    public static String device;
    public static String osVersion;
    public static String project;
    public static String buildNumber;
    public static String buildName;


    public TestConfiguration() {
        this.CONFIG = ConfigFactory.create(MobileConfig.class, System.getProperties());
    }

    public void init(){
        userPassword = CONFIG.getPassword();
        login = CONFIG.getLogin();
        urlApplicationBrowserstack = CONFIG.getUrlApplicationBrowserstack();
        urlBrowserstack = CONFIG.getUrlBrowserstack();
        device = CONFIG.getDevice();
        osVersion = CONFIG.getOsVersion();
        project = CONFIG.getProject();
        buildNumber = CONFIG.getBuildNumber();
        buildName = CONFIG.getBuildName();
    }
}
