package settings.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeaderDLData {

    CARDS("Карты", "cards/"),
    DEPOSIT("Вклады", "make-money/"),
    CREDIT("Кредиты", "get-money/"),
    MORTGAGE("Ипотека", CREDIT.linkUrl + "mortgage/"),
    INVESTMENTS("Инвестиции", DEPOSIT.linkUrl + "investments/"),
    PREMIUM("Премиум", "everyday/package/premium/");

    private final String linkName;
    private final String linkUrl;
}
