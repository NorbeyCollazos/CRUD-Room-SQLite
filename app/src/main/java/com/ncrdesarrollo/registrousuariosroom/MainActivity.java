package com.ncrdesarrollo.registrousuariosroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ncrdesarrollo.registrousuariosroom.database.AppDatabase;
import com.ncrdesarrollo.registrousuariosroom.database.entity.Usuarios;
import com.ncrdesarrollo.registrousuariosroom.repository.UsuarioRepository;
import com.ncrdesarrollo.registrousuariosroom.repository.UsuarioRepositoryImpl;

public class MainActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etApellidos;
    EditText etDireccion;
    Button btnRegistrar;
    FloatingActionButton flLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etDireccion = findViewById(R.id.etDireccion);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                UsuarioRepository repository = new UsuarioRepositoryImpl(db.usuariosDao());

                String nombre = etNombre.getText().toString();
                String apellidos = etApellidos.getText().toString();
                String direccion = etDireccion.getText().toString();

                //validar campos vacios
                if (nombre.trim().isEmpty()) {
                    etNombre.setError("Ingrese el nombre");
                } else if (apellidos.trim().isEmpty()) {
                    etApellidos.setError("Ingrese el apellido");
                } else if (direccion.trim().isEmpty()) {
                    etDireccion.setError("Ingrese la dirección");
                } else {

                    //Usuarios usuarios = new Usuarios(nombre, apellidos, direccion);
                    Usuarios usuarios = new Usuarios();

                    usuarios.setNombre(nombre);
                    usuarios.setApellidos(apellidos);
                    usuarios.setDireccion(direccion);

                    repository.insertUsuario(usuarios);

                    Toast.makeText(MainActivity.this, "Se realizó el registro", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ListaUsuariosActivity.class);
                    startActivity(intent);

                }

            }
        });

        flLista = findViewById(R.id.floatingActionButton);
        flLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaUsuariosActivity.class);
                startActivity(intent);
            }
        });

    }
}