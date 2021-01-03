package com.example.debate.Fragments;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.example.debate.Adaptadores.AdapterPersona;
import com.example.debate.BDSQLITE.ConexionSQLiteHelper;
import com.example.debate.BDSQLITE.Usuario;
import com.example.debate.Entidades.Persona;
import com.example.debate.R;

import java.util.ArrayList;


public class Listar extends Fragment {
    AdapterPersona adapterPersona;
    RecyclerView recyclerViewPersonas;//referencia a recyclerview
    ArrayList<Persona>listapersonas;
    ConexionSQLiteHelper conn;//instancia a la bd
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_listar, container, false);
        recyclerViewPersonas=(RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        listapersonas=new ArrayList<>();
        conn=new ConexionSQLiteHelper(getActivity(),"bd_usuarios",null,1);
        consultarListaPersonas();
        return view;
    }
    private void consultarListaPersonas(){
        //se abre la conexion a la bd
        SQLiteDatabase db=conn.getReadableDatabase();//con esto ya se puede leer la bd
        Usuario usuario=null;//instancia objeto usuario


    }
   // public void mostrarData(){
       // recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        //adapterPersona=new AdapterPersona(getContext(),listapersonas);
    //recyclerViewPersonas.setAdapter(adapterPersona);
    //}
}


