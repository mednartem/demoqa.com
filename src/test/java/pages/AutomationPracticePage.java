package pages;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticePage {

    public AutomationPracticePage enterFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }

    public AutomationPracticePage enterLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public AutomationPracticePage enterEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public AutomationPracticePage enterMobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);

        return this;
    }

    public AutomationPracticePage selectGender(String gender) {
        $(byText(gender)).click();

        return this;
    }

    public AutomationPracticePage selectDateBirthday(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day).click();

        return this;
    }

    public AutomationPracticePage selectSubject(String subjectName) {
        $("#subjectsInput").setValue("e");
        $$("div[id^=\"react-select-2-option\"]").find(text(subjectName)).click();

        return this;
    }

    public AutomationPracticePage selectHobby(String hobby) {
        $(byText(hobby)).click();

        return this;
    }

    public AutomationPracticePage uploadPicture(String fileName) {
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/" + fileName));

        return this;
    }

    public AutomationPracticePage enterCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);

        return this;
    }

    public AutomationPracticePage selectState(String state) {
        $(byText("Select State")).scrollTo().click();
        $$("div[id^=\"react-select-3-option\"]").find(text(state)).click();

        return this;
    }

    public AutomationPracticePage selectCity(String city) {
        $(byText("Select City")).scrollTo().click();
        $$("div[id^=\"react-select-4-option\"]").find(text(city)).click();

        return this;
    }

    public AutomationPracticePage clickSubmitBtn() {
        $("#submit").click();
        return this;
    }

    private void verifyRowValue(String key, String value) {
        $x(String.format("//td[text()=\"%s\"]", key)).sibling(0).shouldHave(exactText(value));
    }

    public void verifyAllFilledRight(String firstName, String lastName, String email, String gender, String mobileNumber,
                                     String dayBirthday, String monthBirthday, String yearBirthday, String subject,
                                     String hobby, String fileName, String state, String city) {
        verifyRowValue("Student Name", firstName + " " + lastName);
        verifyRowValue("Student Email", email);
        verifyRowValue("Gender", gender);
        verifyRowValue("Mobile", mobileNumber);
        verifyRowValue("Date of Birth", dayBirthday + " " + monthBirthday + "," + yearBirthday);
        verifyRowValue("Subjects", subject);
        verifyRowValue("Hobbies", hobby);
        verifyRowValue("Picture", fileName);
        verifyRowValue("State and City", state + " " + city);
    }
}
