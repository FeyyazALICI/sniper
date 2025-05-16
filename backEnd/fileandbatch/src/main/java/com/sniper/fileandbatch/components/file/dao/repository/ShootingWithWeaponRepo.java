package com.sniper.fileandbatch.components.file.dao.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sniper.fileandbatch.components.file.dao.entity.ShootingWithWeapon;


public interface ShootingWithWeaponRepo extends JpaRepository<ShootingWithWeapon, Long>{
    
    @Query(value = "SELECT date_of_shooting FROM shooting_with_weapon ORDER BY date_of_shooting ASC LIMIT 1", nativeQuery = true)
    Date findFirstShootNative();
}