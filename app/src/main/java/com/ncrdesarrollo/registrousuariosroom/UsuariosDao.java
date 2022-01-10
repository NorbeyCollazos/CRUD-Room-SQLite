package com.ncrdesarrollo.registrousuariosroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UsuariosDao {

    //consultamos todos los usuarios
    @Query("SELECT * FROM usuarios")
    List<Usuarios> getAll();

    //consultar usuario por id
    @Query("SELECT * from usuarios WHERE id = :id LIMIT 1")
    Usuarios findById(int id);

    //filtrar usuario por nombre
    @Query("SELECT * FROM usuarios WHERE nombre LIKE :nombreusuario LIMIT 1")
    Usuarios findByName(String nombreusuario);

    //para insertar usuario
    @Insert
    Long insert (Usuarios usuarios);

    //para editar usuario
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(Usuarios usuarios);

    //para eliminar usuario
    @Delete
    void deleteUser(Usuarios usuarios);
}
