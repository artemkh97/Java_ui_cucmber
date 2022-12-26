package io.demoblaze.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;
import io.demoblaze.rest.dto.Union;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public static SelenideElement title = $("#tbodyid .name");

    public static SelenideElement price = $("#tbodyid .price-container");

    public static SelenideElement description = $("#more-information");

    private final Union union;

    public ProductPage(Union union) {
        this.union = union;
    }

    @When("check product title, price and description")
    public void checkProductData() {
        checkProductTitle(union.getItem().getTitle());
        checkProductPrice(union.getItem().getPrice());
        checkProductDescription(union.getItem().getDesc());
    }

    @When("check product title {}")
    public void checkProductTitle(String productTitle) {
        title.shouldHave(text(productTitle));
    }

    @When("check product price {}")
    public void checkProductPrice(int productPrice) {
        price.shouldHave(text("$" + productPrice));
    }

    @When("check product description {}")
    public void checkProductDescription(String dec) {
        description.find("strong").shouldHave(text("Product description"));
        description.find("p").shouldHave(text(dec));
    }

    @When("add product to cart")
    public void addProductToCart() {
        $(".btn-success").click();
        Selenide.actions().sendKeys(Keys.ENTER);
    }
}
