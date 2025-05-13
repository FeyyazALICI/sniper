package com.sniper.def.components.bussiness.dtoMapper;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.dao.entity.Weapon;

public class WeaponMapper {
    

    public Weapon entityToDTOMapper( WeaponDTO weaponDTO ){
        
        Long id = null;
        if( weaponDTO.getId()==null || ( weaponDTO.getId().trim().equals("") ) ){
            id = null;
        }else{
            id = Long.parseLong(weaponDTO.getId());
        }

        String name = null;
        if( catDTO.getName()==null || ( catDTO.getName().trim().equals("") )){
            name = null;
        }else{
            name = catDTO.getName();
        }

        BigDecimal weight = null;
        if( catDTO.getWeight()==null || ( catDTO.getWeight().trim().equals("") )){
            weight = null;
        }else{
            weight = new BigDecimal(catDTO.getWeight()) ;
        }

        Cat cat = new Cat();
        cat.setId(id);
        cat.setName(name);
        cat.setWeight(weight);

        return cat;
    }

    public CatDTO catToCatDTOMapper( Cat cat ){
        
        String id = cat.getId().toString();
        String name = cat.getName();
        String weight = cat.getWeight().toString();

        CatDTO catDTO = new CatDTO();
        catDTO.setId(id);
        catDTO.setName(name);
        catDTO.setWeight(weight);

        return catDTO;
    }
    
}