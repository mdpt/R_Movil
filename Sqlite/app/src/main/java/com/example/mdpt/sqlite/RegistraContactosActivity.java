package com.example.mdpt.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mdpt.sqlite.utilidades.utilidades;

/**
 * Created by MDPT on 10/10/2017.
 */

public class RegistraContactosActivity extends AppCompatActivity{

    EditText c_Id,c_Nombre,c_Correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        c_Id=(EditText) findViewById(R.id.c_Id);
        c_Nombre =(EditText) findViewById(R.id.c_Nombre);
        c_Correo = (EditText) findViewById(R.id.c_correo);
    }
    public void onClick(View view){
       // registrarContactos();
        registrarUsuariosSql();
        /*Intent miIntent = null;
        switch (view.getId()) {
            case R.id.btn_insertar:
                miIntent = new Intent(RegistraContactosActivity.this, MainActivity.class);
                break;
        }
        if (miIntent != null) {
            startActivity(miIntent);
        }*/
    }


    private void registrarUsuariosSql() {
        ConexioSqliteHelper conx = new ConexioSqliteHelper(this,"bd_contactos",null,1);
        SQLiteDatabase db= conx.getWritableDatabase();

        //insert into table
        String insert="INSERT INTO "+ utilidades.TABLA_CONTACTO+"("+utilidades.C_ID+","+ utilidades.C_NOMBRE+","+utilidades.C_CORREO+") " +
                " VALUES("+c_Id.getText().toString()+",'"+c_Nombre.getText().toString()+"','"
                +c_Correo.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Ya Stas",Toast.LENGTH_SHORT).show();
        db.close();
    }

    /*private void registrarContactos() {
        ConexioSqliteHelper conx = new ConexioSqliteHelper(this,"bd_contactos",null,1);
        SQLiteDatabase db= conx.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(utilidades.C_ID.c.getText().toString());
        values.put(utilidades.C_NOMBRE.c_.getText().toString());
        values.put(utilidades.C_CORREO..getText().toString());

        Long idResultante = db.insert(utilidades.TABLA_CONTACTO,utilidades.C_ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();*/
     }



