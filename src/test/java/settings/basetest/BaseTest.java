package settings.basetest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import settings.pages.RegistrationForm;

public abstract class BaseTest {

    public RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    public static void configurationTests(){

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

}
