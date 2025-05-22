package com.sniper.def.components.bussiness.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;
import com.sniper.def.components.bussiness.dtoMapper.WeaponFeedBackMapper;
import com.sniper.def.components.bussiness.serviceInterface.WeaponFeedBackServiceInterface;
import com.sniper.def.components.dao.entity.WeaponFeedBack;
import com.sniper.def.components.dao.repository.WeaponFeedBackRepo;

import jakarta.transaction.Transactional;

@Service
public class WeaponFeedBackService implements WeaponFeedBackServiceInterface{
    
    private final WeaponFeedBackRepo crudRepo;
    private final WeaponService crudService;

    public WeaponFeedBackService(
        WeaponFeedBackRepo crudRepo,
        WeaponService crudService
    ){
        this.crudRepo     = crudRepo;
        this.crudService = crudService;
    }


    // weaponFeedBack CRUD OPERATIONS ---------------------------------------------------
    @Override
    public List<WeaponFeedBackDTO> getAllData() throws Exception{
        try{
            WeaponFeedBackMapper weaponFeedBackMapper = new WeaponFeedBackMapper();
            List<WeaponFeedBack> data = this.crudRepo.findAll();
            List<WeaponFeedBackDTO> dataDTO = new ArrayList<>();
            for(WeaponFeedBack e: data){
                WeaponFeedBackDTO weaponFeedBackDTO = new WeaponFeedBackDTO();
                weaponFeedBackDTO = weaponFeedBackMapper.entityToDTOMapper(e);
                dataDTO.add(weaponFeedBackDTO);
            }
            return dataDTO;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public WeaponFeedBackDTO getDataById( Long id ) throws Exception{
        try{
            WeaponFeedBackMapper weaponFeedBackMapper = new WeaponFeedBackMapper();

            Optional<WeaponFeedBack> data = this.crudRepo.findById(id);
            if(data.isPresent()){
                WeaponFeedBackDTO dataDTO = new WeaponFeedBackDTO();
                dataDTO = weaponFeedBackMapper.entityToDTOMapper(data.get());
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
    public boolean insertRow( WeaponFeedBackDTO dataDTO ) throws Exception{
        try{
            WeaponFeedBackMapper mapper = new WeaponFeedBackMapper();
            WeaponFeedBack data = new WeaponFeedBack();
            data = mapper.DTOtoEntityMapper(dataDTO);
            if(   data.getWeaponId()!=null && data.getWeaponId()!=null && !data.getUserComment().trim().equals("")   ){
                if(this.crudRepo.existsByWeaponId(data.getWeaponId()) == false){
                    if(this.crudService.isIdOfWeaponExist(data.getWeaponId())){
                        data.setId(null);
                        this.crudRepo.saveAndFlush(data);
                        return true;
                    }
                    System.out.println("The linked weapon table does not have a weapon with given weapon id!");
                    return false;
                }
                System.out.println("The weapon_id has a comment on it already!");
                return false;
            }
            System.out.println(data.getWeaponId());
            
            System.out.println("WeaponId & UserComment can not be left empty!");
            return false;
        }catch( Exception e ){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean ifRowExists( Long id ) throws Exception{
        try{
            Optional<WeaponFeedBack> list = this.crudRepo.findById(id);
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
    public boolean updateRow( WeaponFeedBackDTO dataDTO ) throws Exception{
        try{
            WeaponFeedBackMapper mapper = new WeaponFeedBackMapper();
            WeaponFeedBack data = new WeaponFeedBack();
            data = mapper.DTOtoEntityMapper(dataDTO);
            if( ifRowExists( data.getId() ) ){
                this.crudRepo.saveAndFlush(data);
                return true;
            }
            System.out.println("WeaponFeedBack with given id does not exist!");
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
            System.out.println("WeaponFeedBack with given id does not exist!");
            return false;
        }catch( Exception e ){
            System.out.println("Internal Server Error!");
            return false;
        }
    }
    // weaponFeedBack CRUD OPERATIONS ---------------------------------------------------
}
