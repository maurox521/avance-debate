package com.example.debate.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.debate.Entidades.Persona;
import com.example.debate.R;


public class Debatir extends Fragment {

    Button boton3,boton4,boton5;
    TextView vista4,vista5,vista6,vista7,vista8,vista9;
    RadioButton radio1,radio2;
    EditText texto1,texto2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.debatir, container, false);
        boton3=view.findViewById(R.id.button3);
        boton4=view.findViewById(R.id.button4);
        boton5=view.findViewById(R.id.button5);
        radio1= view.findViewById(R.id.radioButton);
        radio2= view.findViewById(R.id.radioButton2);
        texto1=view.findViewById(R.id.editTextTextPersonName6);
        texto2=view.findViewById(R.id.editTextTextMultiLine3);
        vista4=view.findViewById((R.id.textView4));
        vista5=view.findViewById((R.id.textView5));
        vista6=view.findViewById((R.id.textView6));
        vista7=view.findViewById((R.id.textView7));
        vista8=view.findViewById((R.id.textView8));
        vista9=view.findViewById((R.id.textView9));
        //recibiendo objeto enviado por Bundle
        Bundle objeto=getArguments();
        Persona persona=null;
        //validando si existen argumentos enviados
        if (objeto!=null ){
            persona=(Persona)objeto.getSerializable("objeto");
            //estableciendo datos
            vista8.setText(persona.getNombre());
            vista9.setText(persona.getTitulo());
        }




        return view;
    }
}