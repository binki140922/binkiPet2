package citilinkTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import settings.dataTest.ListButtonHeader;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class CitilinkTest {

    @BeforeEach
    public void setup() {
        Selenide.open("https://www.citilink.ru/");
    }

    @AfterEach
    public void closed() {
        Selenide.closeWindow();
    }

    @CsvSource(value = {
            "Журнал, https://journal.citilink.ru/",
            "Акции, https://www.citilink.ru/actions/?actions=&products=",
            "Ситилинк.Бизнес, https://www.citilink.ru/about/corporate/",
            "Конфигуратор, https://www.citilink.ru/configurator/",
            "Доставка, https://www.citilink.ru/about/delivery/",
            "Магазины, https://www.citilink.ru/about/stores/",
            "Обратная связь, https://www.citilink.ru/"
    })
    @ParameterizedTest(name = "{0}")
    public void citilinkHeaderCsvTest(String name, String url) {

        $("[data-meta-name=HeaderTopLinks]").$(byText(name)).click();
        assertThat(WebDriverRunner.url()).isEqualTo(url);
    }

    @EnumSource(ListButtonHeader.class)
    @ParameterizedTest(name = "{0}")
    public void citilinkHeaderEnumTest(ListButtonHeader listButtonHeader) {

        $("[data-meta-name=HeaderTopLinks]").$(byText(listButtonHeader.getName())).click();
        assertThat(WebDriverRunner.url()).isEqualTo(listButtonHeader.getUrl());
    }

    @MethodSource("argsFactory")
    @ParameterizedTest(name = "{0}")
    public void citilinkHeaderMethodTest(List<String> list) {

        $("[data-meta-name=HeaderTopLinks]").$(byText(list.get(0))).click();
        assertThat(WebDriverRunner.url()).isEqualTo(list.get(1));
    }

    static Stream<List<String>> argsFactory() {
        return Stream.of(List.of(ListButtonHeader.journal.getName(), ListButtonHeader.journal.getUrl()),
                List.of(ListButtonHeader.actions.getName(), ListButtonHeader.actions.getUrl()),
                List.of(ListButtonHeader.business.getName(), ListButtonHeader.business.getUrl()),
                List.of(ListButtonHeader.configurator.getName(), ListButtonHeader.configurator.getUrl()),
                List.of(ListButtonHeader.delivery.getName(), ListButtonHeader.delivery.getUrl()),
                List.of(ListButtonHeader.stores.getName(), ListButtonHeader.stores.getUrl()),
                List.of(ListButtonHeader.feedback.getName(), ListButtonHeader.feedback.getUrl())
        );
    }
}
