package com.ncrdesarrollo.registrousuariosroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuarios.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuariosDao usuariosDao();
}
