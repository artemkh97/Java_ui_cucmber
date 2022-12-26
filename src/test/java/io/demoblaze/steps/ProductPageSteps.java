package io.demoblaze.steps;

import io.cucumber.java.en.When;
import io.demoblaze.pages.ProductPage;
import io.demoblaze.rest.dto.Union;

public class ProductPageSteps {

    private final ProductPage productPage;
    private final Union union;

    public ProductPageSteps(ProductPage productPage, Union union) {
        this.productPage = productPage;
        this.union = union;
    }

    @When("the user checks product title, price and description")
    public void user_checks_title_price_desc() {
        user_checks_title(union.getItem().getTitle());
        user_checks_price(union.getItem().getPrice());
        user_checks_desc(union.getItem().getDesc());
    }

    @When("the user checks product title {}")
    public void user_checks_title(String productTitle) {
        productPage.checkProductTitle(productTitle);
    }

    @When("the user checks product price {}")
    public void user_checks_price(int productPrice) {
        productPage.checkProductPrice(productPrice);
    }

    @When("the user checks product description {}")
    public void user_checks_desc(String dec) {
        productPage.checkProductDescription(dec);
    }

    @When("the user added product to cart")
    public void user_added_to_cart() {
        productPage.addProductToCart();
    }
}
