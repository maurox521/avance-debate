package com.example.debate.BDSQLITE;

public class Usuario {
    private Integer id;
    private String nombre;
    private String alias;
    private String titulo;
    private String argumento;

    public Usuario(Integer id,String nombre,String alias,String titulo,String argumento) {
        this.id=id;
        this.nombre=nombre;
        this.alias=alias;
        this.titulo = titulo;
        this.titulo=titulo;
        this.argumento=argumento;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }
}
