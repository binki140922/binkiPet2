package settings.dataTest;

public enum ListButtonHeader {

    journal("Журнал"),
    actions("Акции"),
    business("Ситилинк.Бизнес"),
    configurator("Конфигуратор"),
    delivery("Доставка"),
    stores("Магазины"),
    feedback("Обратная связь");

    private final String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    ListButtonHeader(String name) {
        this.name = name;
    }
}
