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
    ArrayList<Persona>personas=new ArrayList<>();
    LayoutInflater layoutInflater;
    //listener:
    private View.OnClickListener listener;
    public AdapterPersona(Context contexto,ArrayList<Persona>personas){
        this.layoutInflater=LayoutInflater.from(contexto);
        this.personas=personas;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//esto funciona igual que una vista como el de los otros metodos
        View view=layoutInflater.inflate(R.layout.lista_personas,parent,false);    //inflo el layout de la lista
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //obtengo nombre y titulo de la posicion
        String Nombre=personas.get(position).getNombre();
        String Titulo=personas.get(position).getTitulo();
        //establesco los valores del nombre y título
        holder.Nombre.setText(Nombre);
        holder.Titulo.setText(Titulo);


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
        TextView Nombre,Titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre=itemView.findViewById(R.id.persona);
            Titulo=itemView.findViewById(R.id.titulo);
        }
    }

}
