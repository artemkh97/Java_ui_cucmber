package io.demoblaze.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.demoblaze.pages.CartPage;
import io.demoblaze.rest.dto.Union;

public class CartPageSteps {

    private final CartPage cartPage;
    private final Union union;

    public CartPageSteps(CartPage cartPage, Union union) {
        this.cartPage = cartPage;
        this.union = union;
    }


    @When("the user opens the cart")
    public void user_opens_cart() {
        cartPage.openCart();
    }

    @When("the user checks that cart have a product with title {} and price {}")
    public void user_checks_title_price_in_cart(String title, int price) {
        cartPage.checkCartTitlePrice(title, price);
    }

    @Then("the user removes a product from cart")
    public void user_removes_from_cart() {
        user_removes_from_cart_by_title(union.getItem().getTitle());
    }

    @Then("the user removes a product with title {} from cart")
    public void user_removes_from_cart_by_title(String title) {
        cartPage.deleteItemFromCartByTitle(title);
    }


}
