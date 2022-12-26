package io.demoblaze.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public static SelenideElement logo = $("#nava");
    public static ElementsCollection cardsList = $$(".card");
    public static ElementsCollection cardListTitles = $$(".card-title .hrefch");
    public static By CARD_TITLE = By.cssSelector(".card-title .hrefch");
    public static SelenideElement cardPrice = $(".card-block h5");
    public static SelenideElement cardText = $("#article");

    public void clickOnTheNameOfProduct(String title) {
        cardListTitles.find(text(title)).click();
    }

    public void checkLogo() {
        logo.shouldBe(visible);
    }

}
