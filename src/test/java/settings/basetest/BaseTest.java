package settings.basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import settings.config.TestConfiguration;
import settings.helpers.Attach;

public class BaseTest {

    @BeforeAll
    static void init() throws Exception {
        TestConfiguration testConfiguration = new TestConfiguration(System.getProperty("deviceHost"));

        //костыль для корректной работы селенида
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
