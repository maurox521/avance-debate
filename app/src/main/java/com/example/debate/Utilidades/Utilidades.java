package com.example.debate.Utilidades;

public class Utilidades {
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_ALIAS="alias";
    public static final String CAMPO_TITULO="titulo";
    public static final String CAMPO_ARGUMENTO="argumento";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_ALIAS+" TEXT,"+CAMPO_TITULO+"TEXT,"+CAMPO_ARGUMENTO+ "TEXT)";
}
