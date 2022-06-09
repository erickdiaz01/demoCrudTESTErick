package com.crud.democrud.services;

import com.crud.democrud.models.UserRol;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class RolServices {
    @Autowired
    private RolRepository rolRepository;


    public UserRol saveRol(UserRol rol){
        return (UserRol) rolRepository.save(rol);
    }

    public ArrayList<UserRol> listaRol(){
        return (ArrayList<UserRol>) this.rolRepository.findAll();
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
