package com.example.presureforms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuPresupuestos extends AppCompatActivity {

    Button btnActualizar,btnBorrar,btnMostrar;
    EditText buscarIdentificacion, buscarfecha, buscarNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_presupuestos);

        btnActualizar=(Button)findViewById(R.id.btnActualizarPrespuesto);
        btnBorrar=(Button)findViewById(R.id.btnBorrarPresupuesto);
        btnMostrar=(Button)findViewById(R.id.btnMostrarPrespuesto);

        buscarIdentificacion=(EditText)findViewById(R.id.buscarXidentificacion);
        buscarfecha=(EditText)findViewById(R.id.buscarXfecha);
        buscarNumero=(EditText)findViewById(R.id.buscarXnumero);


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
