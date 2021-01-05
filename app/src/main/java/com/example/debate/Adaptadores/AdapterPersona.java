package com.example.debate.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.debate.Entidades.Persona;
import com.example.debate.R;

import java.util.ArrayList;

public class AdapterPersona extends RecyclerView.Adapter<AdapterPersona.ViewHolder> implements View.OnClickListener {
    ArrayList<Persona>personas;
    LayoutInflater layoutInflater;
    //listener:
    private View.OnClickListener listener;
    public AdapterPersona(Context contexto,ArrayList<Persona>personas){
        this.layoutInflater=LayoutInflater.from(contexto);
        this.personas=personas;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.lista_personas,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       //obtengo nombre y titulo de la posicion
       // Integer ID=personas.get(position).getId();
        String nombre=personas.get(position).getNombre();
        String alias=personas.get(position).getAlias();
        String titulo=personas.get(position).getTitulo();
        String argumento=personas.get(position).getArgumento();
        //establesco los valores del nombre y título
        //holder.id.setText(ID);
        holder.Nombre.setText(nombre);
        holder.Alias.setText(alias);
        holder.Titulo.setText(titulo);
        holder.Argumento.setText(argumento);





    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }

    @Override
    public int getItemCount() {//retorna el tamaño de la lista

        return personas.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //se referencian las vistas
        TextView id,Nombre,Alias,Titulo,Argumento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //id=itemView.findViewById(R.id.idpersona);
            Nombre=itemView.findViewById(R.id.persona);
            Alias=itemView.findViewById(R.id.alias);
            Titulo=itemView.findViewById(R.id.titulo);
            Argumento=itemView.findViewById(R.id.argumento);
        }
    }

}
