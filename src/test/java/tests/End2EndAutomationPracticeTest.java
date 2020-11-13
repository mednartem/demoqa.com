package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticePage;

import static com.codeborne.selenide.Selenide.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class End2EndAutomationPracticeTest {
    private AutomationPracticePage automationPracticePage;

    @BeforeEach
    void setup() {
        open("https://demoqa.com/automation-practice-form");
        automationPracticePage = new AutomationPracticePage();
    }

    @Test
    void end2EndAutomationPracticeTest() {
        String firstName = randomAlphabetic(10);
        String lastName = randomAlphabetic(10);
        String email = randomAlphabetic(5).concat("@test.test");
        String mobileNumber = randomNumeric(10);
        String month = "October";
        String currentAddress = randomAlphabetic(20);
        String hobby = "Sports";
        String gender = "Male";
        String nameFile = "testFile.jpg";
        String birthday;
        String subject;
        String state;
        String city;

        automationPracticePage
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterMobileNumber(mobileNumber)
                .selectGender(gender)
                .clickCalendar()
                .selectRandomYearInTheCalendar()
                .selectMonthInTheCalendar(month)
                .selectRandomDateInTheCalendar()
                .selectRandomSubject()
                .selectHobby(hobby)
                .uploadPicture(nameFile)
                .enterCurrentAddress(currentAddress)
                .selectRandomState()
                .selectRandomCity()
        ;

        birthday = automationPracticePage.getSelectedBirthDay();
        subject = automationPracticePage.getSubject();
        state = automationPracticePage.getSelectedState();
        city = automationPracticePage.getSelectedCity();

        automationPracticePage
                .clickSubmitBtn()
                .checkAllFilledRight(firstName, lastName, email, gender, mobileNumber,
                        birthday, subject, hobby, nameFile, state, city)
        ;


    }
}


