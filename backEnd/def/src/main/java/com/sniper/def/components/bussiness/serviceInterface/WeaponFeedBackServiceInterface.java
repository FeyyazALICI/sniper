package com.sniper.def.components.bussiness.serviceInterface;

import java.util.List;

import com.sniper.def.components.bussiness.dto.WeaponFeedBackDTO;
import com.sniper.def.components.dao.entity.WeaponFeedBack;

public interface WeaponFeedBackServiceInterface {

    // WeaponFeedBack CRUD -------------------------------------------------------
    public List<WeaponFeedBackDTO> getAllWeaponFeedBacks() throws Exception;
    public WeaponFeedBackDTO getWeaponFeedBackById( Long id ) throws Exception;
    public boolean insertWeaponFeedBack( WeaponFeedBack data ) throws Exception;
    public boolean ifWeaponFeedBackExists( Long id ) throws Exception;
    public boolean updateWeaponFeedBack( WeaponFeedBack data ) throws Exception;
    public boolean deleteWeaponFeedBack( Long id ) throws Exception;
    // WeaponFeedBack CRUD -------------------------------------------------------
}
