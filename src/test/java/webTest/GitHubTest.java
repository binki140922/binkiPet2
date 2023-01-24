package webTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
    @Test
    public void test(){
        open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("ul.repo-list>li a").click();
//        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
//        $$("#repository-container-header").get(3).$("span.author").shouldHave(text("selenide"));
        sleep(1000);
    }

    @Test
    public void test2(){

        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-cell")
                .$("ul>li").hover();
        $(".Popover .Popover-message").shouldHave(text("Andrei Solntsev"));
        sleep(2000);

    }
}
