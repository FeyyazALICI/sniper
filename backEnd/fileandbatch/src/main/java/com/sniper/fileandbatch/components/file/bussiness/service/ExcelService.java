package com.sniper.fileandbatch.components.file.bussiness.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sniper.fileandbatch.components.file.bussiness.dto.ShootingWithWeaponDTO;

// Excel imports
import java.io.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@Service
public class ExcelService {
    
    public ResponseEntity<byte[]> exportAllCatsToExcel(List<ShootingWithWeaponDTO> data) throws Exception {
        // Create an Excel workbook
        Workbook workbook = new XSSFWorkbook();

        // preparing sheet name
        Sheet sheet = workbook.createSheet(   "data"   );

        // Create header row
        Row headerRow = sheet.createRow(0);
        int i = 0;
        headerRow.createCell(i++).setCellValue("id");

        headerRow.createCell(i++).setCellValue("distance");
        headerRow.createCell(i++).setCellValue("distance_category");
        headerRow.createCell(i++).setCellValue("shot_fired");
        headerRow.createCell(i++).setCellValue("hit");
        headerRow.createCell(i++).setCellValue("date_of_shooting");

        headerRow.createCell(i++).setCellValue("weapon_id");
        headerRow.createCell(i++).setCellValue("weapon_brand");
        headerRow.createCell(i++).setCellValue("weapon_serial_number");
        headerRow.createCell(i++).setCellValue("weapon_bore_size");
        headerRow.createCell(i++).setCellValue("weapon_bore_unit");

        headerRow.createCell(i++).setCellValue("weapon_type");
        headerRow.createCell(i++).setCellValue("weapon_photo_qr");

        // Fill data
        int rowNum = 1;
        for (ShootingWithWeaponDTO item : data) {
            Row row = sheet.createRow(rowNum++);
            int j = 0;
            row.createCell(j++).setCellValue(item.getId());

            row.createCell(j++).setCellValue(item.getDistance());
            row.createCell(j++).setCellValue(item.getDistanceCategory());
            row.createCell(j++).setCellValue(item.getShotFired());
            row.createCell(j++).setCellValue(item.getHit());
            row.createCell(j++).setCellValue(item.getDateOfShooting());

            row.createCell(j++).setCellValue(item.getWeaponId());
            row.createCell(j++).setCellValue(item.getWeaponBrand());
            row.createCell(j++).setCellValue(item.getWeaponSerialNumber());
            row.createCell(j++).setCellValue(item.getWeaponBoreSize());
            row.createCell(j++).setCellValue(item.getWeaponBoreUnit());

            row.createCell(j++).setCellValue(item.getWeaponType());
            row.createCell(j++).setCellValue(item.getWeaponPhotoQr());
        }

          {
  }

        // Write to byte array output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);
        // preparing file name
        Date currenDate = new Date(System.currentTimeMillis());
        String sdfPattern = "dd.MM.yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(sdfPattern);
        String dateString = sdf.format(currenDate);
        StringBuilder stb = new StringBuilder();
        stb.append("AllData");
        stb.append("_");
        stb.append(dateString);
        stb.append(".xlsx");
        String fileName = stb.toString();
        
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentLength(outputStream.size());

        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }
}