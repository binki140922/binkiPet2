package tests.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import settings.baseTest.BaseTest;
import settings.data.HeaderDLData;
import settings.pages.MainPage;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

@Tag("desktop")
public class MainPageDesktopTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Disabled
    @Tags(value = {@Tag("regress"),  @Tag("sanity")})
    @DisplayName("Проверка хедера - {}")
    @EnumSource(value = HeaderDLData.class, mode = EnumSource.Mode.INCLUDE)
    @ParameterizedTest
    public void checkHeaderDesktopLayout(HeaderDLData data){

        mainPage.openMainPage()
                .clickHeader(data.getLinkName())
                .checkOpenUrl(data.getLinkUrl());
    }

    @Disabled
    @Tags(value = {@Tag("regress"),  @Tag("sanity")})
    @DisplayName("Проверка хедера - {}")
    @Test
    public void checkButtonAlfaOnline(){

        mainPage.openMainPage();
        Selenide.$(Selectors.byText("Альфа-Онлайн")).click();

        Selenide.$(Selectors.byText("войти в Альфа-Онлайн?")).shouldBe(Condition.visible);
    }

    @Disabled
    @Tags(value = {@Tag("regress"),  @Tag("sanity")})
    @DisplayName("Проверка хедера - {}")
    @Test
    public void mortgageLayoutTest(){

        mainPage.openMainPage();
        Selenide.$(Selectors.byText("СТАТЬ КЛИЕНТОМ")).click();
        Selenide.$(Selectors.byAttribute("data-test-id","layout")).$(Selectors.byText("Ипотека")).click();

        Selenide.$(Selectors.byText("Узнайте лимит по ипотеке")).shouldBe(Condition.visible);
    }

    @Disabled
    @Tags(value = {@Tag("regress"),  @Tag("sanity")})
    @DisplayName("Проверка хедера - {}")
    @Test
    public void mortgageFaindTest(){

        mainPage.openMainPage();
        Selenide.$(Selectors.byAttribute("placeholder","Я ищу")).setValue("ипотеке").pressEnter();
        Selenide.$$(".b-serp-item__content").get(0).$(".b-serp-item__title-link")
                .shouldBe(Condition.text(" — Оформить заявку онлайн на ипотечный кредит..."));
    }


    @Tags(value = {@Tag("regress"),  @Tag("sanity")})
    @DisplayName("Проверка хедера - {}")
    @Test
    public void calculatedTest(){

        mainPage.openMainPage();
        Selenide.$("span[]").click();
        Selenide.$(Selectors.byAttribute("data-test-id","program-select")).click();
        Selenide.$$(Selectors.byAttribute("data-test-id","autocomplete")).get(2).click();
        Selenide.$("#creditTerm").setValue("30");
        Selenide.$(Selectors.byAttribute("data-test-id","monthly-payment"))
                .shouldBe(Condition.text("19 873 ₽"));

    }
}
