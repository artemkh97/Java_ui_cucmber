package io.demoblaze.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.demoblaze.pages.MainPage;
import io.demoblaze.rest.dto.Items;
import io.demoblaze.rest.dto.Union;
import io.demoblaze.rest.helpers.GetRandomData;
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

    @Given("^the user is on the main page$")
    public void user_is_on_main_page() throws Throwable {
        open(url);
        mainPage.checkLogo();
    }

    @When("the user opens detailed card for a product {}")
    public void user_opens_detailed_card(String title) throws Throwable {
        mainPage.clickOnTheNameOfProduct(title);
    }

    @When("the user opens detailed card for a random product")
    public void user_opens_random_detailed_card() throws Throwable {
        Items item = new GetRandomData().getFirstProduct();
        union.setItem(item);
        mainPage.clickOnTheNameOfProduct(item.getTitle());
    }

}
