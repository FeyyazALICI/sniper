package com.sniper.fileandbatch.components.file.bussiness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sniper.fileandbatch.components.file.dao.entity.DaysWithoutShooting;
import com.sniper.fileandbatch.components.file.dao.repository.DaysWithoutShootingRepo;

import jakarta.transaction.Transactional;

@Service
public class DaysWithoutShootingService {
    
    private final DaysWithoutShootingRepo daysWithoutShootingRepo;

    public DaysWithoutShootingService(
        DaysWithoutShootingRepo daysWithoutShootingRepo
    ){
        this.daysWithoutShootingRepo    = daysWithoutShootingRepo;
    }

    
    // GET AL
    public List<DaysWithoutShooting> getAllDaysWithoutShooting() throws Exception{
        try{
            List<DaysWithoutShooting> data = this.daysWithoutShootingRepo.findAll();
            return data;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public void insertDaysWithoutShooting(DaysWithoutShooting data){
        try{
            this.daysWithoutShootingRepo.saveAndFlush(data);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
