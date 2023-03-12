package settings.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})
public interface MobileConfig extends Config {

    @Key("user.name")
    String getUserName();
    @Key("user.password")
    String getPassword();
    @Key("browserstack.url.application")
    String getUrlApplicationBrowserstack();
    @Key("setting.device")
    String getDevice();
    @Key("setting.os_version")
    String getOsVersion();
    @Key("other.project")
    String getProject();
    @Key("other.build")
    String getBuildNumber();
    @Key("other.name")
    String getBuildName();
}
