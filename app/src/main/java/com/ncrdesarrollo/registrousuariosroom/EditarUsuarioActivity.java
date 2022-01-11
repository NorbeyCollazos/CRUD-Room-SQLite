package com.ncrdesarrollo.registrousuariosroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarUsuarioActivity extends AppCompatActivity {

    private int id;
    private String nombre;
    private String apellidos;
    private String direccion;

    EditText etNombre;
    EditText etApellidos;
    EditText etDireccion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        if (getIntent() != null) {
            id = getIntent().getIntExtra("id", 0);
            nombre = getIntent().getStringExtra("nombre");
            apellidos = getIntent().getStringExtra("apellidos");
            direccion = getIntent().getStringExtra("direccion");
        }

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etDireccion = findViewById(R.id.etDireccion);
        btnEditar = findViewById(R.id.btnEditar);

        etNombre.setText(nombre);
        etApellidos.setText(apellidos);
        etDireccion.setText(direccion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    AppDatabase db = AppDatabase.getInstance(EditarUsuarioActivity.this);

                    String snombre = etNombre.getText().toString();
                    String sapellidos = etApellidos.getText().toString();
                    String sdireccion = etDireccion.getText().toString();

                    Usuarios usuarios = new Usuarios();
                    usuarios.setId(id);
                    usuarios.setNombre(snombre);
                    usuarios.setApellidos(sapellidos);
                    usuarios.setDireccion(sdireccion);

                    db.usuariosDao().updateUser(usuarios);

                    Toast.makeText(EditarUsuarioActivity.this, "Se modificó el usuario", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EditarUsuarioActivity.this, ListaUsuariosActivity.class);
                    startActivity(intent);
                    finish();



            }
        });

    }
}