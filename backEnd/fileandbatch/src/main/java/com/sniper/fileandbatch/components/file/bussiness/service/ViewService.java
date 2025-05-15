package com.sniper.fileandbatch.components.file.bussiness.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sniper.fileandbatch.components.file.bussiness.dto.ShootingWithWeaponDTO;
import com.sniper.fileandbatch.components.file.bussiness.dtoMapper.ShootingWithWeaponMapper;
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