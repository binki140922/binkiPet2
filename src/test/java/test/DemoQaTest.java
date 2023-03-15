package test;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import settings.basetest.BaseTest;
import settings.data.DataTest;

public class DemoQaTest extends BaseTest {

    DataTest data = new DataTest();

    @Test
    public void practiceFormTest(){

        Allure.step("Заполняем форму", ()->{
        registrationForm.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setPhoneNumber(data.mobileNumber)
                .setDate(data.year, data.month, data.day)
                .setGender(data.gender)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .setAddress(data.currentAddress)
                .setStateAndCity(data.state, data.city)
                .uploadFileFromPatch(data.filePatch)
                .clickSumbit();
        });

        Allure.step("Проверяем форму", ()->{
        registrationForm.checkResultForm()
                .checkResultField("Student Name", data.firstName + " " + data.lastName)
                .checkResultField("Student Email", data.email)
                .checkResultField("Gender", data.gender)
                .checkResultField("Mobile", data.mobileNumber)
                .checkResultField("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResultField("Subjects", data.subjects)
                .checkResultField("Hobbies", data.hobbies)
                .checkResultField("Picture", data.filePatch)
                .checkResultField("Address", data.currentAddress)
                .checkResultField("State and City", data.state + " " + data.city);
        });
    }
}
