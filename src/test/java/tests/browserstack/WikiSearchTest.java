package tests.browserstack;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import settings.basetest.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class WikiSearchTest extends BaseTest {

    @Tag("android")
    @Test
    public void checkGetStartedTest() {

        Allure.step("getting started chek", () -> {
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Свободная энциклопедия …более, чем на 300 языках"));
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Новые способы исследований"));
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Списки для чтения с синхронизацией"));
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Отправлять отчёты об использовании"));
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/acceptButton")).click();
            Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(visible);

        });
    }

    @Tag("browserstack")
    @Test
    void openNewsTest() {
        step("Поиск контента", () -> {
            Selenide.$$(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_image")).get(1).click();
        });
        step("Проверка резултата", () ->
                $(id("org.wikipedia.alpha:id/view_news_fullscreen_story_text"))
                        .shouldHave(visible));
    }
}