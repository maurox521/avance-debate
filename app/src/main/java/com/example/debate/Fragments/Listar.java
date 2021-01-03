package com.example.debate.Fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.debate.Adaptadores.AdapterPersona;
import com.example.debate.BDSQLITE.ConexionSQLiteHelper;
import com.example.debate.Entidades.Persona;
import com.example.debate.R;

import java.util.ArrayList;

import static com.example.debate.Utilidades.Utilidades.TABLA_USUARIO;


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
        Persona persona=null;//instancia objeto usuario
        //referencia a elemento cursor
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLA_USUARIO,null);
        //recorro los datos
        while(cursor.moveToNext()){
            persona=new Persona();
            persona.setId(cursor.getInt(0));//asigno el cursor.getInt en la posicion 0
            persona.setNombre(cursor.getString(1));
            persona.setAlias(cursor.getString(2));
            persona.setTitulo(cursor.getString(3));
            persona.setArgumento(cursor.getString(4));

        }


    }
   // public void mostrarData(){
       // recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        //adapterPersona=new AdapterPersona(getContext(),listapersonas);
    //recyclerViewPersonas.setAdapter(adapterPersona);
    //}
}


