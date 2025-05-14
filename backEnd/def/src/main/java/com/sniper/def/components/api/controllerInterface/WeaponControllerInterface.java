package com.sniper.def.components.api.controllerInterface;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.sniper.def.components.bussiness.dto.WeaponDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface WeaponControllerInterface {
    public ResponseEntity getAllWeapons(HttpServletRequest request);
    public ResponseEntity getWeaponById(HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   );
    public ResponseEntity insertWeapon(   HttpServletRequest request, @Valid @RequestBody WeaponDTO dataReceived   );
    public ResponseEntity updateWeapon(   HttpServletRequest request, @Valid @RequestBody WeaponDTO dataReceived   );  
    public ResponseEntity<Map<String, String>> deleteWeapon(   HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   );
}
