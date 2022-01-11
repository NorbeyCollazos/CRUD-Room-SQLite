package com.ncrdesarrollo.registrousuariosroom.repository;

import com.ncrdesarrollo.registrousuariosroom.database.entity.Usuarios;

import java.util.List;

public interface UsuarioRepository {

    List<Usuarios> getAll();
    Usuarios finById(int id);
    Usuarios findByName(String name);
    void insertUsuario(Usuarios usuarios);
    void updateUsuario(Usuarios usuarios);
    void deteleUsuario(Usuarios usuarios);

}
