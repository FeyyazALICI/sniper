package com.sniper.def.components.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sniper.def.common.responseReturns.ErrorMessageDerived;
import com.sniper.def.common.responseReturns.HttpHeaderCreator;
import com.sniper.def.components.dao.entity.Weapon;
import com.sniper.def.components.api.controllerInterface.WeaponControllerInterface;
import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.bussiness.dtoMapper.WeaponMapper;
import com.sniper.def.components.bussiness.service.WeaponService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpHeaders;

@RequestMapping("/weapon")
@RestController
public class WeaponController implements WeaponControllerInterface{
    
    private final WeaponService service;
    private final HttpHeaderCreator httpHeaderCreator;

    public WeaponController(
        WeaponService service,
        HttpHeaderCreator httpHeaderCreator
    ){
        this.service         = service;
        this.httpHeaderCreator  = httpHeaderCreator;
    }

    @Override
    @GetMapping()
    public ResponseEntity getAllWeapons(HttpServletRequest request){
        String requestType = "GET";
        try{
            List<WeaponDTO> data = service.getAllWeapons();
            if(   data!=null   ){
                HttpHeaders responseHeader = this.httpHeaderCreator.okResponseHeader(request, requestType);
                return new ResponseEntity<>(data, responseHeader, HttpStatus.OK);
            }else{
                HttpHeaders responseHeader = this.httpHeaderCreator.notFoundResponseHeader(request, requestType);
                return new ResponseEntity<>(null, responseHeader, HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            HttpHeaders responseHeader = this.httpHeaderCreator.internalServerErrorResponseHeader(request, requestType);
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PostMapping("/id")
    public ResponseEntity getWeaponById(HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   ){
        String requestType = "GET";
        try{
            Long id = Long.valueOf(dataReceived.get("id"));
            WeaponDTO data = service.getWeaponById(   id   );
            if(   data!=null   ){
                HttpHeaders responseHeader = this.httpHeaderCreator.okResponseHeader(request, requestType);
                return new ResponseEntity<>(data, responseHeader, HttpStatus.OK);
            }else{
                HttpHeaders responseHeader = this.httpHeaderCreator.notFoundResponseHeader(request, requestType);
                return new ResponseEntity<>(null, responseHeader, HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            HttpHeaders responseHeader = this.httpHeaderCreator.internalServerErrorResponseHeader(request, requestType);
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PostMapping()
    public ResponseEntity insertWeapon(   HttpServletRequest request, @Valid @RequestBody WeaponDTO dataReceived   ){
        WeaponMapper weaponMapper = new WeaponMapper();
        Weapon weapon = weaponMapper.DTOtoEntityMapper( dataReceived );
        ErrorMessageDerived emd = new ErrorMessageDerived();
        String requestType = "POST";
        System.out.println("weapon: " + weapon.getSerialNumber());
        try{
            if( service.insertWeapon(weapon) ){
                HttpHeaders responseHeader = this.httpHeaderCreator.okResponseHeader(request, requestType);
                return new ResponseEntity<>(weapon, responseHeader, HttpStatus.OK);
            }
            HttpHeaders responseHeader = this.httpHeaderCreator.conflictResponseHeader(request, requestType);
            return new ResponseEntity<>( emd.conflictError(), responseHeader, HttpStatus.CONFLICT);
        }catch( Exception e ){
            HttpHeaders responseHeader = this.httpHeaderCreator.internalServerErrorResponseHeader(request, requestType);
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PutMapping()
    public ResponseEntity updateWeapon(   HttpServletRequest request, @Valid @RequestBody WeaponDTO weaponDTO   ){
        WeaponMapper weaponMapper = new WeaponMapper();
        Weapon weapon = weaponMapper.DTOtoEntityMapper( weaponDTO );
        ErrorMessageDerived emd = new ErrorMessageDerived();
        String requestType = "PUT";
        try{
            if( service.updateWeapon(weapon) ){
                HttpHeaders responseHeader = this.httpHeaderCreator.okResponseHeader(request, requestType);
                return new ResponseEntity<>(weapon, responseHeader, HttpStatus.OK);
            }
            HttpHeaders responseHeader = this.httpHeaderCreator.notFoundResponseHeader(request, requestType);
            return new ResponseEntity<>( emd.notFoundError(weapon.getId().toString()), responseHeader, HttpStatus.NOT_FOUND);
        }catch( Exception e ){
            HttpHeaders responseHeader = this.httpHeaderCreator.internalServerErrorResponseHeader(request, requestType);
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteWeapon(   HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   ){
        Long id = Long.valueOf( dataReceived.get("id") );
        String requestType = "DELETE";
        try{
            if( service.deleteWeapon(id) ){
                HttpHeaders responseHeader = this.httpHeaderCreator.okResponseHeader(request, requestType);
                Map<String, String> responseBody = new HashMap<>();
                responseBody.put("message", "Delete Operation is successful!");
                return new ResponseEntity<>(responseBody, responseHeader, HttpStatus.OK);
            }
            ErrorMessageDerived emd = new ErrorMessageDerived();
            HttpHeaders responseHeader = this.httpHeaderCreator.conflictResponseHeader(request, requestType);
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("error", emd.notFoundErrorById(id));
            return new ResponseEntity<>( responseBody, responseHeader, HttpStatus.CONFLICT);
        }catch( Exception e ){
            HttpHeaders responseHeader = this.httpHeaderCreator.internalServerErrorResponseHeader(request, requestType);
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("error", "Internal Server Error");
            return new ResponseEntity<>(responseBody, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
