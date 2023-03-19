package settings.baseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import settings.config.TestConfiguration;
import settings.drivers.BrowserstackMobileDriver;
import settings.drivers.LocalMobileDriver;
import settings.helpers.Attach;

public class BaseTest {

    public static String HOST = System.getProperty("deviceHost");

    @BeforeAll
    static void init() throws Exception {

        System.out.println(HOST);

        TestConfiguration testConfiguration = new TestConfiguration(HOST);
        testConfiguration.init();

        if (HOST.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (HOST.equals("emulation") || HOST.equals("real")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        } else if (HOST.equals("selenoid")) {
            System.out.println("Находится в разрботке");
            throw new Exception("Находится в разрботке.");
        }

        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //костыль для корректной работы селенида
        Selenide.open();
    }

    @AfterEach
    void closeSession() {
        String HOST = System.getProperty("deviceHost");
        String sessionId = Selenide.sessionId().toString();

//        Attach.screenshotAs("");
        Attach.pageSource();

        Selenide.closeWebDriver();

        if (HOST.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}
