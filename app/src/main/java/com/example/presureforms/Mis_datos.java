package com.example.presureforms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Mis_datos extends AppCompatActivity {
ImageButton btn_imagen_help;
Button btn_volver_Mis_datos, btn_guardar_datos;
    EditText mis_datos_nombre, mis_datos_apellidos, mis_datos_id_empresa, mis_datos_nombre_empresa, mis_datos_direc_empresa, mis_datos_cod_postal_empresa, mis_datos_poblacion_empresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_datos);

        mis_datos_nombre = (EditText)findViewById(R.id.misDatos_nombre);
        mis_datos_apellidos = (EditText)findViewById(R.id.misDatos_apellidos);
        mis_datos_id_empresa = (EditText)findViewById(R.id.misDatos_id_empresa);
        mis_datos_nombre_empresa = (EditText)findViewById(R.id.misDatos_nombre_empresa);
        mis_datos_direc_empresa = (EditText)findViewById(R.id.misDatos_direccion_empresa);
        mis_datos_cod_postal_empresa = (EditText)findViewById(R.id.misDatos_cp_empresa);
        mis_datos_poblacion_empresa = (EditText)findViewById(R.id.misDatos_poblacion_empresa);

        btn_imagen_help = (ImageButton)findViewById(R.id.btn_ayuda);

        btn_imagen_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mis_datos.this, "Si no realiza ningun cambio pulse en VOLVER", Toast.LENGTH_SHORT).show();
                mis_datos_apellidos.setText("Prueba");
            }
        });

    }
}
