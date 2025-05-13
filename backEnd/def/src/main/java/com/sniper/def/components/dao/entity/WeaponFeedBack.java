package com.sniper.def.components.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "weapon_feedback")
public class WeaponFeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "weapon_id")
    private Long weaponId;
    @Column(name = "user_comment")
    private String userComment;
   

    public WeaponFeedBack(
        Long id,

        Long weaponId,
        String userComment
    ){
        this.id = id;

        this.weaponId       = weaponId;
        this.userComment    = userComment;
    }
}



