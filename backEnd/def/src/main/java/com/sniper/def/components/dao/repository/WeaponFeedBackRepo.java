package com.sniper.def.components.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sniper.def.components.dao.entity.WeaponFeedBack;

public interface WeaponFeedBackRepo extends JpaRepository<WeaponFeedBack, Long> {
    
}
