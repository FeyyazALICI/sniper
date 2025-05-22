package com.sniper.fileandbatch.components.file.bussiness.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sniper.fileandbatch.components.file.bussiness.dto.ShootingWithWeaponDTO;
import com.sniper.fileandbatch.components.file.bussiness.dto.SuccessRateDTO;
import com.sniper.fileandbatch.components.file.bussiness.dtoMapper.ShootingWithWeaponMapper;
import com.sniper.fileandbatch.components.file.bussiness.dtoMapper.SuccessRateMapper;
import com.sniper.fileandbatch.components.file.bussiness.serviceInterface.ShootingWithWeaponIdInterface;
import com.sniper.fileandbatch.components.file.dao.entity.ShootingWithWeapon;
import com.sniper.fileandbatch.components.file.dao.repository.ShootingWithWeaponRepo;


@Service
public class ViewService implements ShootingWithWeaponIdInterface{
    
    private final ShootingWithWeaponRepo shootingWithWeaponRepo;

    public ViewService(
        ShootingWithWeaponRepo shootingWithWeaponRepo
    ){
        this.shootingWithWeaponRepo = shootingWithWeaponRepo;
    }


    // GET ALL
    @Override
    public List<ShootingWithWeaponDTO> getAllShootingWithWeapons() throws Exception{
        try{
            ShootingWithWeaponMapper shootingWithWeaponMapper = new ShootingWithWeaponMapper();
            List<ShootingWithWeapon> data = this.shootingWithWeaponRepo.findAll();
            List<ShootingWithWeaponDTO> dataDTOList = new ArrayList<>();
            for(ShootingWithWeapon e: data){
                ShootingWithWeaponDTO dataDTO = new ShootingWithWeaponDTO();
                dataDTO = shootingWithWeaponMapper.entityToDTOMapper(e);
                dataDTOList.add(dataDTO);
            }
            return dataDTOList;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    // GET ALL with success_rate
    public List<SuccessRateDTO> getAllShootingWithWeaponsWithSuccessRate() throws Exception{
        try{
            SuccessRateMapper successRateMapper = new SuccessRateMapper();
            List<ShootingWithWeapon> data = this.shootingWithWeaponRepo.findAll();
            List<SuccessRateDTO> dataDTOList = new ArrayList<>();
            for(ShootingWithWeapon e: data){
                SuccessRateDTO dataDTO = new SuccessRateDTO();
                dataDTO = successRateMapper.entityToDTOMapper(e);
                dataDTOList.add(dataDTO);
            }
            return dataDTOList;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    // GET ALL with raw entity to be used by batch operations
    public List<ShootingWithWeapon> getAllShootingWithWeaponsRaw() throws Exception{
        try{
            List<ShootingWithWeapon> data = this.shootingWithWeaponRepo.findAll();
            return data;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    // getting the earliest date of shooting to be used in batch ops
    public Date getEarlistDateOfShooting(){
        return this.shootingWithWeaponRepo.findFirstShootNative();
    }

    // GET BY ID
    @Override
    public ShootingWithWeaponDTO getShootingWithWeaponById( Long id ) throws Exception{
        try{
            ShootingWithWeaponMapper shootingWithWeaponMapper = new ShootingWithWeaponMapper();

            Optional<ShootingWithWeapon> data = this.shootingWithWeaponRepo.findById(id);
            if(data.isPresent()){
                ShootingWithWeaponDTO dataDTO = new ShootingWithWeaponDTO();
                dataDTO = shootingWithWeaponMapper.entityToDTOMapper(data.get());
                return dataDTO;
            }else
                return null;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}