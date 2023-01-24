import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class selenideTest {

    @Test
    public void chekJunitCodeInWiki(){

        open("https://github.com/selenide/selenide");
        $("#repository-container-header nav ul li a#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").shouldBe(visible);
    }
}
