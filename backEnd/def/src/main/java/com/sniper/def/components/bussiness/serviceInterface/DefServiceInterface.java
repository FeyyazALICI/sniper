package com.sniper.def.components.bussiness.serviceInterface;

import java.util.List;

import com.sniper.def.components.bussiness.dto.WeaponDTO;
import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;
import com.sniper.def.components.dao.entity.Weapon;
import com.sniper.def.components.dao.entity.WeaponFeedBack;

public interface DefServiceInterface {
    
    // Weapon CRUD -------------------------------------------------------
    public List<WeaponDTO> getAllWeapons() throws Exception;
    public WeaponDTO getWeaponById( Long id ) throws Exception;
    public boolean insertWeapon( Weapon data ) throws Exception;
    public boolean ifWeaponExists( Long id ) throws Exception;
    public boolean updateWeapon( Weapon data ) throws Exception;
    public boolean deleteWeapon( Long id ) throws Exception;
    // Weapon CRUD -------------------------------------------------------


    // WeaponFeedBack CRUD -------------------------------------------------------
    public List<WeaponFeedBackDTO> getAllWeaponFeedBacks() throws Exception;
    public WeaponFeedBackDTO getWeaponFeedBackById( Long id ) throws Exception;
    public boolean insertWeaponFeedBack( WeaponFeedBack data ) throws Exception;
    public boolean ifWeaponFeedBackExists( Long id ) throws Exception;
    public boolean updateWeaponFeedBack( WeaponFeedBack data ) throws Exception;
    public boolean deleteWeaponFeedBack( Long id ) throws Exception;
    // WeaponFeedBack CRUD -------------------------------------------------------
}
