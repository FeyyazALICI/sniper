package com.sniper.def.components.bussiness.serviceInterface;

import java.util.List;

import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;

public interface WeaponFeedBackServiceInterface {

    // WeaponFeedBack CRUD -------------------------------------------------------
    public List<WeaponFeedBackDTO> getAllData() throws Exception;
    public WeaponFeedBackDTO getDataById( Long id ) throws Exception;
    public boolean insertRow( WeaponFeedBackDTO data ) throws Exception;
    public boolean ifRowExists( Long id ) throws Exception;
    public boolean updateRow( WeaponFeedBackDTO data ) throws Exception;
    public boolean deleteRow( Long id ) throws Exception;
    // WeaponFeedBack CRUD -------------------------------------------------------
}
