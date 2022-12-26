package io.demoblaze.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private final SelenideElement table;

    public ElementsCollection rowsElements() {
        return table.$$("tbody tr");
    }

    public Table(SelenideElement table) {
        this.table = table;
    }

    public List<Row> rows() {
        return table.$$("tbody tr").stream().map(Row::new).collect(Collectors.toList());
    }

    public static class Row {
        private SelenideElement row;

        public Row(SelenideElement row) {
            this.row = row;
        }

        public SelenideElement td_title() {
            return row.$$("td").get(1);
        }

        public SelenideElement td_price() {
            return row.$$("td").get(2);
        }

        public SelenideElement td_delete() {
            return row.$$("td").get(3).$("a");
        }

    }
}
