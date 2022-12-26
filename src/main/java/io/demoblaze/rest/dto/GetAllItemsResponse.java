package io.demoblaze.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemsResponse {
    @JsonProperty("Items")
    private List<Items> items;
    @JsonProperty("LastEvaluatedKey")

    private LastEvaluatedKey lastEvaluatedKey;

}