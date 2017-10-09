package com.example.mdpt.apppermisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button PerimsoLocalizacion,PermisoAudio;
    private final int LOCATION_REQUEST_CODE=3;
    private final int AUDIO_REQUEST_CODE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PerimsoLocalizacion= (Button) findViewById(R.id.PermisoLocalizacion);
        PermisoAudio = (Button) findViewById(R.id.PermisoAudio);
        PerimsoLocalizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermision(Manifest.permission.ACCESS_FINE_LOCATION,LOCATION_REQUEST_CODE);
            }
        });
        PermisoAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermision(Manifest.permission.RECORD_AUDIO,AUDIO_REQUEST_CODE);
            }
        });
    }

    private void askPermision(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
            //sin permiso
            ActivityCompat.requestPermissions(this,new String[]{permission},requestCode);
        }else{
            Toast.makeText(this,"Permiso Concedido", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        switch (requestCode){
            case LOCATION_REQUEST_CODE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permiso Localizacion Concedido", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Permiso Localizacion Denegado", Toast.LENGTH_SHORT).show();
                }break;
            case AUDIO_REQUEST_CODE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permiso Audio OK", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Permiso Audio Nel", Toast.LENGTH_SHORT).show();
                }break;

        }
    }
}
