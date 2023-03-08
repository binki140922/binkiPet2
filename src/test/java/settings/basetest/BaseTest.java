package settings.basetest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import settings.helper.Attach;
import settings.pages.RegistrationForm;

public abstract class BaseTest {

    public RegistrationForm registrationForm = new RegistrationForm();


    @BeforeAll
    public static void configurationTests(){

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("resolution", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");

        Configuration.remote = System.getProperty("baseUrl",
                "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void attachTests(){

        Attach.screenshotAs("screenShot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}
