import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest {

    private static final String FIRSTNAME = "testFirstName";
    private static final String LASTNAME = "testLastName";
    private static final String MOBILE_NUMBER = "1234567890";
    private static final String DATE_OF_BIRTH = "01 January,1900";
    private static final String SUBJECTS = "Maths";
    private static final String CURRENT_ADDRESS = "testAddress";
    private static final String EMAIL = "testEmail@mail.com";
    private static final String FILE_PATCH = "avatar.jpg";
    private static final String STATE = "NCR";
    private static final String CITY = "Delhi";
    private static final String HOBBIES = "Sports";

    @BeforeAll
    public static void configurationTests(){

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void practiceFormTest(){

        open("/automation-practice-form");
        $(".main-header").parent().shouldBe(text("Practice Form"));

        //Act

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");
        $("#firstName").setValue(FIRSTNAME);
        $("#lastName").setValue(LASTNAME);
        $("#userEmail").setValue(EMAIL);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(MOBILE_NUMBER);
        $("#dateOfBirth>div").click();
        $(".react-datepicker .react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker .react-datepicker__month-select").selectOption("January");
        $(".react-datepicker .react-datepicker__month>div").$(byText("1")).click();
        $("#subjectsContainer #subjectsInput").setValue(SUBJECTS).pressEnter();
        $(byText(HOBBIES)).parent().click();
        $("#uploadPicture").uploadFromClasspath(FILE_PATCH);
        $("#currentAddress").setValue(CURRENT_ADDRESS);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(STATE)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(CITY)).click();
        $(byText("Submit")).click();

        //Assert
        $(".table-responsive").$(byText("Student Name")).parent().parent().shouldBe(text(FIRSTNAME + " " + LASTNAME));
        $(".table-responsive").$(byText("Student Email")).parent().parent().shouldBe(text(EMAIL));
        $(".table-responsive").$(byText("Gender")).parent().parent().shouldBe(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldBe(text(MOBILE_NUMBER));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldBe(text(DATE_OF_BIRTH));
        $(".table-responsive").$(byText("Subjects")).parent().shouldBe(text(SUBJECTS));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldBe(text(HOBBIES));
        $(".table-responsive").$(byText("Picture")).parent().shouldBe(text(FILE_PATCH));
        $(".table-responsive").$(byText("Address")).parent().shouldBe(text(CURRENT_ADDRESS));
        $(".table-responsive").$(byText("State and City")).parent().shouldBe(text(STATE + " " + CITY));
    }
}
