package com.sniper.def.components.dao.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sniper.def.components.dao.entity.view.ShootingWithWeapon;

public interface ShootingWithWeaponRepo extends JpaRepository<ShootingWithWeapon, Long>{
    
}
