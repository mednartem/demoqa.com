package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AutomationPracticePage {

    private SelenideElement getRandomElementFromList(ElementsCollection collections) {
        return collections.get(new Random().nextInt(collections.size()));
    }

    public AutomationPracticePage enterFirstName(String firstName) {
        step("Enter first name {firstName}", () ->
                $("#firstName").setValue(firstName)
        );
        return this;
    }

    @Step("Enter last name {lastName}")
    public AutomationPracticePage enterLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    @Step
    public AutomationPracticePage enterEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step
    public AutomationPracticePage enterMobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
        return this;
    }

    @Step
    public AutomationPracticePage selectGender(String gender) {
        $(byText(gender)).parent().find("input").click(usingJavaScript());
        return this;
    }

    @Step
    public AutomationPracticePage clickCalendar() {
        $("#dateOfBirthInput").click();
        return this;
    }

    @Step
    public AutomationPracticePage selectRandomYearInTheCalendar() {
        $(".react-datepicker__year-select").click();
        getRandomElementFromList($$(".react-datepicker__year-select > option")).click();
        return this;
    }

    @Step
    public AutomationPracticePage selectOctoberMonthInTheCalendar() {
        $(".react-datepicker__month-select").selectOption(9);
        return this;
    }

    @Step
    public AutomationPracticePage selectDateInTheCalendar(String date) {
        $(".react-datepicker__day--0" + date).click();
        return this;
    }

    @Step
    public String getSelectedBirthDay() {
        return $("#dateOfBirthInput").getValue();
    }

    @Step
    public AutomationPracticePage selectRandomSubject() {
        $("#subjectsInput").setValue("e");
        getRandomElementFromList($$("div[id^=\"react-select-2-option\"]").shouldBe(sizeGreaterThan(0))).click();
        return this;
    }

    @Step
    public String getSubject() {
        return $(".css-12jo7m5").getText();
    }

    @Step
    public AutomationPracticePage selectHobby(String hobby) {
        $(byText(hobby)).parent().find("input").click(usingJavaScript());
        return this;
    }

    @Step
    public AutomationPracticePage uploadPicture(String nameFile) {
        $("#uploadPicture").uploadFile(new File(nameFile));
        return this;
    }

    @Step
    public AutomationPracticePage enterCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    @Step
    public AutomationPracticePage selectRandomState() {
//        $("#react-select-3-input").setValue("n");
        $(".css-1wa3eu0-placeholder").scrollTo().click();
        getRandomElementFromList($$("div[id^=\"react-select-3-option\"]")).click();
        return this;
    }

    @Step
    public String getSelectedState() {
        return $("#state .css-1uccc91-singleValue").getText();
    }

    @Step
    public AutomationPracticePage selectRandomCity() {
//        $("#react-select-4-input").setValue("a");
        $(".css-1wa3eu0-placeholder").scrollTo().click();
        getRandomElementFromList($$("div[id^=\"react-select-4-option\"]")).click();
        return this;
    }

    @Step
    public String getSelectedCity() {
        return $("#city .css-1uccc91-singleValue").getText();
    }

    @Step
    public AutomationPracticePage clickSubmitBtn() {
        $("#submit").click();
        return this;
    }

    @Step
    public void checkAllFilledRight(String firstName, String lastName, String email, String gender, String mobileNumber,
                                    String birthday, String subject, String hobby, String nameFile, String state, String city) {
        $x("//td[text()=\"Student Name\"]").sibling(0).shouldHave(exactText(firstName + " " + lastName));
        $x("//td[text()=\"Student Email\"]").sibling(0).shouldHave(exactText(email));
        $x("//td[text()=\"Gender\"]").sibling(0).shouldHave(exactText(gender));
        $x("//td[text()=\"Mobile\"]").sibling(0).shouldHave(exactText(mobileNumber));
        $x("//td[text()=\"Date of Birth\"]").sibling(0).shouldHave(exactText(birthday));
        $x("//td[text()=\"Subjects\"]").sibling(0).shouldHave(exactText(subject));
        $x("//td[text()=\"Hobbies\"]").sibling(0).shouldHave(exactText(hobby));
        $x("//td[text()=\"Picture\"]").sibling(0).shouldHave(exactText(nameFile));
        $x("//td[text()=\"State and City\"]").sibling(0).shouldHave(exactText(state + " " + city));
    }
}
