package settings.configs;

import lombok.Getter;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class TestConfig {

    private final Config CONFIG;
    @Getter
    private static String baseUrl;
    @Getter
    private static String browser;
    @Getter
    private static String browserVersion;
    @Getter
    private static String browserSize;
    @Getter
    private static String remote;
    @Getter
    private static String baseUrlVideo;

    public TestConfig() {
        CONFIG = ConfigFactory.create(DesktopConfig.class, System.getProperties());
    }

    public void initConfiguration() {
        baseUrl = ((DesktopConfig) CONFIG).getBaseUrl();
        browser = ((DesktopConfig) CONFIG).getBrowser();
        browserVersion = ((DesktopConfig) CONFIG).getBrowserVersion();
        browserSize = ((DesktopConfig) CONFIG).getBrowserSize();
        remote = ((DesktopConfig) CONFIG).getRemote();
        baseUrlVideo = ((DesktopConfig) CONFIG).getBaseUrlVideo();
    }
}
