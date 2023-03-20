package settings.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import settings.baseTest.BaseTest;
import settings.configs.TestConfig;
import settings.pages.components.HeaderDesktopLayout;
import util.TestUtil;

public class MainPage extends BaseTest {

    HeaderDesktopLayout headerDesktopLayout = new HeaderDesktopLayout();

    private SelenideElement tmpSelenideElement;

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        TestUtil.openPage(TestConfig.getBaseUrl());
        return this;
    }

    @Step("Нажимаем на хедер - {}")
    public MainPage clickHeader(String headerName) {
        headerDesktopLayout.clickHeader(headerName);
        return this;
    }

    @Step("Нажимаем на элемент - {}")
    public MainPage findAndClickText(String nameElement) {
        Selenide.$(Selectors.byText(nameElement)).click();
        return this;
    }

    @Step("Выбрать елемент у которого атрибут равен - {}")
    public MainPage findAttributElement(String nameAttribute, String valueAttribute) {
        tmpSelenideElement = Selenide.$(Selectors.byAttribute(nameAttribute, valueAttribute));
        return this;
    }

    @Step("Выбрать елемент у которого атрибут равен - {} и нажать")
    public MainPage findAndClickAttributElement(String nameAttribute, String valueAttribute) {
        Selenide.$(Selectors.byAttribute(nameAttribute, valueAttribute)).click();
        return this;
    }

    @Step("Ввести и активировать - {}")
    public MainPage setText(String text) {
        Selenide.$(tmpSelenideElement).setValue(text).pressEnter();
        return this;
    }

    @Step("Проверяем верность переадресации")
    public void checkOpenUrl(String fullUrl) {
        TestUtil.checkUrlPage(TestConfig.getBaseUrl() + fullUrl);
    }

    @Step("Проверяем видимость элемента")
    public void checkVisibleElement(String nameElement) {
        Selenide.$(Selectors.byText(nameElement)).shouldBe(Condition.visible);
    }

    @Step("Проверяем наличие текста {} в первом результате поиска")
    public void checkOneResultFaind(String text) {
        Selenide.$$(".b-serp-item__content").get(0).$(".b-serp-item__title-link")
                .shouldBe(Condition.text(text));
    }
}
