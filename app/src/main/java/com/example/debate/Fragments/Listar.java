package com.example.debate.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.debate.R;

import java.util.ArrayList;


public class Listar extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_listar, container, false);
        listView=(ListView)view.findViewById(R.id.listview);
        ArrayList<String>lista=new ArrayList<>();
        lista.add("Mauricio");
        lista.add("Javier");
        lista.add("Jorge");
        lista.add("Patricia");
        ArrayAdapter adapter=new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line,lista);
        //le paso el adaptador a la lista listview
        listView.setAdapter(adapter);



        return view;
    }
}