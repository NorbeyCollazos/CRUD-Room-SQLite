package com.ncrdesarrollo.registrousuariosroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuariosActivity extends AppCompatActivity {

    RecyclerView recycler;
    List<Usuarios> arrayList;
    UsuariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        AppDatabase db = Room.databaseBuilder(ListaUsuariosActivity.this,
                AppDatabase.class, "dbusuarios").allowMainThreadQueries().build();

        arrayList = db.usuariosDao().getAll();

        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);

        adapter = new UsuariosAdapter(this,arrayList);


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = arrayList.get(recycler.getChildAdapterPosition(v)).getId();
                Intent intent = new Intent(ListaUsuariosActivity.this, DetalleUsuarioActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        recycler.setAdapter(adapter);

    }
}