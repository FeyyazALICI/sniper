package com.sniper.def.components.bussiness.dtoMapper;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.dao.entity.Weapon;

public class WeaponMapper {
    

    public Weapon DTOtoEntityMapper( WeaponDTO dataDTO ){
        
        // attributes
        Long id = null;

        String brand = null;
        String serialNumber = null;
        String boreSize = null;
        String boreUnit = null;
        String type = null;

        String photoQr = null;

        // transformation   ----------------------------------------------------------------
        // id
        if( dataDTO.getId()==null || ( dataDTO.getId().trim().equals("") ) ){
            id = null;
        }else{
            id = Long.parseLong(dataDTO.getId());
        }

        // brand
        if( dataDTO.getBrand()==null || ( dataDTO.getBrand().trim().equals("") )){
            brand = null;
        }else{
            brand = dataDTO.getBrand();
        }

        // serialNumber
        if( dataDTO.getSerialNumber()==null || ( dataDTO.getSerialNumber().trim().equals("") )){
            serialNumber = null;
        }else{
            serialNumber = dataDTO.getSerialNumber();
        }

        // boreSize
        if( dataDTO.getBoreSize()==null || ( dataDTO.getBoreSize().trim().equals("") )){
            boreSize = null;
        }else{
            boreSize = dataDTO.getBoreSize();
        }

        // boreUnit
        if( dataDTO.getBoreUnit()==null || ( dataDTO.getBoreUnit().trim().equals("") )){
            boreUnit = null;
        }else{
            boreUnit = dataDTO.getBoreUnit();
        }

        // type
        if( dataDTO.getType()==null || ( dataDTO.getType().trim().equals("") )){
            type = null;
        }else{
            type = dataDTO.getType();
        }

        // photoQr
        if( dataDTO.getPhotoQr()==null || ( dataDTO.getPhotoQr().trim().equals("") )){
            photoQr = null;
        }else{
            photoQr = dataDTO.getPhotoQr();
        }

        // Entity creation
        Weapon dataEntity = new Weapon();
        dataEntity.setId(id);

        dataEntity.setBrand(brand);
        dataEntity.setSerialNumber(serialNumber);
        dataEntity.setBoreSize(boreSize);
        dataEntity.setBoreUnit(boreUnit);
        dataEntity.setType(type);

        dataEntity.setPhotoQr(photoQr);
        return dataEntity;
    }

    public WeaponDTO entityToDTOMapper( Weapon dataEntity ){
        
        // attributes
        String id = null;

        String brand = null;
        String serialNumber = null;
        String boreSize = null;
        String boreUnit = null;
        String type = null;

        String photoQr = null;

        // transformation   ----------------------------------------------------------------
        // id
        if(   dataEntity.getId()==null   ){
            id = null;
        }else{
            id = dataEntity.getId().toString();
        }

        // brand
        if(   dataEntity.getBrand()==null || dataEntity.getBrand().trim().equals("")   ){
            brand = null;
        }else{
            brand = dataEntity.getBrand();
        }
        
        // serialNumber
        if(   dataEntity.getSerialNumber()==null || dataEntity.getSerialNumber().trim().equals("")   ){
            serialNumber = null;
        }else{
            serialNumber = dataEntity.getSerialNumber();
        }

        // boreSize
        if(   dataEntity.getBoreSize()==null || dataEntity.getBoreSize().trim().equals("")   ){
            boreSize = null;
        }else{
            boreSize = dataEntity.getBoreSize();
        }

        // boreUnit
        if(   dataEntity.getBoreUnit()==null || dataEntity.getBoreUnit().trim().equals("")   ){
            boreUnit = null;
        }else{
            boreUnit = dataEntity.getBoreUnit();
        }

        // type
        if(   dataEntity.getType()==null || dataEntity.getType().trim().equals("")   ){
            type = null;
        }else{
            type = dataEntity.getType();
        }

        // photoQr
        if(   dataEntity.getPhotoQr()==null || dataEntity.getPhotoQr().trim().equals("")   ){
            photoQr = null;
        }else{
            photoQr = dataEntity.getPhotoQr();
        }

        // Entity creation
        WeaponDTO dataDTO = new WeaponDTO();
        dataDTO.setId(id);

        dataDTO.setBrand(brand);
        dataDTO.setSerialNumber(serialNumber);
        dataDTO.setBoreSize(boreSize);
        dataDTO.setBoreUnit(boreUnit);
        dataDTO.setType(type);

        dataDTO.setPhotoQr(photoQr);
        return dataDTO;
    }
    
}

