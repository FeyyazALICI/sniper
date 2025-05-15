package com.sniper.def.components.bussiness.service.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.bussiness.dtoMapper.WeaponMapper;
import com.sniper.def.components.bussiness.serviceInterface.view.ShootingWithWeaponIdInterface;
import com.sniper.def.components.dao.entity.Weapon;
import com.sniper.def.components.dao.repository.view.ShootingWithWeaponRepo;

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
    public List<WeaponDTO> getAllShootingWithWeapons() throws Exception{
        try{
            WeaponMapper weaponMapper = new WeaponMapper();
            List<Weapon> data = this.weaponRepo.findAll();
            List<WeaponDTO> dataDTO = new ArrayList<>();
            for(Weapon e: data){
                WeaponDTO weaponDTO = new WeaponDTO();
                weaponDTO = weaponMapper.entityToDTOMapper(e);
                dataDTO.add(weaponDTO);
            }
            return dataDTO;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    // GET BY ID
    @Override
    public WeaponDTO getShootingWithWeaponById( Long id ) throws Exception{
        try{
            WeaponMapper weaponMapper = new WeaponMapper();

            Optional<Weapon> data = this.weaponRepo.findById(id);
            if(data.isPresent()){
                WeaponDTO dataDTO = new WeaponDTO();
                dataDTO = weaponMapper.entityToDTOMapper(data.get());
                return dataDTO;
            }else
                return null;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
