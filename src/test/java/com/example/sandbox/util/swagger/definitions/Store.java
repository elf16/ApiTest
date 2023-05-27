package com.example.sandbox.util.swagger.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store {

    @JsonProperty
    private int id;

    @JsonProperty
    private int petId;

    @JsonProperty
    private int quantity;

    @JsonProperty
    private String shipDate;

    @JsonProperty
    private Status status;

    @JsonProperty
    private boolean complete;
}
