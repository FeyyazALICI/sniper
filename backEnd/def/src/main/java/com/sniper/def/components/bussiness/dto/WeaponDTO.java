package com.sniper.def.components.bussiness.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeaponDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("bore_size")
    private String boreSize;
    @JsonProperty("bore_unit")
    private String boreUnit;
    @JsonProperty("type")
    private String type;

    @JsonProperty("photo_qr")
    private String photoQr;

    public WeaponDTO(
        String id,

        String brand,
        String serialNumber,
        String boreSize,
        String boreUnit,
        String type,

        String photoQr
    ){
        this.id = id;

        this.brand = brand;
        this.serialNumber = serialNumber;
        this.boreSize = boreSize;
        this.boreUnit = boreUnit;
        this.type = type;

        this.photoQr = photoQr;
    }
}




