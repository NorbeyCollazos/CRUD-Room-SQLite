package com.ncrdesarrollo.registrousuariosroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuarios {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "nombre")
    public String nombre;
    @ColumnInfo(name = "apellidos")
    public String apellidos;
    @ColumnInfo(name = "direccion")
    public String direccion;

    public Usuarios() {
    }

    //se crear el constructor
    public Usuarios(String nombre, String apellidos, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    //se crean los get y set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
