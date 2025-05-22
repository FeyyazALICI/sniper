package com.sniper.iteration.components.bussiness.serviceInterface;

import java.util.List;

import com.sniper.iteration.components.bussiness.dto.ShootingDTO;

public interface ShootingServiceInterface {
    // CRUD -------------------------------------------------------
    public List<ShootingDTO> getAllData() throws Exception;
    public ShootingDTO getDataById( Long id ) throws Exception;
    public boolean insertRow( ShootingDTO data ) throws Exception;
    public boolean ifRowExists( Long id ) throws Exception;
    public boolean updateRow( ShootingDTO data ) throws Exception;
    public boolean deleteRow( Long id ) throws Exception;
    //CRUD -------------------------------------------------------
}
