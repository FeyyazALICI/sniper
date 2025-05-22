package com.sniper.iteration.components.dao.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "shooting") // Make sure to point to the correct view name
public class Shooting {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  
    private Long id;

    @Column(name = "distance")
    private BigDecimal distance;
    @Column(name = "distance_category")
    private String distanceCategory;
    @Column(name = "weapon_id")
    private Long weaponId;
    @Column(name = "shot_fired")
    private BigDecimal shotFired;
    @Column(name = "hit")
    private BigDecimal hit;

    @Column(name = "date_of_shooting")
    private Date dateOfShooting;


    public Shooting(
        Long id,

        BigDecimal distance,
        String distanceCategory,
        Long weaponId,
        BigDecimal shotFired,
        BigDecimal hit,

        Date dateOfShooting
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


