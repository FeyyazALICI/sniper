package com.sniper.def.components.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sniper.def.common.responseReturns.HttpHeaderCreator;
import com.sniper.def.components.bussiness.service.DefService;
import com.sniper.def.components.api.controllerInterface.ControllerInterface;
import com.sniper.def.components.bussiness.dto.WeaponDTO;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.http.HttpHeaders;

@RequestMapping("/def")
@RestController
public class DefController implements ControllerInterface{
    
    private final DefService defService;
    private final HttpHeaderCreator httpHeaderCreator;

    public DefController(
        DefService defService,
        HttpHeaderCreator httpHeaderCreator
    ){
        this.defService         = defService;
        this.httpHeaderCreator  = httpHeaderCreator;
    }

    @Override
    @GetMapping("/weapon")
    public ResponseEntity getAllWeapons(HttpServletRequest request){
        String requestType = "GET";
        try{
            List<WeaponDTO> data = defService.getAllWeapons();
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
