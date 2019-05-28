package com.example.presureforms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cliente_Activity extends AppCompatActivity {
Button btnIrEmpresa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Button btnIrEmpresa=findViewById(R.id.btnSiguiente);


        btnIrEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente =new Intent(Cliente_Activity.this, Empresa_Activity.class);
                startActivity(siguiente);
            }
        });
    }
}
