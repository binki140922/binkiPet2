package settings.baseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import settings.configs.TestConfig;
import settings.driver.LocalDriver;
import settings.driver.RemoteDriver;
import settings.helpers.Attach;

public class BaseTest {

    public static final String ENV = System.getProperty("env");

    @BeforeAll
    public static void initMethod() {

        TestConfig testConfig = new TestConfig();
        testConfig.initConfiguration();

        if (ENV.equals("local")){
           LocalDriver.init();

        } else if (ENV.equals("selenide")){
            Configuration.browser = RemoteDriver.class.getName();
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void closeSession() {

        Attach.screenshotAs("screenShot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWindow();
    }

}
