package com.sniper.def.components.dao.entity.view;

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

import org.hibernate.annotations.Immutable;

@Entity
@Data
@NoArgsConstructor
@Immutable // Prevent updates -> because the view is read only
@Table(name = "shooting_with_weapon") // Make sure to point to the correct view name
public class ShootingWithWeapon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shooting_id")  
    private Long id;

    @Column(name = "distance")  
    private BigDecimal distance;

    @Column(name = "distance_category")  
    private String distanceCategory;

    @Column(name = "shot_fired")  
    private BigDecimal shotFired;

    @Column(name = "hit")  
    private BigDecimal hit;

    @Column(name = "date_of_shooting")  
    private Date dateOfShooting;

    @Column(name = "weapon_id")  
    private Long weaponId;

    @Column(name = "weapon_brand")  
    private String weaponBrand;

    @Column(name = "weapon_serial_number")  
    private String weaponSerialNumber;

    @Column(name = "weapon_bore_size")  
    private BigDecimal weaponBoreSize;

    @Column(name = "weapon_bore_unit")  
    private String weaponBoreUnit;

    @Column(name = "weapon_type")  
    private String weaponType;

    @Column(name = "weapon_photo_qr")  
    private String weaponPhotoQr;


    public ShootingWithWeapon(
        Long id,

        BigDecimal distance,
        String distanceCategory, 
        BigDecimal shotFired,
        BigDecimal hit,
        Date dateOfShooting,

        Long weaponId,
        String weaponBrand,
        String weaponSerialNumber,
        BigDecimal weaponBoreSize,
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
