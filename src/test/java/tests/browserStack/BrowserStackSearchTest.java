package tests.browserStack;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import settings.baseTest.BaseTest;

public class BrowserStackSearchTest extends BaseTest {

    @Test
    public void searchJavaTest() {

        Allure.step("Поиск контента", () -> {
                    Selenide.$(AppiumBy.accessibilityId("Search Wikipedia")).click();
                    Selenide.$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
                });

        Allure.step("Проверка резултата", () -> {
                    Selenide.$$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(1));
        });
    }
}