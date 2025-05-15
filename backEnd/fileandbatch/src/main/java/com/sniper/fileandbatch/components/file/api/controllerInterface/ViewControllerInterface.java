package com.sniper.fileandbatch.components.file.api.controllerInterface;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletRequest;

public interface ViewControllerInterface {
    
    public ResponseEntity getAllShootingWithWeapons(HttpServletRequest request);
    public ResponseEntity getShootingWithWeaponById(HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   );
}