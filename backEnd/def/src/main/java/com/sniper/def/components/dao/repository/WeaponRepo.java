package com.sniper.def.components.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sniper.def.components.dao.entity.Weapon;


public interface WeaponRepo extends JpaRepository<Weapon, Long> {

}
