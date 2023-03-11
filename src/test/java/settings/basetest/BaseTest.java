package settings.basetest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import settings.config.AppConfiguration;
import settings.config.WebConfig;
import settings.helper.Attach;
import settings.pages.RegistrationForm;

public abstract class BaseTest {

    public RegistrationForm registrationForm = new RegistrationForm();


    @BeforeAll
    public static void configurationTests(){

        AppConfiguration appConfiguration = new AppConfiguration();
        appConfiguration.webConf();
    }

    @AfterEach
    public void attachTests(){
        Attach.screenshotAs("screenShot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
