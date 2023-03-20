package settings.pages.components;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;

public class HeaderDesktopLayout {

    public void clickHeader(String headerName) {

        Selenide.$(Selectors.byText(headerName)).click();
    }
}
