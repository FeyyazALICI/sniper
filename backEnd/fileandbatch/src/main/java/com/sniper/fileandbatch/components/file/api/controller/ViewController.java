package com.sniper.fileandbatch.components.file.api.controller;


import org.springframework.web.bind.annotation.RestController;

import com.sniper.fileandbatch.common.HttpHeaderCreator;
import com.sniper.fileandbatch.components.file.api.controllerInterface.ViewControllerInterface;
import com.sniper.fileandbatch.components.file.bussiness.dto.ShootingWithWeaponDTO;
import com.sniper.fileandbatch.components.file.bussiness.dto.SuccessRateDTO;
import com.sniper.fileandbatch.components.file.bussiness.service.ViewService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/view")

public class ViewController implements ViewControllerInterface{

    private final ViewService viewService;
    private final HttpHeaderCreator httpHeaderCreator;
    public ViewController(
        ViewService viewService,
        HttpHeaderCreator httpHeaderCreator
    ){
        this.viewService        = viewService;
        this.httpHeaderCreator  = httpHeaderCreator;
    }

    @Override
    @GetMapping("/swwv")
    public ResponseEntity getAllShootingWithWeaponsWithSuccessRate(HttpServletRequest request){
        String requestType = "GET";
        try{
            List<SuccessRateDTO> data = viewService.getAllShootingWithWeaponsWithSuccessRate();
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
    @PostMapping("/swwv/id")
    public ResponseEntity getShootingWithWeaponById(HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   ){
        String requestType = "GET";
        try{
            Long id = Long.valueOf(dataReceived.get("id"));
            ShootingWithWeaponDTO data = viewService.getShootingWithWeaponById(   id   );
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
}
