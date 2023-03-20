package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import settings.baseTest.BaseTest;
import settings.data.HeaderDLData;
import settings.pages.MainPage;

@Tag("desktop")
public class MainPageDesktopTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Tags(value = {@Tag("regress"), @Tag("sanity")})
    @DisplayName("Проверка хедера - {}")
    @EnumSource(value = HeaderDLData.class, mode = EnumSource.Mode.INCLUDE)
    @ParameterizedTest
    public void checkHeaderDesktopLayout(HeaderDLData data) {

        mainPage.openMainPage()
                .clickHeader(data.getLinkName())
                .checkOpenUrl(data.getLinkUrl());
    }

    @Tag("regress")
    @DisplayName("Проверка хедера - {}")
    @Test
    public void checkButtonAlfaOnline() {

        mainPage.openMainPage()
                .findAndClickText("Альфа-Онлайн")
                .checkVisibleElement("войти в Альфа-Онлайн?");
    }

    @Tag("regress")
    @DisplayName("Проверка хедера - {}")
    @Test
    public void mortgageLayoutTest() {

        mainPage.openMainPage()
                .findAndClickText("СТАТЬ КЛИЕНТОМ")
                .findAttributElement("data-test-id", "layout")
                .findAndClickText("Ипотека")
                .checkVisibleElement("Узнайте лимит по ипотеке");
    }

    @Tag("regress")
    @DisplayName("Проверка хедера - {}")
    @Test
    public void mortgageFaindTest() {

        mainPage.openMainPage()
                .findAttributElement("placeholder", "Я ищу")
        .setText("ипотека")
                .checkOneResultFaind(" — Оформить заявку онлайн на ипотечный кредит...");
}

    @Tags(value = {@Tag("regress"), @Tag("smoke")})
    @DisplayName("Проверка хедера - {}")
    @Test
    public void calculatedTest() {

        mainPage.openMainPage()
                .findAndClickAttributElement("data-test-id", "Main-Header-Main-DesktopLogo")
                .checkOpenUrl("");
    }
}