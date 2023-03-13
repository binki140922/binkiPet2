package settings.configs;

import com.codeborne.selenide.Configuration;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

@Getter
public class TestConfig {

    private final WebConfig CONFIG;

    public TestConfig(){
                this.CONFIG = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    public void initConfiguration(){
        Configuration.baseUrl = CONFIG.getBaseUrl();

    }
}
