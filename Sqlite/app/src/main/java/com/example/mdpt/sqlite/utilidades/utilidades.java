package com.example.mdpt.sqlite.utilidades;

/**
 * Created by MDPT on 10/10/2017.
 */

public class utilidades {

    //campos tabla usuario

    public static final String TABLA_CONTACTO = "contacto";
    public static final String C_ID = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_CORREO = "correo";



    public static final String CREAR_TABLA_CONTACTO = "CREATE TABLE " + TABLA_CONTACTO + "("+C_ID+" INTEGER,"+ C_NOMBRE+" TEXT,"+ C_CORREO+" TEXT)";

}
