package com.sniper.fileandbatch.components.file.bussiness.serviceInterface;

import java.util.List;

import com.sniper.fileandbatch.components.file.bussiness.dto.ShootingWithWeaponDTO;

public interface ShootingWithWeaponIdInterface {
    
    public List<ShootingWithWeaponDTO> getAllShootingWithWeapons() throws Exception;
    public ShootingWithWeaponDTO getShootingWithWeaponById( Long id ) throws Exception;
}
