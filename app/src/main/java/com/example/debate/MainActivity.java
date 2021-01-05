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

import com.example.debate.BDSQLITE.ConexionSQLiteHelper;

import com.example.debate.Entidades.Persona;
import com.example.debate.Fragments.Debatir;
import com.example.debate.Fragments.Generar;
import com.example.debate.Fragments.Listar;
import com.example.debate.Fragments.MainFragment;
import com.google.android.material.navigation.NavigationView;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,ComunicaFragment{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    //variable  de fragment Debatir
    Debatir debatir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instancia a conexionsqlite que recibe los prarametros: contexto aplicación ,nombre bd,parametro,version bd
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
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

    @Override
    public void enviarPersona(Persona persona) {
        debatir=new Debatir();
        //objeto bundle sirve para transferir informacion
        Bundle bundle=new Bundle();
        //envio el objeto que esta llenado con Serializable
        bundle.putSerializable("objeto",persona);//ahora la 'clave' objeto tiene los valores del objeto persona
        debatir.setArguments(bundle);
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new Debatir());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}