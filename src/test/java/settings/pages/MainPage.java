package settings.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import settings.baseTest.BaseTest;
import settings.configs.TestConfig;
import settings.pages.components.HeaderDesktopLayout;
import util.TestUtil;

public class MainPage extends BaseTest {

    HeaderDesktopLayout headerDesktopLayout = new HeaderDesktopLayout();

    @Step("Открываем главную страницу")
    public MainPage openMainPage(){
        TestUtil.openPage(TestConfig.getBaseUrl());
        return this;
    }

    @Step("Нажимаем на хедер - {}")
    public MainPage clickHeader(String headerName){
        headerDesktopLayout.clickHeader(headerName);
        return this;
    }

    @Step("Проверяем верность переадресации")
    public MainPage checkOpenUrl(String fullUrl){
        TestUtil.checkUrlPage(TestConfig.getBaseUrl() + fullUrl);
        return this;
    }

}
