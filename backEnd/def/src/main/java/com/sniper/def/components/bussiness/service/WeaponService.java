package com.sniper.def.components.bussiness.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.bussiness.dtoMapper.WeaponMapper;
import com.sniper.def.components.bussiness.serviceInterface.WeaponServiceInterface;
import com.sniper.def.components.dao.entity.Weapon;
import com.sniper.def.components.dao.repository.WeaponRepo;

import jakarta.transaction.Transactional;

@Service
public class WeaponService implements WeaponServiceInterface{
    
    private final WeaponRepo weaponRepo;

    public WeaponService(
        WeaponRepo weaponRepo
    ){
        this.weaponRepo             = weaponRepo;
    }

    // weapon CRUD OPERATIONS ---------------------------------------------------
    // GET ALL
    @Override
    public List<WeaponDTO> getAllWeapons() throws Exception{
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

    @Override
    public WeaponDTO getWeaponById( Long id ) throws Exception{
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

    @Override
    @Transactional
    public boolean insertWeapon( Weapon data ) throws Exception{
        try{
            if(data.getSerialNumber()!=null && !data.getSerialNumber().trim().equals("")){
                data.setId(null);
                this.weaponRepo.saveAndFlush(data);
                return true;
            }
            System.out.println("SerialNumber can not be left empty!");
            return false;
        }catch( Exception e ){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean ifWeaponExists( Long id ) throws Exception{
        try{
            Optional<Weapon> list = this.weaponRepo.findById(id);
            if(   list.isPresent()   )
                return true;
            return false;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean updateWeapon( Weapon data ) throws Exception{
        try{
            if( ifWeaponExists( data.getId() ) ){
                this.weaponRepo.saveAndFlush(data);
                return true;
            }
            System.out.println("Weapon with given id does not exist!");
            return false;
        }catch( Exception e ){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean deleteWeapon( Long id ) throws Exception{
        try{
            if( ifWeaponExists( id ) ){
                this.weaponRepo.deleteById( id );
                return true;
            }
            System.out.println("Weapon with given id does not exist!");
            return false;
        }catch( Exception e ){
            System.out.println("Internal Server Error!");
            return false;
        }
    }
    // weapon CRUD OPERATIONS ---------------------------------------------------


     // checking if the weapon id is present
    public boolean isIdOfWeaponExist(Long id){
        return this.weaponRepo.existsById(id);
    }
}
