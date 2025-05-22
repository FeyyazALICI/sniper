package com.sniper.iteration.components.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.sniper.iteration.components.bussiness.dto.ShootingDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface ShootingControllerInterface {
    public ResponseEntity getAllData(HttpServletRequest request);
    public ResponseEntity getDataById(HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   );
    public ResponseEntity insertRow(   HttpServletRequest request, @Valid @RequestBody ShootingDTO dataReceived   );
    public ResponseEntity updateRow(   HttpServletRequest request, @Valid @RequestBody ShootingDTO dataReceived   );  
    public ResponseEntity<Map<String, String>> deleteRow(   HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   );
}