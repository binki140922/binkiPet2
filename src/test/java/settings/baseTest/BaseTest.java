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
import settings.helpers.Attach;

public class BaseTest {

    @BeforeAll
    static void init(){
         Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //костыль для корректной работы селенида
        Selenide.open();
    }

    @AfterEach
    void closeSession(){
        String sessionId = Selenide.sessionId().toString();

//        Attach.screenshotAs("");
        Attach.pageSource();

        Selenide.closeWebDriver();

        Attach.addVideo(sessionId);
    }
}
