package com.sniper.def.common.responseReturns;

import com.sniper.def.components.dao.entity.Weapon;

public class ErrorMessageDerived {
    
    public String notFoundError( Weapon weapon ){
        StringBuilder stb = new StringBuilder();
        stb.append("The row serached does not exists with given id of ");
        stb.append(weapon.getId());
        return stb.toString();
    }

    public String notFoundErrorById( Long id ){
        StringBuilder stb = new StringBuilder();
        stb.append("The row does not exists with given id of ");
        stb.append(id);
        return stb.toString();
    }

    public String conflictError(){
        return "Cat name is in use!";
    }
    
}