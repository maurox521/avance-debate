package com.example.debate.Entidades;

import java.io.Serializable;

public class Persona implements Serializable {
//Serializable permite enviar un objeto
    private String Nombre;
    private String Alias;
    private String Titulo;
    private String Argumento;

    public Persona(String nombre,String alias,String titulo,String argumento) {

        this.Nombre = nombre;
        this.Alias=alias;
        this.Titulo=titulo;
        this.Argumento=argumento;
    }
    public Persona (){

    }

    public String getNombre() {

        return Nombre;
    }

    public void setNombre(String nombre) {

        Nombre = nombre;
    }

    public String getTitulo() {

        return Titulo;
    }
    public void setTitulo(String titulo) {

        Titulo = titulo;
    }


    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getArgumento() {
        return Argumento;
    }

    public void setArgumento(String argumento) {
        Argumento = argumento;
    }
}
