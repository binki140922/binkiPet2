package tests.browserStack;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import settings.baseTest.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class BrowserStackSearchTest extends BaseTest {

    @Tag("android")
    @Test
    @Tag("android")
    public void searchJavaTest() {

        Allure.step("Поиск контента", () -> {
                    Selenide.$(AppiumBy.accessibilityId("Search Wikipedia")).click();
                    Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
                });

        Allure.step("Проверка резултата", () -> {
                    Selenide.$$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
    }

    @Tag("android")
    @Test
    void openNewsTest() {
        step("Поиск контента", () -> {
            Selenide.$$(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_image")).get(1).click();
        });
        step("Проверка резултата", () ->
                $(id("org.wikipedia.alpha:id/view_news_fullscreen_story_text"))
                        .shouldHave(visible));
    }

    @Tag("ios")
    @Test
    public void searchIosTest() {

        Allure.step("Поиск контента", () -> {
            Selenide.$(AppiumBy.accessibilityId("Text Button")).click();
            Selenide.$(AppiumBy.id("Text Input")).sendKeys("hello@browserstack.com");
        });
        Allure.step("Проверка резултата", () -> {
            Selenide.$(AppiumBy.id("Text Output"))
                    .shouldHave(visible);
        });
    }
}