package com.example.sandbox.util.body.store;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class JsonBody {

    public static String createJsonBody(PlaceAnOrder body){
        try{
            return new ObjectMapper().writeValueAsString(body.getStore());

        } catch (Throwable e){
            throw new RuntimeException("Nody Generation Failure");
        }
    }

}
