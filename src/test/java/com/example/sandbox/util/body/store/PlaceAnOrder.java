package com.example.sandbox.util.body.store;

import com.example.sandbox.util.swagger.definitions.Store;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceAnOrder extends JsonBody{

    @JsonProperty
    private Store Store;
}
