package com.sniper.fileandbatch.components.file.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sniper.fileandbatch.components.file.dao.entity.DaysWithoutShooting;


public interface DaysWithoutShootingRepo extends JpaRepository<DaysWithoutShooting, Long>{
    
}