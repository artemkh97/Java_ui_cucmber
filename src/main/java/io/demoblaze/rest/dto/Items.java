package io.demoblaze.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private String img;
    private int price;
    private String cat;
    private int id;
    private String title;
    private String desc;
}
