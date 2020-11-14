package tests.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticePage;
import tests.TestBase;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class End2EndAutomationPracticeTest extends TestBase {
    private AutomationPracticePage automationPracticePage;

    @BeforeEach
    void setup() {
        automationPracticePage = new AutomationPracticePage();
    }

    @Test
    void end2EndAutomationPracticeTest() {
        String firstName = randomAlphabetic(10),
                lastName = randomAlphabetic(10),
                email = randomAlphabetic(5).concat("@test.test"),
                mobileNumber = randomNumeric(10),
                currentAddress = randomAlphabetic(20),
                hobby = "Sports",
                gender = "Male",
                nameFile = "testFile.jpg",
                birthday,
                subject,
                state,
                city;


        automationPracticePage
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterMobileNumber(mobileNumber)
                .selectGender(gender)
                .clickCalendar()
                .selectRandomYearInTheCalendar()
                .selectOctoberMonthInTheCalendar()
                .selectDateInTheCalendar("23")
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
                        birthday.replace("Oct ", "October,"), subject, hobby,
                        nameFile, state, city)
        ;

    }
}


