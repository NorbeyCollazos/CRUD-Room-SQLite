package com.ncrdesarrollo.registrousuariosroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ncrdesarrollo.registrousuariosroom.database.dao.UsuariosDao;
import com.ncrdesarrollo.registrousuariosroom.database.entity.Usuarios;

@Database(entities = {Usuarios.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    public abstract UsuariosDao usuariosDao();

    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "dbusuarios.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
