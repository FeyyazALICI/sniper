package com.sniper.def.components.bussiness.dtoMapper.view;

import com.sniper.def.components.bussiness.dto.view.ShootingWithWeaponDTO;
import com.sniper.def.components.dao.entity.view.ShootingWithWeapon;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShootingWithWeaponMapper {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ShootingWithWeaponDTO entityToDTOMapper(ShootingWithWeapon shooting) {

        ShootingWithWeaponDTO dto = new ShootingWithWeaponDTO();

        // id
        dto.setId(shooting.getId() != null ? shooting.getId().toString() : null);

        // distance
        dto.setDistance(shooting.getDistance() != null ? shooting.getDistance().toPlainString() : null);

        // distanceCategory
        dto.setDistanceCategory(
            shooting.getDistanceCategory() != null && !shooting.getDistanceCategory().trim().isEmpty()
                ? shooting.getDistanceCategory()
                : null
        );

        // shotFired
        dto.setShotFired(shooting.getShotFired() != null ? shooting.getShotFired().toPlainString() : null);

        // hit
        dto.setHit(shooting.getHit() != null ? shooting.getHit().toPlainString() : null);

        // dateOfShooting
        dto.setDateOfShooting(shooting.getDateOfShooting() != null ? sdf.format(shooting.getDateOfShooting()) : null);

        // weaponId
        dto.setWeaponId(shooting.getWeaponId() != null ? shooting.getWeaponId().toString() : null);

        // weaponBrand
        dto.setWeaponBrand(
            shooting.getWeaponBrand() != null && !shooting.getWeaponBrand().trim().isEmpty()
                ? shooting.getWeaponBrand()
                : null
        );

        // weaponSerialNumber
        dto.setWeaponSerialNumber(
            shooting.getWeaponSerialNumber() != null && !shooting.getWeaponSerialNumber().trim().isEmpty()
                ? shooting.getWeaponSerialNumber()
                : null
        );

        // weaponBoreSize
        dto.setWeaponBoreSize(shooting.getWeaponBoreSize() != null ? shooting.getWeaponBoreSize().toPlainString() : null);

        // weaponBoreUnit
        dto.setWeaponBoreUnit(
            shooting.getWeaponBoreUnit() != null && !shooting.getWeaponBoreUnit().trim().isEmpty()
                ? shooting.getWeaponBoreUnit()
                : null
        );

        // weaponType
        dto.setWeaponType(
            shooting.getWeaponType() != null && !shooting.getWeaponType().trim().isEmpty()
                ? shooting.getWeaponType()
                : null
        );

        // weaponPhotoQr
        dto.setWeaponPhotoQr(
            shooting.getWeaponPhotoQr() != null && !shooting.getWeaponPhotoQr().trim().isEmpty()
                ? shooting.getWeaponPhotoQr()
                : null
        );

        return dto;
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
