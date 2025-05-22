package com.sniper.def.components.bussiness.serviceInterface;

import java.util.List;

import com.sniper.def.components.bussiness.dto.WeaponDTO;

public interface WeaponServiceInterface {
    
    // Weapon CRUD -------------------------------------------------------
    public List<WeaponDTO> getAllData() throws Exception;
    public WeaponDTO getDataById( Long id ) throws Exception;
    public boolean insertRow( WeaponDTO data ) throws Exception;
    public boolean ifRowExists( Long id ) throws Exception;
    public boolean updateRow( WeaponDTO data ) throws Exception;
    public boolean deleteRow( Long id ) throws Exception;
    // Weapon CRUD -------------------------------------------------------


}
