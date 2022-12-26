package io.demoblaze.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.demoblaze.pages.components.Table;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement table = $("#tbodyid");

    public void openCart() {
        $("#cartur").click();
        $("#page-wrapper .col-lg-8 h2").
                shouldBe(visible).shouldHave(text("Products"));
    }

    public void checkCartTitlePrice(String title, int price) {
        Table cartTable = new Table($("#tbodyid").shouldBe(visible));
        cartTable.rowsElements().shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(30));

        Table.Row firstRow = cartTable.rows().stream().filter(f -> f.td_title().text().equals(title)).findFirst().get();
        firstRow.td_title().shouldHave(text(title));
        firstRow.td_price().shouldHave(text(String.valueOf(price)));
    }

    public void deleteItemFromCartByTitle(String title) {
        Table cartTable = new Table(table);
        List<Table.Row> rowList = cartTable.rows().stream().
                filter(d -> d.td_title().getText().equals(title)).
                collect(Collectors.toList());

        rowList.forEach(c -> c.td_delete().click());

        new Table(table).rowsElements().shouldHave(CollectionCondition.size(0));
    }


}
