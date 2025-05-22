package com.sniper.iteration.components.bussiness.dtoMapper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sniper.iteration.components.bussiness.dto.ShootingDTO;
import com.sniper.iteration.components.dao.entity.Shooting;

public class ShootingMapper {
    

    public Shooting DTOtoEntityMapper( ShootingDTO dataDTO ){
        
        // attributes
        Long id;

        BigDecimal distance;
        String distanceCategory;
        Long weaponId;
        BigDecimal shotFired;
        BigDecimal hit;

        Date dateOfShooting;

        // transformation   ----------------------------------------------------------------
        // id
        if( dataDTO.getId()==null || ( dataDTO.getId().trim().equals("") ) ){
            id = null;
        }else{
            id = Long.parseLong(dataDTO.getId());
        }

        // distance
        if( dataDTO.getDistance()==null || ( dataDTO.getDistance().trim().equals("") )){
            distance = null;
        }else{
            distance = new BigDecimal(dataDTO.getDistance());
        }

        // distanceCategory
        if( dataDTO.getDistanceCategory()==null || ( dataDTO.getDistanceCategory().trim().equals("") )){
            distanceCategory = null;
        }else{
            distanceCategory = dataDTO.getDistanceCategory();
        }

        // weaponId
        if( dataDTO.getWeaponId()==null || ( dataDTO.getWeaponId().trim().equals("") )){
            weaponId = null;
        }else{
            weaponId = Long.parseLong(dataDTO.getWeaponId());
        }

        // shotFired
        if( dataDTO.getShotFired()==null || ( dataDTO.getShotFired().trim().equals("") )){
            shotFired = null;
        }else{
            shotFired = new BigDecimal(dataDTO.getShotFired());
        }

        // hit
        if( dataDTO.getHit()==null || ( dataDTO.getHit().trim().equals("") )){
            hit = null;
        }else{
            hit = new BigDecimal(dataDTO.getHit());
        }

        // dateOfShooting
        if( dataDTO.getDateOfShooting() == null || dataDTO.getDateOfShooting().trim().equals("") ){
            dateOfShooting = null;
        } else {
            try {
                // Adjust the format to match the expected date string (e.g. "2025-05-22")
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                dateOfShooting = sdf.parse(dataDTO.getDateOfShooting());
            } catch (ParseException e) {
                // Handle parsing error
                throw new RuntimeException("Invalid date format: " + dataDTO.getDateOfShooting(), e);
            }
        }

        // Entity creation
        Shooting dataEntity = new Shooting();
        dataEntity.setId(id);

        dataEntity.setDistance(distance);
        dataEntity.setDistanceCategory(distanceCategory);
        dataEntity.setWeaponId(weaponId);
        dataEntity.setShotFired(shotFired);
        dataEntity.setHit(hit);

        dataEntity.setDateOfShooting(dateOfShooting);
        return dataEntity;
    }

    public ShootingDTO entityToDTOMapper( Shooting dataEntity ){
        
        // attributes
        String id = null;

        String distance = null;
        String distanceCategory = null;
        String weaponId = null;
        String shotFired = null;
        String hit = null;

        String dateOfShooting = null;

        // transformation   ----------------------------------------------------------------
        // id
        if(   dataEntity.getId()==null   ){
            id = null;
        }else{
            id = dataEntity.getId().toString();
        }

        // distance
        if(   dataEntity.getDistance()==null   ){
            distance = null;
        }else{
            distance = dataEntity.getDistance().toString();
        }
        
        // distanceCategory
        if(   dataEntity.getDistanceCategory()==null || dataEntity.getDistanceCategory().trim().equals("")   ){
            distanceCategory = null;
        }else{
            distanceCategory = dataEntity.getDistanceCategory();
        }

        // weaponId
        if(   dataEntity.getWeaponId()==null   ){
            weaponId = null;
        }else{
            weaponId = dataEntity.getWeaponId().toString();
        }

        // shotFired
        if(   dataEntity.getShotFired()==null    ){
            shotFired = null;
        }else{
            shotFired = dataEntity.getShotFired().toString();
        }

        // hit
        if(   dataEntity.getHit()==null  ){
            hit = null;
        }else{
            hit = dataEntity.getHit().toString();
        }

        // dateOfShooting
        if(   dataEntity.getDateOfShooting()==null    ){
            dateOfShooting = null;
        }else{
            dateOfShooting = dataEntity.getDateOfShooting().toString();
        }

        // Entity creation
        ShootingDTO dataDTO = new ShootingDTO();
        dataDTO.setId(id);

        dataDTO.setDistance(distance);
        dataDTO.setDistanceCategory(distanceCategory);
        dataDTO.setWeaponId(weaponId);
        dataDTO.setShotFired(shotFired);
        dataDTO.setHit(hit);

        dataDTO.setDateOfShooting(dateOfShooting);
        return dataDTO;
    }
    
}


