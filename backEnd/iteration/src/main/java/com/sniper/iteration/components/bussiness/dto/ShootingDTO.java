package com.sniper.iteration.components.bussiness.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
public class ShootingDTO {
    
    @JsonProperty("id")  
    private String id;

    @JsonProperty("distance")
    private String distance;
    @JsonProperty("distance_category")
    private String distanceCategory;
    @JsonProperty("weapon_id")
    private String weaponId;
    @JsonProperty("shot_fired")
    private String shotFired;
    @JsonProperty("hit")
    private String hit;

    @JsonProperty("date_of_shooting")
    private String dateOfShooting;


    public ShootingDTO(
        String id,

        String distance,
        String distanceCategory,
        String weaponId,
        String shotFired,
        String hit,

        String dateOfShooting
    ){
        this.id                     = id;

        this.distance               = distance;
        this.distanceCategory       = distanceCategory;
        this.weaponId               = weaponId;
        this.shotFired              = shotFired;
        this.hit                    = hit;

        this.dateOfShooting         = dateOfShooting;
    }
}


