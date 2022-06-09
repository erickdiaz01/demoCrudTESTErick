package com.crud.democrud.services;

import com.crud.democrud.models.UserRol;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RolServices {
    @Autowired
    private RolRepository rolRepository;


    public UserRol saveRol(UserRol rol){
        return (UserRol) rolRepository.save(rol);
    }

    public List<UserRol> listaRol(){
        return (List<UserRol>) this.rolRepository.findAll();
    }

    public Optional<UserRol> obtenerPorId(Long id){
        return this.rolRepository.findById(id);
    }


    public UserRol actualizarRol(UserRol rol , Long id){
        rol.setId(id);
        return (UserRol) this.rolRepository.save(rol);
    }


    public boolean eliminarRol(Long id){
        try {
            this.rolRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
