package settings.dataTest;

public enum ListButtonHeader {

    journal("Журнал", "https://journal.citilink.ru/"),
    actions("Акции", "https://www.citilink.ru/actions/?actions=&products="),
    business("Ситилинк.Бизнес", "https://www.citilink.ru/about/corporate/"),
    configurator("Конфигуратор", "https://www.citilink.ru/configurator/"),
    delivery("Доставка", "https://www.citilink.ru/about/delivery/"),
    stores("Магазины", "https://www.citilink.ru/about/stores/"),
    feedback("Обратная связь", "https://www.citilink.ru/");

    private final String name;
    private final String url;

    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return name;
    }

    ListButtonHeader(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
