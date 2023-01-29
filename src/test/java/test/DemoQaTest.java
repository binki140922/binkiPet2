package test;

import org.junit.jupiter.api.Test;
import settings.basetest.BaseTest;

public class DemoQaTest extends BaseTest {

    private static final String FIRSTNAME = "testFirstName";
    private static final String LASTNAME = "testLastName";
    private static final String MOBILE_NUMBER = "1234567890";
    private static final String YEAR = "1900";
    private static final String MONTH = "January";
    private static final String DAY = "01";
    private static final String SUBJECTS = "Maths";
    private static final String CURRENT_ADDRESS = "testAddress";
    private static final String EMAIL = "testEmail@mail.com";
    private static final String FILE_PATCH = "avatar.jpg";
    private static final String STATE = "NCR";
    private static final String CITY = "Delhi";
    private static final String HOBBIES = "Sports";
    private static final String GENDER = "Male";

    @Test
    public void practiceFormTest(){

        //Akt
        registrationForm.openPage()
                .setFirstName(FIRSTNAME)
                .setLastName(LASTNAME)
                .setEmail(EMAIL)
                .setPhoneNumber(MOBILE_NUMBER)
                .setDate(YEAR, MONTH, DAY)
                .setGender(GENDER)
                .setSubjects(SUBJECTS)
                .setHobbies(HOBBIES)
                .setAddress(CURRENT_ADDRESS)
                .setStateAndCity(STATE, CITY)
                .uploadFileFromPatch(FILE_PATCH)
                .clickSumbit();

        //Assert
        registrationForm.checkResultForm()
                .checkResultField("Student Name", FIRSTNAME + " " + LASTNAME)
                .checkResultField("Student Email", EMAIL)
                .checkResultField("Gender", GENDER)
                .checkResultField("Mobile", MOBILE_NUMBER)
                .checkResultField("Date of Birth", DAY + " " + MONTH + "," + YEAR)
                .checkResultField("Subjects", SUBJECTS)
                .checkResultField("Hobbies", HOBBIES)
                .checkResultField("Picture", FILE_PATCH)
                .checkResultField("Address", CURRENT_ADDRESS)
                .checkResultField("State and City", STATE + " " + CITY);
    }
}
