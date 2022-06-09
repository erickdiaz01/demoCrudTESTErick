package com.crud.democrud.controllers;

import com.crud.democrud.models.UserRol;
import com.crud.democrud.services.RolServices;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolServices rolServices;


    private static final Logger logger = Logger.getLogger("logger");


    @GetMapping(path = "")
    public ArrayList<UserRol> listaRoles() {
        return this.rolServices.listaRol();
    }

    @GetMapping(path = "/{id}")
    public Optional<UserRol> buscarRol(@PathVariable("id") Long id){
        return this.rolServices.obtenerPorId(id);
    }

    @PostMapping(path = "")
    public UserRol guardarRol(@RequestBody UserRol roles) {
        return this.rolServices.saveRol(roles);
    }
    @RequestMapping(value = "/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public UserRol actualizarRol(@RequestBody UserRol roles , @PathVariable("id") Long id ){
        return this.rolServices.actualizarRol(roles,id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarRol(@PathVariable("id") Long id) {
        boolean ok = this.rolServices.eliminarRol(id);
        if (ok) {
            return "Registro con ID "+id + "eliminado correctamente";
        } else {
            return "Error al  eliminar el registro con ID " +id;
        }
    }
}
