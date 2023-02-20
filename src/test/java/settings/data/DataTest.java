package settings.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataTest {

    public String firstName;
    public String lastName;
    public String mobileNumber;
    public String year;
    public String month;
    public String day;
    public String subjects;
    public String currentAddress;
    public String email;
    public String filePatch;
    public String state;
    public String city;
    public String hobbies;
    public String gender;

    Faker fakerRu = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    public DataTest() {
        this.updateDate();
    }

    public void updateDate() {

        LocalDate date = fakerEn.date().birthday(1, 90)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        firstName = fakerRu.name().firstName();
        lastName = fakerRu.name().lastName();
        mobileNumber = fakerRu.phoneNumber().subscriberNumber(10);
        year = String.valueOf(date.getYear());
        month = date.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
        day = date.format(DateTimeFormatter.ofPattern("dd", Locale.ENGLISH));
        subjects = getRandomValue("Maths", "Economics", "Chemistry");
        currentAddress = fakerRu.address().fullAddress();
        email = fakerEn.internet().emailAddress();
        filePatch = "avatar.jpg";
        state = getRandomValue("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        city = getRandomCity(state);
        hobbies = getRandomValue("Sports", "Reading", "Music");
        gender = getRandomValue("Male", "Female", "Other");
    }

    private String getRandomValue(String... values) {
        return fakerRu.options().option(values);
    }

    private String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> getRandomValue("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> getRandomValue("Agra", "Lucknow", "Merrut");
            case "Haryana" -> getRandomValue("Karnal", "Panipat");
            case "Rajasthan" -> getRandomValue("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}