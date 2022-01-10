package com.ncrdesarrollo.registrousuariosroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.viewHolder> implements View.OnClickListener {

    Context context;
    List<Usuarios> arrayList;
    private View.OnClickListener listener;

    public UsuariosAdapter(Context context, List<Usuarios> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_usuarios, parent, false);
        view.setOnClickListener(this);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Usuarios usuario = arrayList.get(position);
        holder.tvNombre.setText(usuario.nombre+" "+usuario.apellidos);
        holder.tvDireccion.setText(usuario.direccion);
        /*holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        TextView tvDireccion;
        View view;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            view = itemView;

        }
    }
}
