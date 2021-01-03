package com.example.debate.Fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.debate.BDSQLITE.ConexionSQLiteHelper;
import com.example.debate.R;
import com.example.debate.Utilidades.Utilidades;

import static com.example.debate.Utilidades.Utilidades.CAMPO_ALIAS;
import static com.example.debate.Utilidades.Utilidades.CAMPO_ARGUMENTO;
import static com.example.debate.Utilidades.Utilidades.CAMPO_NOMBRE;
import static com.example.debate.Utilidades.Utilidades.CAMPO_TITULO;


public class Generar extends Fragment {

    RecyclerView recyclerViewPersonas;
    Button boton1,boton2;
    Spinner spinner;
    EditText texto1,texto2,texto3,texto4,texto5;
    TextView textView;



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
                ConexionSQLiteHelper conn=new ConexionSQLiteHelper(getActivity(),"bd_usuarios",null,1);
                SQLiteDatabase db=conn.getWritableDatabase();
                ContentValues valor=new ContentValues();
                if(nombre.isEmpty()){
                    valor.put(CAMPO_NOMBRE,"");
                    valor.put(CAMPO_ALIAS,alias);
                    valor.put(CAMPO_TITULO,titulo);
                    valor.put(CAMPO_ARGUMENTO,argu);

                }
                else{
                    valor.put(CAMPO_NOMBRE,nombre);
                    valor.put(CAMPO_ALIAS,"");
                    valor.put(CAMPO_TITULO,titulo);
                    valor.put(CAMPO_ARGUMENTO,argu);
                }
                Long idresultante=db.insert(Utilidades.TABLA_USUARIO,null, valor);
                Toast.makeText(getActivity(),"insertado en posición"+idresultante,Toast.LENGTH_SHORT).show();
                texto1.setText("");
                texto2.setText("");
                texto3.setText("");
                texto4.setText("");
                db.close();


                }



        });



        return view;
    }

}