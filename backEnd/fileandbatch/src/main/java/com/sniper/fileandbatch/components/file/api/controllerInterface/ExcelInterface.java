package com.sniper.fileandbatch.components.file.api.controllerInterface;

import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface ExcelInterface {
    
    public ResponseEntity<byte[]> exportAllDataToExcel(HttpServletRequest request) throws Exception;
}