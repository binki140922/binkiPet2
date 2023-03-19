package settings.driver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import settings.configs.TestConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver implements WebDriverProvider {

    public static URL getDesktopURL() {
        try {
            return new URL(TestConfig.getBaseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(capabilities);

        desiredCapabilities.setCapability("baseUrl", System.getProperty("baseUrl"));
        desiredCapabilities.setCapability("browser", System.getProperty("browser"));
        desiredCapabilities.setCapability("browserVersion", System.getProperty("browserVersion"));
        desiredCapabilities.setCapability("browserSize", System.getProperty("resolution"));
        desiredCapabilities.setCapability("remote", System.getProperty("baseUrlVideo"));

        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);


        return new RemoteWebDriver(getDesktopURL(), desiredCapabilities);
    }
}
