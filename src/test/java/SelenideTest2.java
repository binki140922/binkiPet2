import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest2 {

    @Test
    public void gitHubSolutionTest(){

        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(byText("Build like the best")).shouldBe(exist);
    }

    @Test
    public void dragAndDropTest(){
        
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Метод не срабатывает
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b"));

        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a header").shouldBe(text("B"));
        $("#column-b header").shouldBe(text("A"));
    }
}
