package issueTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import issueTest.utils.IssueHelper;
import org.junit.jupiter.api.Test;

public class IssueTest {

    @Test
    public void issueCheckListenerTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        Selenide.open("https://github.com/binki140922/binkiPet2/tree/qaGuru9");
        Selenide.$("#issues-tab").should(Condition.visible);
    }

    @Test
    public void issueCheckLambdaTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Allure.step("Открываем сайт", () ->
                Selenide.open("https://github.com/binki140922/binkiPet2/tree/qaGuru9")
        );
        Allure.step("Проверяем наличие вкладки issue", () ->
                Selenide.$("#issues-tab").should(Condition.visible)
        );
    }

    @Test
    public void issueCheckAnnotationTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        IssueHelper.openCite();
        IssueHelper.issueCheck();
    }
}
