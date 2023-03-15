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
        userPassword = "45KmrPs4mGFcGWBr3rpM";
        login = "vladimirvladimir_RjSaqZ";
        urlApplicationBrowserstack = "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c";
        urlBrowserstack = "http://hub.browserstack.com/wd/hub";
        device = "Google Pixel 3";
        osVersion = "9.0";
        project = "First Java Project";
        buildNumber = "browserstack-build-1";
        buildName = "first_test";
    }
}
