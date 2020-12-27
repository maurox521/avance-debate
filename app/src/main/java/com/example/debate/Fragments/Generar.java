package com.example.debate.Fragments;

import android.os.Bundle;
import android.content.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.debate.Adaptadores.AdapterPersona;
import com.example.debate.Entidades.Persona;
import com.example.debate.R;

import java.util.ArrayList;


public class Generar extends Fragment {
    AdapterPersona adapterPersona;
    RecyclerView recyclerViewPersonas;
    Button boton1,boton2;
    Spinner spinner;
    EditText texto1,texto2,texto3,texto4,texto5;
    ArrayList<Persona> listaPersonas;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_generar, container, false);
        boton1=(Button)view.findViewById(R.id.button);
        boton2=(Button)view.findViewById(R.id.button2);
        spinner=(Spinner)view.findViewById(R.id.spinner);
        texto1=(EditText)view.findViewById(R.id.editTextTextPersonName);
        texto2=(EditText)view.findViewById(R.id.editTextTextPersonName2);
        texto3=(EditText)view.findViewById(R.id.editTextTextPersonName3);
        texto4=(EditText)view.findViewById(R.id.editTextTextMultiLine);
        recyclerViewPersonas=(RecyclerView)view.findViewById(R.id.recyclerView);
        listaPersonas=new ArrayList<>();


        //arrayadapter se utiliza para agregar los elementos del archivo de recursos (string xml) a nuestra lista (comobobox,spinner,etc)
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource (getActivity(), R.array.opciones,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);//paso/cargo los elementos de la lista del adaptador al spinner
        texto1.setEnabled(false);
        texto2.setEnabled(false);
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                String selec=spinner.getSelectedItem().toString();
                if(selec.equals("Anónimamente")){
                    texto2.setEnabled(true);
                    texto1.setEnabled(false);

                }
                else {
                    texto1.setEnabled(true);
                    texto2.setEnabled(false);


                }
            }

        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=texto1.getText().toString();
                String alias=texto2.getText().toString();
                String titulo=texto3.getText().toString();
                String argu=texto4.getText().toString();
                if ((nombre.isEmpty()||alias.isEmpty())&&titulo.isEmpty()&&argu.isEmpty()){
                    Toast.makeText(getActivity(), "Falta uno o más datos por completar", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getActivity(), "datos registrados", Toast.LENGTH_LONG).show();
                    Persona Persona=new Persona(nombre,titulo);
                    listaPersonas.add(Persona);
                    recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));//si hubiera estado en un activity hubiera sido this,pero como estoy en un fragment es un getcontext
                    adapterPersona=new AdapterPersona(getContext(),listaPersonas);
                    recyclerViewPersonas.setAdapter(adapterPersona);//paso el adaptador

                    /*if (nombre.isEmpty()){
                        //paso los nombres y titulo
                        listaPersonas.add(new Persona(alias,titulo));

                        //muestro la data
                        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));//si hubiera estado en un activity hubiera sido this,pero como estoy en un fragment es un getcontext
                        //adapterPersona=new AdapterPersona(getContext(),listaPersonas);
                        //recyclerViewPersonas.setAdapter(adapterPersona);//paso el adaptador
                    }

                    else{
                        listaPersonas.add(new Persona(nombre,titulo));
                        //recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
                        //adapterPersona=new AdapterPersona(getContext(),listaPersonas);
                        //recyclerViewPersonas.setAdapter(adapterPersona);
                    }*/

                    /*pasando datos a clase adapter datos
                    Intent intent=new Intent(getActivity(), AdapterDatos.class);
                    intent.putExtra("Valor",titulo);
                    startActivity(intent);*/


                    ///"Se limpian" los comonentes de fragment
                    texto1.setText("");
                    texto2.setText("");
                    texto3.setText("");
                    texto4.setText("");
                    }



                }



        });



        return view;
    }
}