package com.ncrdesarrollo.registrousuariosroom.repository;

import com.ncrdesarrollo.registrousuariosroom.database.dao.UsuariosDao;
import com.ncrdesarrollo.registrousuariosroom.database.entity.Usuarios;

import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository{

    UsuariosDao dao;

    //se crea el constructor
    public UsuarioRepositoryImpl(UsuariosDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Usuarios> getAll() {
        return dao.getAll();
    }

    @Override
    public Usuarios finById(int id) {
        return dao.findById(id);
    }

    @Override
    public Usuarios findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void insertUsuario(Usuarios usuarios) {
        dao.insert(usuarios);
    }

    @Override
    public void updateUsuario(Usuarios usuarios) {
        dao.updateUser(usuarios);
    }

    @Override
    public void deteleUsuario(Usuarios usuarios) {
        dao.deleteUser(usuarios);
    }
}
