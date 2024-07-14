package com.example.filter.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleRequest {
    private String param1;
    private Integer param2;
    private Boolean param3;
}
