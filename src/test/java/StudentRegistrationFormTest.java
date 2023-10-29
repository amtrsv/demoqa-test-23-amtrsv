import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // секунды
    }

    @Test
    void myFirstTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Matrosov");
        $("#userEmail").setValue("andrey@matrosov.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").val("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("amtrsv.png");
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").val("Haryana").pressEnter();
        $("#react-select-4-input").val("Karnal").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(
                text("Andrey"),
                text("Matrosov"),
                text("1234567890"),
                text("17 November,1994"),
                text("English"),
                text("Sports, Reading, Music"),
                text("amtrsv.png"),
                text("Moscow"),
                text("Haryana"),
                text("Karnal")

                );
    }

    }
