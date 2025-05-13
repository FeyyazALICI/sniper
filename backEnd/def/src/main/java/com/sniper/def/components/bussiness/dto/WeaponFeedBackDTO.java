package com.sniper.def.components.bussiness.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeaponFeedBackDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("weapon_id")
    private String weaponId;
    @JsonProperty("user_comment")
    private String userComment;
   

    public WeaponFeedBackDTO(
        String id,

        String weaponId,
        String userComment
    ){
        this.id = id;

        this.weaponId       = weaponId;
        this.userComment    = userComment;
    }
}



