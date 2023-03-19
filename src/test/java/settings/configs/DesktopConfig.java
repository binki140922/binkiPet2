package settings.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})
public interface DesktopConfig extends Config {

    @Key("setting.baseUrl")
    String getBaseUrl();
    @Key("setting.browser")
    String getBrowser();
    @Key("setting.browserVersion")
    String getBrowserVersion();
    @Key("setting.browserSize")
    String getBrowserSize();
    @Key("setting.remote")
    String getRemote();
    @Key("setting.baseUrlVideo")
    String getBaseUrlVideo();
}
