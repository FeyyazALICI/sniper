package com.sniper.def.components.api.controllerInterface;

import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface ControllerInterface {
    public ResponseEntity getAllWeapons(HttpServletRequest request);
}
