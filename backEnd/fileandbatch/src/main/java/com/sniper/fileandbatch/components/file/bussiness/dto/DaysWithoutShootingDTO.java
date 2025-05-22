package com.sniper.fileandbatch.components.file.bussiness.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
public class DaysWithoutShootingDTO {
    
    @JsonProperty("id")  
    private String id;

    @JsonProperty("date_of_rest")
    private String dateOfRest;


    public DaysWithoutShootingDTO(
        String id,

        String dateOfRest
    ){
        this.id = id;

        this.dateOfRest           = dateOfRest;
    }
}