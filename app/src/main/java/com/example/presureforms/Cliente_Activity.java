package com.example.presureforms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cliente_Activity extends AppCompatActivity {
Button btnIrClienteAPresupuesto;

    EditText idCliente, nameCliente,lastnameCliente,domCliente,loCliente,cpCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Button btnIrClienteAPresupuesto=findViewById(R.id.btnSiguienteAlPresupuesto);
        idCliente=(EditText)findViewById(R.id.identificacionCliente);
        nameCliente=(EditText)findViewById(R.id.nombreCliente);
        lastnameCliente=(EditText)findViewById(R.id.apellidosCliente);
        domCliente=(EditText)findViewById(R.id.domicilioCliente);
        loCliente=(EditText)findViewById(R.id.localidadCliente);
        cpCliente=(EditText)findViewById(R.id.codigoPostalCliente);

        btnIrClienteAPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente =new Intent(Cliente_Activity.this, Presupuesto_Activity.class);
                startActivity(siguiente);
            }
        });
    }
}
