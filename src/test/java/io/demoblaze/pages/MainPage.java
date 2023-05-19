package io.demoblaze.pages;


import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;


public class MainPage {

    public static SelenideElement makeAppointment = $("#btn-make-appointment");

    public static  SelenideElement menuButton = $("#menu-toggle");

    public static SelenideElement sideBarMenu = $("#sidebar-wrapper");

    public static SelenideElement userName = $("#txt-username");

    public static SelenideElement passWord = $("#txt-password");

    public static SelenideElement loginButton = $("#btn-login");

    public static SelenideElement errorMessage = $("p.lead.text-danger");

    public static SelenideElement makeAppointmentHeader = $("div.col-sm-12.text-center");

    public static  SelenideElement facility = $("#combo_facility");

    public static SelenideElement medicAid = $("#radio_program_medicaid");

    public static SelenideElement selectDate = $("#txt_visit_date");

    public static SelenideElement bookAppointmentBtn = $("#btn-book-appointment");

    public static SelenideElement appointmentConfirmation = $("#summary");

    public static SelenideElement profileButton = $("[href=\"profile.php#profile\"]");

    public static SelenideElement profileHeader = $(".lead");

    public static SelenideElement historyButton = $("[href=\"history.php#history\"]");

    public static SelenideElement historySection = $("#history");

    public static SelenideElement historyBody = $(".panel-body");

    public static SelenideElement facilityField = $("#facility");

    public static SelenideElement hospitalReadmissionField = $("#hospital_readmission");

    public static SelenideElement programField = $("#program");

    public static SelenideElement commentField = $("#comment");

    public static SelenideElement dateField = $(".panel-heading");

    public void makeAppointmentButtonIsAvailable () {
        makeAppointment.isEnabled();
    }

    public void clickMakeAppointment (){
        makeAppointment.click();
    }

    public void loginIntoSystem(String login, String password) {
        userName.sendKeys(login);
        passWord.sendKeys(password);
        loginButton.click();
    }

    public void getAndCheckErrorMessage(String alertMessage) {
        errorMessage.isDisplayed();
        errorMessage.getText().equals(alertMessage);
    }


    public void assertYoureMakingAnAppointment() {
        makeAppointmentHeader.isDisplayed();
    }
    public void selectFacilty(String facilityName) {
        facility.selectOption(facilityName);
    }

    public void clickMedicAid(){
        medicAid.click();
    }

    public void setDateInFuture () {
        LocalDate localDate = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        selectDate.sendKeys(formattedString);
    }

    public void bookAnAppointment() {
        bookAppointmentBtn.click();
    }

    public void checkIfAppointmentCreated() {
        appointmentConfirmation.isDisplayed();
    }

    public void openMenu() {
        menuButton.click();
    }

    public void openProfile() {
        profileButton.click();
    }

    public void assertProfileUnderConstruction() {
        profileHeader.getText().equals("Under construction.");
    }

    public void openHistory() {
        historyButton.click();
    }

    public void assertHistoryIsOpened() {
        historySection.isDisplayed();
    }

    public void checkAppointmentData(String facility, String readmission, String program, String comment) {
        facilityField.getText().equals(facility);
        hospitalReadmissionField.getText().equals(readmission);
        programField.getText().equals(program);
        commentField.getText().equals(comment);
//        dateField.getValue().equals(date);

    }
}
