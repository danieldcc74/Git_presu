package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ClienteActivity extends AppCompatActivity {


    public static Button btnIrClienteAPresupuesto;

    public String textIDCliente, textNameCliente, textLastnameCliente, textDomCliente, textLoCliente, textCpCliente;
    EditText idCliente, nameCliente, lastnameCliente, domCliente, loCliente, cpCliente;

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
        btnIrClienteAPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(ClienteActivity.this, MenuPresupuestos.class);
                startActivity(siguiente);

                textIDCliente = idCliente.getText().toString();
                textNameCliente = nameCliente.getText().toString();
                textLastnameCliente = lastnameCliente.getText().toString();
                textDomCliente = domCliente.getText().toString();
                textLoCliente = loCliente.getText().toString();
                textCpCliente = cpCliente.getText().toString();

                siguiente.putExtra("idCliente", textIDCliente);
                siguiente.putExtra("nombreCliente", textNameCliente);
                siguiente.putExtra("apellidosCliente", textLastnameCliente);
                siguiente.putExtra("domCliente", textDomCliente);
                siguiente.putExtra("loCliente", textLoCliente);
                siguiente.putExtra("cpCliente", textCpCliente);

                startActivity(siguiente);
            }


        });


    }


}

