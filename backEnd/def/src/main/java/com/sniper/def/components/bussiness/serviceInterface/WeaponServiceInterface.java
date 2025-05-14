package com.sniper.def.components.bussiness.serviceInterface;

import java.util.List;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.dao.entity.Weapon;

public interface WeaponServiceInterface {
    
    // Weapon CRUD -------------------------------------------------------
    public List<WeaponDTO> getAllWeapons() throws Exception;
    public WeaponDTO getWeaponById( Long id ) throws Exception;
    public boolean insertWeapon( Weapon data ) throws Exception;
    public boolean ifWeaponExists( Long id ) throws Exception;
    public boolean updateWeapon( Weapon data ) throws Exception;
    public boolean deleteWeapon( Long id ) throws Exception;
    // Weapon CRUD -------------------------------------------------------


}
