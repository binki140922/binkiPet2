package settings.pages;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import settings.baseTest.BaseTest;
import settings.configs.TestConfig;
import settings.pages.components.HeaderDesktopLayout;
import util.TestUtil;

public class MainPage extends BaseTest {

    HeaderDesktopLayout headerDesktopLayout = new HeaderDesktopLayout();

    public MainPage openMainPage(){
        TestUtil.openPage(TestConfig.getBaseUrl());
        return this;
    }

    public MainPage clickHeader(String headerName){
        headerDesktopLayout.clickHeader(headerName);
        return this;
    }

    public MainPage checkOpenUrl(String fullUrl){
        TestUtil.checkUrlPage(TestConfig.getBaseUrl() + fullUrl);
        return this;
    }

}
