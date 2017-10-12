package com.example.mdpt.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mdpt.sqlite.utilidades.utilidades;

/**
 * Created by MDPT on 11/10/2017.
 */

public class Consultar extends AppCompatActivity {

    EditText c_Id, c_Nombre, c_Correo;
    ConexioSqliteHelper conx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        conx =new ConexioSqliteHelper(getApplicationContext(),"bd_contactos",null,1);

        c_Id=(EditText) findViewById(R.id.c_Id);
        c_Nombre =(EditText) findViewById(R.id.c_Nombre);
        c_Correo = (EditText) findViewById(R.id.c_correo);
        //c_Correo = (EditText) findViewById(R.id.c_CorreoConsulta);

    }
    public void onClick(View view){
        //Intent miIntent = null;
        switch (view.getId()){
            case R.id.btn_buscar:
                //miIntent = new Intent(Consultar.this, Consultar.class);
                consultar();
                break;
            case R.id.btn_actualizar:
                actualizar();
                break;
            case R.id.btn_eliminar:
                eliminar();
                break;
        }
    }

    private void eliminar() {
        SQLiteDatabase db = conx.getWritableDatabase();
        String[] parametros = {c_Id.getText().toString()};

        db.delete(utilidades.TABLA_CONTACTO,utilidades.C_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Eliminao",Toast.LENGTH_SHORT).show();
        c_Id.setText("");
        limpiar();
        db.close();
    }

    private void actualizar() {
        c_Nombre =(EditText) findViewById(R.id.c_Nombre);

        SQLiteDatabase db = conx.getWritableDatabase();
        String[] parametros = {c_Id.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(utilidades.C_NOMBRE,c_Nombre.getText().toString());
        values.put(utilidades.C_CORREO,c_Correo.getText().toString());

        db.update(utilidades.TABLA_CONTACTO,values,utilidades.C_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Actualizado",Toast.LENGTH_SHORT).show();
        db.close();

    }

    private void consultar() {
        SQLiteDatabase db = conx.getReadableDatabase();
        String[] parametros = {c_Id.getText().toString()};
        String[] campos = {utilidades.C_NOMBRE,utilidades.C_CORREO};

        try {
            Cursor cursor = db.query(utilidades.TABLA_CONTACTO,campos,utilidades.C_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            c_Nombre.setText(cursor.getString(0));
            c_Correo.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"NO existe", Toast.LENGTH_LONG).show();
            limpiar();

        }


    }

    private void limpiar() {
        c_Nombre.setText("");
        c_Correo.setText("");
    }
}