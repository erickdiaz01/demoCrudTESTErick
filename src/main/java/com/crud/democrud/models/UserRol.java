package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name= "roles")
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long idRol;

    @ManyToOne(fetch = FetchType.LAZY , targetEntity = UsuarioModel.class , cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_rol")
    @JsonBackReference
    private UsuarioModel id_rol;
    @Column(name = "rol" , length = 30 , nullable = false )
    private String rol;

    public UserRol(UsuarioModel id_rol,String rol){
        this.id_rol=id_rol;
        this.rol=rol;
    }
public UserRol(){

}

    public Long getId() {
        return this.idRol;
    }

    public void setId(Long id) {
        this.idRol = id;
    }
    public UsuarioModel getId_rol() {
        return id_rol;
    }

    public void setId_rol(UsuarioModel id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}
