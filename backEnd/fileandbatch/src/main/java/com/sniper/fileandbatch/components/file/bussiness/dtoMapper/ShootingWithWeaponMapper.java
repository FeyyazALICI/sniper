package com.sniper.fileandbatch.components.file.bussiness.dtoMapper;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sniper.fileandbatch.components.file.bussiness.dto.ShootingWithWeaponDTO;
import com.sniper.fileandbatch.components.file.dao.entity.ShootingWithWeapon;

public class ShootingWithWeaponMapper {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ShootingWithWeaponDTO entityToDTOMapper(ShootingWithWeapon dataEntity) {

        ShootingWithWeaponDTO dataDTO = new ShootingWithWeaponDTO();

        // id
        dataDTO.setId(dataEntity.getId() != null ? dataEntity.getId().toString() : null);

        // distance
        dataDTO.setDistance(dataEntity.getDistance() != null ? dataEntity.getDistance().toPlainString() : null);

        // distanceCategory
        dataDTO.setDistanceCategory(
            dataEntity.getDistanceCategory() != null && !dataEntity.getDistanceCategory().trim().isEmpty()
                ? dataEntity.getDistanceCategory()
                : null
        );

        // shotFired
        dataDTO.setShotFired(dataEntity.getShotFired() != null ? dataEntity.getShotFired().toPlainString() : null);

        // hit
        dataDTO.setHit(dataEntity.getHit() != null ? dataEntity.getHit().toPlainString() : null);

        // dateOfShooting
        dataDTO.setDateOfShooting(dataEntity.getDateOfShooting() != null ? sdf.format(dataEntity.getDateOfShooting()) : null);

        // weaponId
        dataDTO.setWeaponId(dataEntity.getWeaponId() != null ? dataEntity.getWeaponId().toString() : null);

        // weaponBrand
        dataDTO.setWeaponBrand(
            dataEntity.getWeaponBrand() != null && !dataEntity.getWeaponBrand().trim().isEmpty()
                ? dataEntity.getWeaponBrand()
                : null
        );

        // weaponSerialNumber
        dataDTO.setWeaponSerialNumber(
            dataEntity.getWeaponSerialNumber() != null && !dataEntity.getWeaponSerialNumber().trim().isEmpty()
                ? dataEntity.getWeaponSerialNumber()
                : null
        );

        // weaponBoreSize
        dataDTO.setWeaponBoreSize(dataEntity.getWeaponBoreSize() != null ? dataEntity.getWeaponBoreSize().toPlainString() : null);

        // weaponBoreUnit
        dataDTO.setWeaponBoreUnit(
            dataEntity.getWeaponBoreUnit() != null && !dataEntity.getWeaponBoreUnit().trim().isEmpty()
                ? dataEntity.getWeaponBoreUnit()
                : null
        );

        // weaponType
        dataDTO.setWeaponType(
            dataEntity.getWeaponType() != null && !dataEntity.getWeaponType().trim().isEmpty()
                ? dataEntity.getWeaponType()
                : null
        );

        // weaponPhotoQr
        dataDTO.setWeaponPhotoQr(
            dataEntity.getWeaponPhotoQr() != null && !dataEntity.getWeaponPhotoQr().trim().isEmpty()
                ? dataEntity.getWeaponPhotoQr()
                : null
        );

        return dataDTO;
    }

    // Optional: If you ever need to map back from DTO to Entity (e.g., for tests),
    // here’s a basic reverse mapping.
    public ShootingWithWeapon dtoToEntityMapper(ShootingWithWeaponDTO dto) {
        Long id = parseLong(dto.getId());
        BigDecimal distance = parseBigDecimal(dto.getDistance());
        String distanceCategory = emptyToNull(dto.getDistanceCategory());
        BigDecimal shotFired = parseBigDecimal(dto.getShotFired());
        BigDecimal hit = parseBigDecimal(dto.getHit());
        Date dateOfShooting = parseDate(dto.getDateOfShooting());

        Long weaponId = parseLong(dto.getWeaponId());
        String weaponBrand = emptyToNull(dto.getWeaponBrand());
        String weaponSerialNumber = emptyToNull(dto.getWeaponSerialNumber());
        BigDecimal weaponBoreSize = parseBigDecimal(dto.getWeaponBoreSize());
        String weaponBoreUnit = emptyToNull(dto.getWeaponBoreUnit());
        String weaponType = emptyToNull(dto.getWeaponType());
        String weaponPhotoQr = emptyToNull(dto.getWeaponPhotoQr());

        return new ShootingWithWeapon(
            id, distance, distanceCategory, shotFired, hit, dateOfShooting,
            weaponId, weaponBrand, weaponSerialNumber, weaponBoreSize, weaponBoreUnit,
            weaponType, weaponPhotoQr
        );
    }

    // Helper methods
    private Long parseLong(String value) {
        try {
            return (value != null && !value.trim().isEmpty()) ? Long.parseLong(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private BigDecimal parseBigDecimal(String value) {
        try {
            return (value != null && !value.trim().isEmpty()) ? new BigDecimal(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Date parseDate(String value) {
        try {
            return (value != null && !value.trim().isEmpty()) ? sdf.parse(value) : null;
        } catch (Exception e) {
            return null;
        }
    }

    private String emptyToNull(String value) {
        return (value != null && !value.trim().isEmpty()) ? value : null;
    }
}