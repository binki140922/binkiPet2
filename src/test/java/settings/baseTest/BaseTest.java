package settings.baseTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import settings.configs.TestConfig;
import settings.helpers.Attach;

public class BaseTest {

    TestConfig testConfig;

    @BeforeAll
    public void initMethod(){
        testConfig = new TestConfig();
        testConfig.initConfiguration();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void closeSession(){

        Attach.screenshotAs("screenShot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
