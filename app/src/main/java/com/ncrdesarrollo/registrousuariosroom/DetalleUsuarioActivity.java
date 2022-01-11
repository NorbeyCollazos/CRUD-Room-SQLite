package com.ncrdesarrollo.registrousuariosroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleUsuarioActivity extends AppCompatActivity {

    private int id;
    private TextView tvNombre;
    private TextView tvApellidos;
    private TextView tvDireccion;
    private Button btnEditar;
    private Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        //se obtiene el id que le pasamos de la lista
        if (getIntent() != null) {
            id = getIntent().getIntExtra("id", 0);
        }

        //se realiza la consulta a la base de datos
        AppDatabase db = AppDatabase.getInstance(DetalleUsuarioActivity.this);

        Usuarios usuario = db.usuariosDao().findById(id);
        String nombre = usuario.getNombre();
        String apellidos = usuario.getApellidos();
        String direccion = usuario.getDireccion();

        //instanciando las vistas
        tvNombre = findViewById(R.id.tvNombre);
        tvApellidos = findViewById(R.id.tvApellidos);
        tvDireccion = findViewById(R.id.tvDireccion);

        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);

        //mostrar los datos en los textview
        tvNombre.setText(nombre);
        tvApellidos.setText(apellidos);
        tvDireccion.setText(direccion);

        //colocamos los eventos clic a los botones
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleUsuarioActivity.this, EditarUsuarioActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellidos", apellidos);
                intent.putExtra("direccion", direccion);
                startActivity(intent);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios usuarios = new Usuarios();
                usuarios.setId(id);
                db.usuariosDao().deleteUser(usuarios);
                Toast.makeText(DetalleUsuarioActivity.this, "Se eliminó el usuario", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetalleUsuarioActivity.this, ListaUsuariosActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
}