package com.sniper.fileandbatch.components.file.api.controller;


import org.springframework.web.bind.annotation.RestController;

import com.sniper.fileandbatch.common.HttpHeaderCreator;
import com.sniper.fileandbatch.components.file.api.controllerInterface.ExcelInterface;
import com.sniper.fileandbatch.components.file.bussiness.dto.ShootingWithWeaponDTO;
import com.sniper.fileandbatch.components.file.bussiness.service.ExcelService;
import com.sniper.fileandbatch.components.file.bussiness.service.ViewService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/excel")

public class ExcelController implements ExcelInterface{

    private final ExcelService excelService;
    private final ViewService viewService;
    private final HttpHeaderCreator httpHeaderCreator;

    public ExcelController(
        ExcelService excelService,
        HttpHeaderCreator httpHeaderCreator,
        ViewService viewService
    ){
        this.excelService           = excelService;
        this.httpHeaderCreator      = httpHeaderCreator;
        this.viewService            = viewService;
    }

    // getting all data of shooting_with_weapon table
    @Override
    @PostMapping("/swwv")
    public ResponseEntity<byte[]> exportAllDataToExcel(HttpServletRequest request) throws Exception {
        String requestType = "GET";
        try{
            List<ShootingWithWeaponDTO> data = viewService.getAllShootingWithWeapons();
            return this.excelService.exportAllCatsToExcel(data);
        }catch(Exception e){
            HttpHeaders responseHeader = this.httpHeaderCreator.internalServerErrorResponseHeader(request, requestType);
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
