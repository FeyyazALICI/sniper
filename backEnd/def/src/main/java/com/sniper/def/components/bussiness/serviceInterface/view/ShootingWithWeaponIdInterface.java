package com.sniper.def.components.bussiness.serviceInterface.view;

import java.util.List;

import com.sniper.def.components.bussiness.dto.WeaponDTO;

public interface ShootingWithWeaponIdInterface {
    
    public List<WeaponDTO> getAllShootingWithWeapons() throws Exception;
    public WeaponDTO getShootingWithWeaponById( Long id ) throws Exception;
}
