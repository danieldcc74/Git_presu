package com.example.presureforms;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClienteActivity extends AppCompatActivity {


    Button btnIrClienteAPresupuesto;

    public String textIDCliente, textNameCliente, textLastnameCliente, textDomCliente, textLoCliente, textCpCliente;
    EditText idCliente, nameCliente, lastnameCliente, domCliente, loCliente, cpCliente, tflCliente,emailCliente;

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


                ClienteActivity clienteActivity = new ClienteActivity();
                BaseDeDatos dbCliente = new BaseDeDatos(this, "Cliente", null, 1);

                SQLiteDatabase clienteDataBase = dbCliente.getWritableDatabase();

                String idClienteString = clienteActivity.idCliente.getText().toString();
                String nameClienteString = clienteActivity.nameCliente.getText().toString();
                String lastNamecliente = clienteActivity.lastnameCliente.getText().toString();
                String domClienteString = clienteActivity.domCliente.getText().toString();
                String loClienteString = clienteActivity.loCliente.getText().toString();
                String cpClienteString = clienteActivity.cpCliente.getText().toString();
                String telefonoClienteString = clienteActivity.tflCliente.getText().toString();
                String emailClienteString = clienteActivity.emailCliente.getText().toString();

                ContentValues registroCliente = new ContentValues();

                registroCliente.put("dniCliente", idClienteString);
                registroCliente.put("nombreCliente", nameClienteString);
                registroCliente.put("apellidosCliente", lastNamecliente);
                registroCliente.put("domicilioCliente", domClienteString);
                registroCliente.put("localidadCliente", loClienteString);
                registroCliente.put("codigopostalCliente", cpClienteString);
                registroCliente.put("telefonoCliente", telefonoClienteString);
                registroCliente.put("emailCliente", emailClienteString);


                clienteDataBase.insert("tablaCliente", null, registroCliente);

                clienteActivity.idCliente.setText("");
                clienteActivity.nameCliente.setText("");
                clienteActivity.lastnameCliente.setText("");
                clienteActivity.domCliente.setText("");
                clienteActivity.loCliente.setText("");
                clienteActivity.cpCliente.setText("");
                clienteActivity.tflCliente.setText("");
                clienteActivity.emailCliente.setText("");
                clienteDataBase.close();

            //  Toast.makeText(this, "Se han guardado los datos del cliente", Toast.LENGTH_LONG).show();
                //   this.finish();
/*
                Intent siguiente = new Intent(ClienteActivity.this, MenuPresupuestos.class);

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
                */
            }


        });

        }



    }


