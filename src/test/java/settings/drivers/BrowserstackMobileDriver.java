package settings.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import settings.config.TestConfiguration;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", TestConfiguration.login);
        mutableCapabilities.setCapability("browserstack.key", TestConfiguration.userPassword);

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", TestConfiguration.urlApplicationBrowserstack);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", TestConfiguration.device);
        mutableCapabilities.setCapability("os_version", TestConfiguration.osVersion);

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", TestConfiguration.project);
        mutableCapabilities.setCapability("build", TestConfiguration.buildNumber);
        mutableCapabilities.setCapability("name", TestConfiguration.buildName);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(new URL(TestConfiguration.urlBrowserstack), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}


