package com.sniper.iteration.components.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sniper.iteration.components.dao.entity.Shooting;

public interface ShootingRepo extends JpaRepository<Shooting, Long>{
    
}
