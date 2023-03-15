package settings.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:src/test/resources/${env}.properties"
})
public interface MobileConfig extends Config {

    @Key("user.login")
    String getLogin();
    @Key("user.password")
    String getPassword();
    @Key("browserstack.url.application")
    String getUrlApplicationBrowserstack();
    @Key("browserstack.url")
    String getUrlBrowserstack();
    @Key("settings.device")
    String getDevice();
    @Key("settings.os_version")
    String getOsVersion();
    @Key("other.project")
    String getProject();
    @Key("other.build")
    String getBuildNumber();
    @Key("other.name")
    String getBuildName();
}
