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
import com.sniper.def.components.dao.entity.WeaponFeedBack;
import com.sniper.def.components.api.controllerInterface.WeaponFeedBackControllerInterface;
import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;
import com.sniper.def.components.bussiness.dtoMapper.WeaponFeedBackMapper;
import com.sniper.def.components.bussiness.service.WeaponFeedBackService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;

@RequestMapping("/weapon_fb")
@RestController
public class WeaponFeedBackController implements WeaponFeedBackControllerInterface{
    
    private final WeaponFeedBackService service;
    private final HttpHeaderCreator httpHeaderCreator;

    public WeaponFeedBackController(
        WeaponFeedBackService service,
        HttpHeaderCreator httpHeaderCreator
    ){
        this.service         = service;
        this.httpHeaderCreator  = httpHeaderCreator;
    }

    @Override
    @GetMapping()
    public ResponseEntity getAllWeaponFeedBacks(HttpServletRequest request){
        String requestType = "GET";
        try{
            List<WeaponFeedBackDTO> data = service.getAllWeaponFeedBacks();
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
    public ResponseEntity getWeaponFeedBackById(HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   ){
        String requestType = "GET";
        try{
            Long id = Long.valueOf(dataReceived.get("id"));
            WeaponFeedBackDTO data = service.getWeaponFeedBackById(   id   );
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
    public ResponseEntity insertWeaponFeedBack(   HttpServletRequest request, @Valid @RequestBody WeaponFeedBackDTO dataReceived   ){
        WeaponFeedBackMapper weaponFeedBackMapper = new WeaponFeedBackMapper();
        WeaponFeedBack weaponFeedBack = weaponFeedBackMapper.DTOtoEntityMapper( dataReceived );
        ErrorMessageDerived emd = new ErrorMessageDerived();
        String requestType = "POST";
        try{
            if( service.insertWeaponFeedBack(weaponFeedBack) ){
                HttpHeaders responseHeader = this.httpHeaderCreator.okResponseHeader(request, requestType);
                return new ResponseEntity<>(weaponFeedBack, responseHeader, HttpStatus.OK);
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
    public ResponseEntity updateWeaponFeedBack(   HttpServletRequest request, @Valid @RequestBody WeaponFeedBackDTO dataReceived   ){
        WeaponFeedBackMapper weaponFeedBackMapper = new WeaponFeedBackMapper();
        WeaponFeedBack weaponFeedBack = weaponFeedBackMapper.DTOtoEntityMapper( dataReceived );
        ErrorMessageDerived emd = new ErrorMessageDerived();
        String requestType = "PUT";
        try{
            if( service.updateWeaponFeedBack(weaponFeedBack) ){
                HttpHeaders responseHeader = this.httpHeaderCreator.okResponseHeader(request, requestType);
                return new ResponseEntity<>(weaponFeedBack, responseHeader, HttpStatus.OK);
            }
            HttpHeaders responseHeader = this.httpHeaderCreator.notFoundResponseHeader(request, requestType);
            return new ResponseEntity<>( emd.notFoundError(weaponFeedBack.getId().toString()), responseHeader, HttpStatus.NOT_FOUND);
        }catch( Exception e ){
            HttpHeaders responseHeader = this.httpHeaderCreator.internalServerErrorResponseHeader(request, requestType);
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteWeaponFeedBack(   HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   ){
        Long id = Long.valueOf( dataReceived.get("id") );
        String requestType = "DELETE";
        try{
            if( service.deleteWeaponFeedBack(id) ){
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
