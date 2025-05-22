package com.sniper.def.components.bussiness.dtoMapper;

import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;
import com.sniper.def.components.dao.entity.WeaponFeedBack;

public class WeaponFeedBackMapper {
    

    public WeaponFeedBack DTOtoEntityMapper( WeaponFeedBackDTO dataDTO ){
        
        // attributes
        Long id = null;

        Long weaponId = null;
        String userComment = null;

        // transformation   ----------------------------------------------------------------
        // id
        if( dataDTO.getId()==null || ( dataDTO.getId().trim().equals("") ) ){
            id = null;
        }else{
            id = Long.parseLong(dataDTO.getId());
        }

        // weaponId
        if( dataDTO.getWeaponId()==null || ( dataDTO.getWeaponId().trim().equals("") )){
            weaponId = null;
        }else{
            weaponId = Long.parseLong( dataDTO.getWeaponId() );
        }

        // userComment
        if( dataDTO.getUserComment()==null || ( dataDTO.getUserComment().trim().equals("") )){
            userComment = null;
        }else{
            userComment = dataDTO.getUserComment();
        }


        // Entity creation
        WeaponFeedBack dataEntity = new WeaponFeedBack();
        dataEntity.setId(id);

        dataEntity.setWeaponId(weaponId);
        dataEntity.setUserComment(userComment);
        return dataEntity;
    }

    public WeaponFeedBackDTO entityToDTOMapper( WeaponFeedBack dataEntity ){
        
        // attributes
        String id = null;

        String weaponId = null;
        String userComment = null;

        // transformation   ----------------------------------------------------------------
        // id
        if(   dataEntity.getId()==null   ){
            id = null;
        }else{
            id = dataEntity.getId().toString();
        }

        // weaponId
        if(   dataEntity.getWeaponId()==null   ){
            weaponId = null;
        }else{
            weaponId = dataEntity.getWeaponId().toString();
        }

        // userComment
        if( dataEntity.getUserComment()==null || ( dataEntity.getUserComment().trim().equals("") )){
            userComment = null;
        }else{
            userComment = dataEntity.getUserComment();
        }


        // Entity creation
        WeaponFeedBackDTO dataDTO = new WeaponFeedBackDTO();
        dataDTO.setId(id);

        dataDTO.setWeaponId(weaponId);
        dataDTO.setUserComment(userComment);
        return dataDTO;
    }
    
}

