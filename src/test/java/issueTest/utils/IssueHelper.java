package issueTest.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class IssueHelper {

    @Step("Открываем сайт")
    public static void openCite(){
        Selenide.open("https://github.com/binki140922/binkiPet2/tree/qaGuru9");
    }

    @Step("Проверяем наличие вкладки issue")
    public static void issueCheck(){
        Selenide.$("#issues-tab").should(Condition.visible);
    }
}
