package com.sniper.def.components.bussiness.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.dao.repository.WeaponFeedBackRepo;
import com.sniper.def.components.dao.repository.WeaponRepo;

@Service
public class DefService {
    
    private final WeaponRepo weaponRepo;
    private final WeaponFeedBackRepo weaponFeedBackRepo;

    public DefService(
        WeaponRepo weaponRepo,
        WeaponFeedBackRepo weaponFeedBackRepo
    ){
        this.weaponRepo     = weaponRepo;
        this.weaponFeedBackRepo   = weaponFeedBackRepo;
    }


    @Override
    public List<WeaponDTO> getAllWeapons(){
        try{
            CatMapper catMapper = new CatMapper();
            List<Cat> data = this.catRepoJpa.findAll();
            List<CatDTO> dataDTO = new ArrayList<>();
            for(Cat cat: data){
                CatDTO catDTO = new CatDTO();
                catDTO = catMapper.catToCatDTOMapper(cat);
                dataDTO.add(catDTO);
            }
            return dataDTO;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
