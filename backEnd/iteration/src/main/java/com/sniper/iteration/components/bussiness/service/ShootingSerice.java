package com.sniper.iteration.components.bussiness.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sniper.iteration.components.bussiness.dto.ShootingDTO;
import com.sniper.iteration.components.bussiness.dtoMapper.ShootingMapper;
import com.sniper.iteration.components.bussiness.serviceInterface.ShootingServiceInterface;
import com.sniper.iteration.components.dao.entity.Shooting;
import com.sniper.iteration.components.dao.repo.ShootingRepo;

import jakarta.transaction.Transactional;

@Service
public class ShootingSerice implements ShootingServiceInterface{
    
    private final ShootingRepo crudRepo;

    public ShootingSerice(
        ShootingRepo crudRepo
    ){
        this.crudRepo = crudRepo;
    }

    // CRUD OPERATIONS ---------------------------------------------------
    // GET ALL
    @Override
    public List<ShootingDTO> getAllData() throws Exception{
        try{
            ShootingMapper mapper = new ShootingMapper();
            List<Shooting> data = this.crudRepo.findAll();
            List<ShootingDTO> dataDTO = new ArrayList<>();
            for(Shooting e: data){
                ShootingDTO weaponDTO = new ShootingDTO();
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
    public ShootingDTO getDataById( Long id ) throws Exception{
        try{
            ShootingMapper mapper = new ShootingMapper();

            Optional<Shooting> data = this.crudRepo.findById(id);
            if(data.isPresent()){
                ShootingDTO dataDTO = new ShootingDTO();
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
    public boolean insertRow( ShootingDTO dataDTO ) throws Exception{
        try{
            if( dataDTO.getWeaponId()!=null && dataDTO.getDateOfShooting()!=null && dataDTO.getShotFired()!=null ){
                dataDTO.setId(null);
                ShootingMapper mapper = new ShootingMapper();
                Shooting data = new Shooting();
                data = mapper.DTOtoEntityMapper(dataDTO);
                this.crudRepo.saveAndFlush(data);
                return true;
            }
            System.out.println("Weapon Id, Date of Shooting & Shot Fired fields can not be left empty!");
            return false;
        }catch( Exception e ){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean ifRowExists( Long id ) throws Exception{
        try{
            Optional<Shooting> list = this.crudRepo.findById(id);
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
    public boolean updateRow( ShootingDTO dataDTO ) throws Exception{
        try{
            ShootingMapper mapper = new ShootingMapper();
            Shooting data = new Shooting();
            data = mapper.DTOtoEntityMapper(dataDTO);
            if( ifRowExists( data.getId() ) ){
                this.crudRepo.saveAndFlush(data);
                return true;
            }
            System.out.println("Row with given id does not exist!");
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
            System.out.println("Row with given id does not exist!");
            return false;
        }catch( Exception e ){
            System.out.println("Internal Server Error!");
            return false;
        }
    }
    // CRUD OPERATIONS ---------------------------------------------------
}
