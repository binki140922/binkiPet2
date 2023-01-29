package settings.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    public static final String TITLE_MODAL = "Thanks for submitting the form";

    public void checkForm() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_MODAL));
    }

    public void checkFields(String fieldName, String value) {
        $(".modal-body").$(byText(fieldName)).parent().shouldHave(text(value));

    }
}
