package com.example.debate.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.example.debate.R;


public class Listar extends Fragment {
    RecyclerView recyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_listar, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);



        return view;
    }
}