package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class FormTests extends TestBase {

    @Test
    void fillFormTest() {
        String firstName = randomAlphabetic(10),
                lastName = randomAlphabetic(10),
                email = randomAlphabetic(5).concat("@test.test"),
                mobileNumber = randomNumeric(10),
                currentAddress = randomAlphabetic(20),
                hobby = "Sports",
                gender = "Male",
                fileName = "testFile.jpg",
                subject = "English",
                state = "NCR",
                city = "Delhi",
                dayBirthday = "24",
                monthBirthday = "September",
                yearBirthday = "1995";

        open("https://demoqa.com/automation-practice-form");

        automationPracticeFormPage
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterMobileNumber(mobileNumber)
                .selectGender(gender)
                .selectDateBirthday(dayBirthday, monthBirthday, yearBirthday)
                .selectSubject(subject)
                .selectHobby(hobby)
                .uploadPicture(fileName)
                .enterCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickSubmitBtn();

        automationPracticeFormPage
                .verifyAllFilledCorrect(firstName, lastName, email, gender, mobileNumber,
                        dayBirthday, monthBirthday, yearBirthday, subject,
                        hobby, fileName, state, city);

    }
}


