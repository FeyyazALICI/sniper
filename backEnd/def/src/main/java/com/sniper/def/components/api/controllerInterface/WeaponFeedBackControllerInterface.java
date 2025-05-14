package com.sniper.def.components.api.controllerInterface;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface WeaponFeedBackControllerInterface {
    public ResponseEntity getAllWeaponFeedBacks(HttpServletRequest request);
    public ResponseEntity getWeaponFeedBackById(HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   );
    public ResponseEntity insertWeaponFeedBack(   HttpServletRequest request, @Valid @RequestBody WeaponFeedBackDTO dataReceived   );
    public ResponseEntity updateWeaponFeedBack(   HttpServletRequest request, @Valid @RequestBody WeaponFeedBackDTO dataReceived   );  
    public ResponseEntity<Map<String, String>> deleteWeaponFeedBack(   HttpServletRequest request, @RequestBody HashMap<String, String> dataReceived   );
}
