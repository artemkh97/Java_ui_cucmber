package io.demoblaze.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.demoblaze.pages.MainPage;
import io.demoblaze.rest.dto.Union;
import io.demoblaze.utils.config.Config;

import static com.codeborne.selenide.Selenide.open;

public class MainPageSteps {

    private final MainPage mainPage;
    private final Union union;

    public MainPageSteps(MainPage mainPage, Union union) {
        this.mainPage = mainPage;
        this.union = union;
    }

    private final String url = Config.getServiceConfig().projectUrl();

    @Given("the user is on the main page")
    public void user_is_on_main_page() {
        open(url);
        mainPage.makeAppointmentButtonIsAvailable();
    }

    @When("the user clicks on 'make an appointment'")
    public void user_clicks_on_make_an_appointment() {
        mainPage.clickMakeAppointment();
    }

    @When("the user enters username and password and tries to log in the system")
    public void user_enters_username_and_password(String username, String password) {
        mainPage.loginIntoSystem(username, password);
    }

    @When("the user sees an error message")
    public void user_gets_an_alert_message(String errorMessage) {
        mainPage.getAndCheckErrorMessage(errorMessage);
    }

    @Given("the user is successfully logged in")
    public  void user_is_logged_in() {
        mainPage.assertYoureMakingAnAppointment();
    }

    @When("the user chooses a facility")
    public void user_chooses_a_facility(String facility) {
        mainPage.selectFacilty(facility);
    }

    @When("the user selects Medicaid")
    public void user_clicks_medicaid() {
        mainPage.clickMedicAid();
    }

    @When("the user picks a date")
    public void user_picks_a_date() {
        mainPage.setDateInFuture();
    }

    @When("the user books an appointment")
    public void user_books_an_appointment() {
        mainPage.bookAnAppointment();
    }

    @When("the user gets summary of his appointment")
    public void user_gets_summary() {
        mainPage.checkIfAppointmentCreated();
    }

    @When("the user opens menu")
    public void user_open_menu() {
        mainPage.openMenu();
    }

    @When("the user opens profile and gets message")
    public void user_opens_profile() {
        mainPage.openProfile();
        mainPage.assertProfileUnderConstruction();
    }

    @When("the user opens history")
    public void user_opens_history() {
        mainPage.openHistory();
        mainPage.assertHistoryIsOpened();
    }

    @When("the user checks the contents of an appointment card")
    public void user_checks_appointment_data(String facility, String readmission, String program, String comment) {
        mainPage.checkAppointmentData(facility, readmission, program, comment);
    }

}
