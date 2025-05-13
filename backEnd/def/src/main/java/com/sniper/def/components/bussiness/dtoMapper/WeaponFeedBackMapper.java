package com.sniper.def.components.bussiness.dtoMapper;

import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;
import com.sniper.def.components.dao.entity.WeaponFeedBack;

public class WeaponFeedBackMapper {
    

    public WeaponFeedBack DTOtoEntityMapper( WeaponFeedBackDTO weaponFeedBackDTO ){
        
        // attributes
        Long id = null;

        Long weaponId = null;
        String userComment = null;

        // transformation   ----------------------------------------------------------------
        // id
        if( weaponFeedBackDTO.getId()==null || ( weaponFeedBackDTO.getId().trim().equals("") ) ){
            id = null;
        }else{
            id = Long.parseLong(weaponFeedBackDTO.getId());
        }

        // weaponId
        if( weaponFeedBackDTO.getWeaponId()==null || ( weaponFeedBackDTO.getWeaponId().trim().equals("") )){
            weaponId = null;
        }else{
            weaponId = Long.parseLong( weaponFeedBackDTO.getWeaponId() );
        }

        // userComment
        if( weaponFeedBackDTO.getUserComment()==null || ( weaponFeedBackDTO.getUserComment().trim().equals("") )){
            userComment = null;
        }else{
            userComment = weaponFeedBackDTO.getUserComment();
        }


        // Entity creation
        WeaponFeedBack weaponFeedBack = new WeaponFeedBack();
        weaponFeedBack.setId(id);

        weaponFeedBack.setWeaponId(weaponId);
        weaponFeedBack.setUserComment(userComment);
        return weaponFeedBack;
    }

    public WeaponFeedBackDTO entityToDTOMapper( WeaponFeedBack weaponFeedBack ){
        
        // attributes
        String id = null;

        String weaponId = null;
        String userComment = null;

        // transformation   ----------------------------------------------------------------
        // id
        if(   weaponFeedBack.getId()==null   ){
            id = null;
        }else{
            id = weaponFeedBack.getId().toString();
        }

        // weaponId
        if(   weaponFeedBack.getWeaponId()==null   ){
            weaponId = null;
        }else{
            weaponId = weaponFeedBack.getWeaponId().toString();
        }

        // userComment
        if( weaponFeedBack.getUserComment()==null || ( weaponFeedBack.getUserComment().trim().equals("") )){
            userComment = null;
        }else{
            userComment = weaponFeedBack.getUserComment();
        }


        // Entity creation
        WeaponFeedBackDTO weaponFeedBackDTO = new WeaponFeedBackDTO();
        weaponFeedBackDTO.setId(id);

        weaponFeedBackDTO.setWeaponId(weaponId);
        weaponFeedBackDTO.setUserComment(userComment);
        return weaponFeedBackDTO;
    }
    
}

