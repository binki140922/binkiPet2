package settings.pages;

import settings.pages.components.CalendarComponent;
import settings.pages.components.ResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationForm {

    private static final String TITLE_TEXT = "Student Registration Form";

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultModal resultModal = new ResultModal();

    public RegistrationForm openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");

        return this;
    }

    public RegistrationForm setFirstName(String firstName){
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationForm setLastName(String lastName){
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationForm setEmail(String email){
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationForm setPhoneNumber(String phoneNumber){
        $("#userNumber").setValue(phoneNumber);

        return this;
    }

    public RegistrationForm setDate(String year, String month, String day){
        $("#dateOfBirth>div").click();
        calendarComponent.selectDate(year, month, day);

        return this;
    }

    public RegistrationForm setGender(String gender){
        $("#genterWrapper").$(byText(gender)).parent().click();

        return this;
    }

    public RegistrationForm setSubjects(String subjects){
        $("#subjectsContainer #subjectsInput").setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationForm setHobbies(String hobbies){
        $(byText(hobbies)).parent().click();

        return this;
    }

    public RegistrationForm setAddress(String address){
        $("#currentAddress").setValue(address);

        return this;
    }

    public RegistrationForm setStateAndCity(String state, String city){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationForm uploadFileFromPatch(String patch){
        $("#uploadPicture").uploadFromClasspath(patch);

        return this;
    }

    public void clickSumbit(){
        $(byText("Submit")).click();
    }

    public RegistrationForm checkResultForm() {
        resultModal.checkForm();

        return this;
    }

    public RegistrationForm checkResultField(String fieldName, String value){
        resultModal.checkFields(fieldName, value);

        return this;
    }
}
