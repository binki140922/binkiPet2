import com.codeborne.selenide.Selenide;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        Selenide.open("google.com");
    }
}
