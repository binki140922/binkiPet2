package settings.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;

public class DataTest {

    Faker faker = new Faker(new Locale("en"));

    LocalDate date = faker.date().birthday(1,90)
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String mobileNumber = String.valueOf(faker.number().numberBetween(70000000001L, 79999999999L));

    public String year = String.valueOf(date.getYear());
    public String month = date.getMonth().toString().charAt(0) +
            date.getMonth().toString().substring(1).toLowerCase();
    public String day = String.valueOf(date.getDayOfMonth()).replaceAll("\\^0\\d", ""
            + Sdate.getDayOfMonth());

    public String subjects = getRandomValue("Maths", "Economics", "Chemistry");
    public String currentAddress = faker.address().fullAddress();
    public String email = faker.internet().emailAddress();
    public String filePatch = "avatar.jpg";

    public String state = getRandomValue("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);
    public String hobbies = getRandomValue("Sports", "Reading", "Music");
    public String gender = getRandomValue("Male", "Female", "Other");

    private String getRandomValue(String... values){
        return faker.options().option(values);
    }

    private String getRandomCity(String state){
        return switch (state) {
            case "NCR" -> getRandomValue("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> getRandomValue("Agra", "Lucknow", "Merrut");
            case "Haryana" -> getRandomValue("Karnal", "Panipat");
            case "Rajasthan" -> getRandomValue("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
