package settings.driver;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import settings.configs.TestConfig;

public class LocalDriver {

    @BeforeAll
    public static void init() {
        Configuration.baseUrl = TestConfig.getBaseUrl();
        Configuration.browser = TestConfig.getBrowser();
        Configuration.browserVersion = TestConfig.getBrowserVersion();
        Configuration.browserSize = TestConfig.getBrowserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
    }
}
