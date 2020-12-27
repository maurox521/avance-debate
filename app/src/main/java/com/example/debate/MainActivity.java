package com.example.debate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.debate.Fragments.Generar;
import com.example.debate.Fragments.Listar;
import com.example.debate.Fragments.MainFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//paso el toolbar
        drawerLayout=findViewById(R.id.drawer);//llamo al drawer que esta dentro del activity main
        navigationView=findViewById(R.id.navigationView);
        //establecer evento onclick a navigationView
        navigationView.setNavigationItemSelectedListener(this);
        //variables para cargar el fragment principal
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        //carga el fragment principal
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new MainFragment());
        fragmentTransaction.commit();



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.Inicio){
            FragmentManager fragmentManager;
            FragmentTransaction fragmentTransaction;
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new MainFragment());
            fragmentTransaction.commit();

        }
        if (item.getItemId() == R.id.Generar){
            FragmentManager fragmentManager;
            FragmentTransaction fragmentTransaction;
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new Generar());
            fragmentTransaction.commit();
        }
        if (item.getItemId() == R.id.Buscar){
            FragmentManager fragmentManager;
            FragmentTransaction fragmentTransaction;
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new Listar());
            fragmentTransaction.commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}