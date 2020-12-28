package com.example.debate.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.example.debate.Adaptadores.AdapterPersona;
import com.example.debate.Entidades.Persona;
import com.example.debate.R;

import java.util.ArrayList;


public class Listar extends Fragment {
    AdapterPersona adapterPersona;
    RecyclerView recyclerViewPersonas;
    ArrayList<Persona>listapersonas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_listar, container, false);
        recyclerViewPersonas=(RecyclerView)view.findViewById(R.id.recyclerView);
        listapersonas=new ArrayList<>();
        Bundle args = getArguments();
        if (args  != null) {
            String nombre = args.getString("Nombre");
            listapersonas.add(new Persona(nombre, "sdasdsadsad"));
            mostrarData();
        }
        return view;
    }
    public void mostrarData(){
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersona=new AdapterPersona(getContext(),listapersonas);
        recyclerViewPersonas.setAdapter(adapterPersona);
    }
}


