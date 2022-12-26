package io.demoblaze.rest.helpers;

import io.demoblaze.rest.DemoblazeApi;
import io.demoblaze.rest.dto.GetAllItemsResponse;
import io.demoblaze.rest.dto.Items;

public class GetRandomData {

    public Items getFirstProduct() {
        GetAllItemsResponse allItemsResponse = new DemoblazeApi().getGetAllProducts();
        return allItemsResponse.getItems().get(0);
    }
}
