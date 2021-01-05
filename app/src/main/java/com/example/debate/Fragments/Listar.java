package com.example.debate.Fragments;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.debate.Adaptadores.AdapterPersona;
import com.example.debate.BDSQLITE.ConexionSQLiteHelper;
import com.example.debate.ComunicaFragment;
import com.example.debate.Entidades.Persona;
import com.example.debate.R;

import java.util.ArrayList;

import static com.example.debate.Utilidades.Utilidades.TABLA_USUARIO;


public class Listar extends Fragment {
    AdapterPersona adapterPersona;
    RecyclerView recyclerViewPersonas;//referencia a recyclerview
    ArrayList<Persona>listapersonas;
    ConexionSQLiteHelper conn;//instancia a la bd
    //referencias para comunicar fragments
    Activity activividad;
    ComunicaFragment comunicaFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_listar, container, false);
        recyclerViewPersonas=(RecyclerView)view.findViewById(R.id.recyclerView);
        //recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        listapersonas=new ArrayList<>();
        //cargar lista
        cargarLista();
        //mostrar lista
        mostrar();

        //conn=new ConexionSQLiteHelper(getActivity(),"bd_usuarios",null,1);
        //consultarListaPersonas();
        return view;
    }
    public void cargarLista(){
        listapersonas.add(new Persona("Mauricio","","PSU 2020: el show decadente de una prueba rendida bajo el garrote de Cubillos","Crítica al gobierno por haber seguido adelante con el proceso de selección universitaria a pesar de estar en medio de una crisis social y por hacer vivir ese momento de incomodidad y humillación a los estudiantes. Quedará el recuerdo para siempre."));
        listapersonas.add(new Persona("Javier","","Por una “escuela con vivencia” para un mundo en el que no dé vergüenza vivir","Cuestionamiento al programa “convive en la escuela” del MINEDUC por estar descontextualizado de la realidad. Este proyecto plantea los espacios educativos como neutros y sin violencia, para mejorar la disciplina en los colegios. En la realidad, plantea el texto, la educación de Chile está inserta dentro de otras violencias estructurales y no considera las historias personales de los/as estudiantes."));

    }
    public void mostrar(){
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersona=new AdapterPersona(getContext(),listapersonas);
        recyclerViewPersonas.setAdapter(adapterPersona);
        adapterPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicaFragment.enviarPersona(listapersonas.get(recyclerViewPersonas.getChildAdapterPosition(v)));// envia todo el objeto

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {//establece comunicación entre las lista/fragment y el fragement Debatir
        super.onAttach(context);
        if(context instanceof Activity){// si el contexto que llega es una instancia de un activity
                this.activividad=(Activity)context;
                comunicaFragment=(ComunicaFragment)this.activividad;

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}



