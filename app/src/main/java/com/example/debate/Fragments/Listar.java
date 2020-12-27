package com.example.debate.Fragments;

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
        mostrarData();


        /*Persona Persona=new Persona(nombre,titulo);
        listaPersonas.add(Persona);
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));//si hubiera estado en un activity hubiera sido this,pero como estoy en un fragment es un getcontext
        adapterPersona=new AdapterPersona(getContext(),listaPersonas);
        recyclerViewPersonas.setAdapter(adapterPersona);//paso el adaptador*/
        return view;
    }
    //public void llenarlista(String nombre,String titulo){
        //listapersonas.add(new Persona(nombre,titulo));
    //}
    public void mostrarData(){
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersona=new AdapterPersona(getContext(),listapersonas);
        recyclerViewPersonas.setAdapter(adapterPersona);
    }
}