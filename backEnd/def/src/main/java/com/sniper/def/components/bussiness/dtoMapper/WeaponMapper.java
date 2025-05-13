package com.sniper.def.components.bussiness.dtoMapper;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.dao.entity.Weapon;

public class WeaponMapper {
    

    public Weapon DTOtoEntityMapper( WeaponDTO weaponDTO ){
        
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
        if( weaponDTO.getId()==null || ( weaponDTO.getId().trim().equals("") ) ){
            id = null;
        }else{
            id = Long.parseLong(weaponDTO.getId());
        }

        // brand
        if( weaponDTO.getBrand()==null || ( weaponDTO.getBrand().trim().equals("") )){
            brand = null;
        }else{
            brand = weaponDTO.getBrand();
        }

        // serialNumber
        if( weaponDTO.getSerialNumber()==null || ( weaponDTO.getSerialNumber().trim().equals("") )){
            serialNumber = null;
        }else{
            serialNumber = weaponDTO.getSerialNumber();
        }

        // boreSize
        if( weaponDTO.getBoreSize()==null || ( weaponDTO.getBoreSize().trim().equals("") )){
            boreSize = null;
        }else{
            boreSize = weaponDTO.getBoreSize();
        }

        // boreUnit
        if( weaponDTO.getBoreUnit()==null || ( weaponDTO.getBoreUnit().trim().equals("") )){
            boreUnit = null;
        }else{
            boreUnit = weaponDTO.getBoreUnit();
        }

        // type
        if( weaponDTO.getType()==null || ( weaponDTO.getType().trim().equals("") )){
            type = null;
        }else{
            type = weaponDTO.getType();
        }

        // photoQr
        if( weaponDTO.getPhotoQr()==null || ( weaponDTO.getPhotoQr().trim().equals("") )){
            photoQr = null;
        }else{
            photoQr = weaponDTO.getPhotoQr();
        }

        // Entity creation
        Weapon weapon = new Weapon();
        weapon.setId(id);

        weapon.setBrand(brand);
        weapon.setSerialNumber(serialNumber);
        weapon.setBoreSize(boreSize);
        weapon.setBoreUnit(boreUnit);
        weapon.setType(type);

        weapon.setPhotoQr(photoQr);
        return weapon;
    }

    public WeaponDTO entityToDTOMapper( Weapon weapon ){
        
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
        if(   weapon.getId()==null   ){
            id = null;
        }else{
            id = weapon.getId().toString();
        }

        // brand
        if(   weapon.getBrand()==null || weapon.getBrand().trim().equals("")   ){
            brand = null;
        }else{
            brand = weapon.getBrand();
        }
        
        // serialNumber
        if(   weapon.getSerialNumber()==null || weapon.getSerialNumber().trim().equals("")   ){
            serialNumber = null;
        }else{
            serialNumber = weapon.getSerialNumber();
        }

        // boreSize
        if(   weapon.getBoreSize()==null || weapon.getBoreSize().trim().equals("")   ){
            boreSize = null;
        }else{
            boreSize = weapon.getBoreSize();
        }

        // boreUnit
        if(   weapon.getBoreUnit()==null || weapon.getBoreUnit().trim().equals("")   ){
            boreUnit = null;
        }else{
            boreUnit = weapon.getBoreUnit();
        }

        // type
        if(   weapon.getType()==null || weapon.getType().trim().equals("")   ){
            type = null;
        }else{
            type = weapon.getType();
        }

        // photoQr
        if(   weapon.getPhotoQr()==null || weapon.getPhotoQr().trim().equals("")   ){
            photoQr = null;
        }else{
            photoQr = weapon.getPhotoQr();
        }

        // Entity creation
        WeaponDTO weaponDTO = new WeaponDTO();
        weaponDTO.setId(id);

        weaponDTO.setBrand(brand);
        weaponDTO.setSerialNumber(serialNumber);
        weaponDTO.setBoreSize(boreSize);
        weaponDTO.setBoreUnit(boreUnit);
        weaponDTO.setType(type);

        weaponDTO.setPhotoQr(photoQr);
        return weaponDTO;
    }
    
}

