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
    
    private final WeaponRepo crudRepo;

    public WeaponService(
        WeaponRepo crudRepo
    ){
        this.crudRepo             = crudRepo;
    }

    // weapon CRUD OPERATIONS ---------------------------------------------------
    // GET ALL
    @Override
    public List<WeaponDTO> getAllData() throws Exception{
        try{
            WeaponMapper mapper = new WeaponMapper();
            List<Weapon> data = this.crudRepo.findAll();
            List<WeaponDTO> dataDTO = new ArrayList<>();
            for(Weapon e: data){
                WeaponDTO weaponDTO = new WeaponDTO();
                weaponDTO = mapper.entityToDTOMapper(e);
                dataDTO.add(weaponDTO);
            }
            return dataDTO;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public WeaponDTO getDataById( Long id ) throws Exception{
        try{
            WeaponMapper mapper = new WeaponMapper();

            Optional<Weapon> data = this.crudRepo.findById(id);
            if(data.isPresent()){
                WeaponDTO dataDTO = new WeaponDTO();
                dataDTO = mapper.entityToDTOMapper(data.get());
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
    public boolean insertRow( WeaponDTO dataDTO ) throws Exception{
        try{
            if(dataDTO.getSerialNumber()!=null && !dataDTO.getSerialNumber().trim().equals("")){
                dataDTO.setId(null);
                WeaponMapper mapper = new WeaponMapper();
                Weapon data = new Weapon();
                data = mapper.DTOtoEntityMapper(dataDTO);
                this.crudRepo.saveAndFlush(data);
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
    public boolean ifRowExists( Long id ) throws Exception{
        try{
            Optional<Weapon> list = this.crudRepo.findById(id);
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
    public boolean updateRow( WeaponDTO dataDTO ) throws Exception{
        try{
            WeaponMapper mapper = new WeaponMapper();
            Weapon data = new Weapon();
            data = mapper.DTOtoEntityMapper(dataDTO);
            if( ifRowExists( data.getId() ) ){
                this.crudRepo.saveAndFlush(data);
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
    public boolean deleteRow( Long id ) throws Exception{
        try{
            if( ifRowExists( id ) ){
                this.crudRepo.deleteById( id );
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
        return this.crudRepo.existsById(id);
    }
}
