package settings.configs;

import com.codeborne.selenide.Configuration;
import lombok.AccessLevel;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class TestConfig {
    private static String BASE_URL;

    public TestConfig(){
        WebConfig CONFIG = ConfigFactory.create(WebConfig.class, System.getProperties());
                BASE_URL = CONFIG.getBaseUrl();
    }

    public void initConfiguration(){
        Configuration.baseUrl = BASE_URL;

    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
