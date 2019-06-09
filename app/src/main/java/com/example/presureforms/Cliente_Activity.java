package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cliente_Activity extends AppCompatActivity {


    Button btnIrClienteAPresupuesto;

    String textIDCliente, textNameCliente, textLastnameCliente, textDomCliente, textLoCliente, textCpCliente;
    EditText idCliente, nameCliente, lastnameCliente, domCliente, loCliente, cpCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Button btnIrClienteAPresupuesto = findViewById(R.id.btnSiguienteAlPresupuesto);
        idCliente = (EditText) findViewById(R.id.identificacionCliente);
        nameCliente = (EditText) findViewById(R.id.nombreCliente);
        lastnameCliente = (EditText) findViewById(R.id.apellidosCliente);
        domCliente = (EditText) findViewById(R.id.domicilioCliente);
        loCliente = (EditText) findViewById(R.id.localidadCliente);
        cpCliente = (EditText) findViewById(R.id.codigoPostalCliente);
        btnIrClienteAPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(Cliente_Activity.this, MenuPresupuestos.class);
                startActivity(siguiente);
                textIDCliente = idCliente.getText().toString();
                textNameCliente = nameCliente.getText().toString();
                textLastnameCliente = lastnameCliente.getText().toString();
                textDomCliente = domCliente.getText().toString();
                textLoCliente = loCliente.getText().toString();
                textCpCliente = cpCliente.getText().toString();

                siguiente.putExtra("dato", textIDCliente);
                siguiente.putExtra("dato1", textNameCliente);
                siguiente.putExtra("dato2", textLastnameCliente);
                siguiente.putExtra("dato3", textDomCliente);
                siguiente.putExtra("dato4", textLoCliente);
                siguiente.putExtra("dato5", textCpCliente);

                startActivity(siguiente);
            }


        });


    }


}

