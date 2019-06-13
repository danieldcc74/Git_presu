package com.example.presureforms;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.presureforms.MenuPresupuestos.*;

public class ClienteActivity extends AppCompatActivity {
    Button btnIrClienteAPresupuesto;
    EditText idCliente, nameCliente, lastnameCliente, domCliente, loCliente, cpCliente, tflCliente, emailCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle(R.string.nameActionCliente);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycliente);

        Button btnIrClienteAPresupuesto = findViewById(R.id.btnSiguienteAlPresupuesto);

        idCliente = (EditText) findViewById(R.id.identificacionCliente);
        nameCliente = (EditText) findViewById(R.id.nombreCliente);
        lastnameCliente = (EditText) findViewById(R.id.apellidosCliente);
        domCliente = (EditText) findViewById(R.id.domicilioCliente);
        loCliente = (EditText) findViewById(R.id.localidadCliente);
        cpCliente = (EditText) findViewById(R.id.codigoPostalCliente);
        tflCliente = (EditText) findViewById(R.id.telefonoCliente);
        emailCliente = (EditText) findViewById(R.id.correoCliente);

        btnIrClienteAPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dato0c = idCliente.getText().toString();
                dato1c = nameCliente.getText().toString();
                dato2c = lastnameCliente.getText().toString();
                dato3c = domCliente.getText().toString();
                dato4c = loCliente.getText().toString();
                dato5c = cpCliente.getText().toString();
                dato6c = tflCliente.getText().toString();
                dato7c = emailCliente.getText().toString();
                Intent siguiente = new Intent(ClienteActivity.this, MenuPresupuestos.class);
                Toast.makeText(ClienteActivity.this, "Se han guardado los datos del cliente", Toast.LENGTH_SHORT).show();
                startActivity(siguiente);
            }


        });
    }
}


