package com.sniper.def.components.bussiness.dto.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
public class ShootingWithWeaponDTO {
    
    @JsonProperty("id")
    private String id;

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("distance_category")  
    private String distanceCategory;

    @JsonProperty("shot_fired")  
    private String shotFired;

    @JsonProperty("hit")  
    private String hit;

    @JsonProperty("date_of_shooting")  
    private String dateOfShooting;

    @JsonProperty("weapon_id")  
    private String weaponId;

    @JsonProperty("weapon_brand")  
    private String weaponBrand;

    @JsonProperty("weapon_serial_number")  
    private String weaponSerialNumber;

    @JsonProperty("weapon_bore_size")  
    private String weaponBoreSize;

    @JsonProperty("weapon_bore_unit")  
    private String weaponBoreUnit;

    @JsonProperty("weapon_type")  
    private String weaponType;

    @JsonProperty("weapon_photo_qr")  
    private String weaponPhotoQr;


    public ShootingWithWeaponDTO(
        String id,

        String distance,
        String distanceCategory, 
        String shotFired,
        String hit,
        String dateOfShooting,

        String weaponId,
        String weaponBrand,
        String weaponSerialNumber,
        String weaponBoreSize,
        String weaponBoreUnit,

        String weaponType,
        String weaponPhotoQr
    ){
        this.id = id;

        this.distance           = distance;
        this.distanceCategory   = distanceCategory;
        this.shotFired          = shotFired;
        this.hit                = hit;
        this.dateOfShooting     = dateOfShooting;

        this.weaponId           = weaponId;
        this.weaponBrand        = weaponBrand;
        this.weaponSerialNumber = weaponSerialNumber;
        this.weaponBoreSize     = weaponBoreSize;
        this.weaponBoreUnit     = weaponBoreUnit;

        this.weaponType         = weaponType;
        this.weaponPhotoQr      = weaponPhotoQr;
    }
}
