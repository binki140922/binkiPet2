package settings.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void selectDate(String year, String month, String day){

        $(".react-datepicker .react-datepicker__year-select").selectOption(year);
        $(".react-datepicker .react-datepicker__month-select").selectOption(month);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",
                day)).click();
    }
}
