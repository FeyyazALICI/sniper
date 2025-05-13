package com.sniper.def.components.bussiness.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WeaponFeedBackDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("weapon_id")
    private Long weaponId;
    @JsonProperty("user_comment")
    private String userComment;
   

    public WeaponFeedBackDTO(
        Long id,

        Long weaponId,
        String userComment
    ){
        this.id = id;

        this.weaponId       = weaponId;
        this.userComment    = userComment;
    }
}



