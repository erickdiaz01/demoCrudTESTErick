package com.crud.democrud.repositories;


import com.crud.democrud.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;


import java.util.ArrayList;

public interface RolRepository extends CrudRepository {
    public abstract ArrayList<UsuarioModel> findByRol(String rol);
}
