package com.example.debate.Fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import  androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import  androidx.fragment.app.Fragment;


import com.example.debate.R;

public class MainFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment,container,false);

    }

}
