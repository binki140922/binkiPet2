package citilinkTest;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import settings.dataTest.ListButtonHeader;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CitilinkTest {

    @BeforeEach
    public void setup() {
        Selenide.open("https://www.citilink.ru/");
    }

    @Test
    public void citilinkHeaderTest() {

        $("[data-meta-name=HeaderTopLinks]").$(byText(ListButtonHeader.journal.getName())).click();
        sleep(5000);

        //открываем основную страницу
        //проверяем наличие кнопок в хедерах
    }
}
