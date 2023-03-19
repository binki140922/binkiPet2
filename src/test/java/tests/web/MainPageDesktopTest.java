package tests.web;

import org.aeonbits.owner.Config;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import settings.baseTest.BaseTest;
import settings.configs.TestConfig;
import settings.data.HeaderDLData;
import settings.pages.MainPage;

@Tag("desktop")
public class MainPageDesktopTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @EnumSource(value = HeaderDLData.class, mode = EnumSource.Mode.INCLUDE)
    @ParameterizedTest
    public void checkHeaderDesktopLayout(HeaderDLData data){
        mainPage.openMainPage()
                .clickHeader(data.getLinkName())
                .checkOpenUrl(data.getLinkUrl());
    }
}
