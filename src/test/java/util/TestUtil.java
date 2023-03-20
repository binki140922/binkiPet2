package util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtil {

    public static void checkUrlPage(String fullUrl) {
        assertThat(WebDriverRunner.url()).isEqualTo(fullUrl);
    }

    public static void openPage(String url) {
        Selenide.open(url);
    }
}