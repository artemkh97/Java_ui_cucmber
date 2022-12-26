package io.demoblaze.rest;

import io.demoblaze.rest.dto.GetAllItemsResponse;
import io.demoblaze.rest.serviceendpoints.ProjectEndpoints;
import io.demoblaze.utils.config.Config;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class DemoblazeApi {

    String url = Config.getServiceConfig().projectApiUrl();

    public GetAllItemsResponse getGetAllProducts() {

        return given().log().all().when().
                get(url + ProjectEndpoints.GET_ENTRIES).
                then().log().all().statusCode(HttpStatus.SC_OK).
                extract().response().as(GetAllItemsResponse.class);
    }

}
