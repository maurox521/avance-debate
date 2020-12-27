package com.example.debate.Entidades;

public class Persona {
    private String Nombre;
    private String Titulo;

    public Persona(String nombre,String titulo) {
        this.Nombre = nombre;
        this.Titulo=titulo;
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

    public Persona(){

    }

}
