package com.example.presureforms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Empresa_Activity extends AppCompatActivity {
Button btnEmpresaAlCliente;
EditText idEmpresa, nameEmpresa,lastnameEmpresa,domEmpresa,loEmpresa,cpEmpresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_);
        Button btnEmpresaAlCliente=findViewById(R.id.btnSiguienteAlCliente);
        idEmpresa=(EditText)findViewById(R.id.identificacionEmpresa);
        nameEmpresa=(EditText)findViewById(R.id.nombreEmpresa);
        lastnameEmpresa=(EditText)findViewById(R.id.apellidosEmpresa);
        domEmpresa=(EditText)findViewById(R.id.domicilioEmpresa);
        loEmpresa=(EditText)findViewById(R.id.localidadEmpresa);
        cpEmpresa=(EditText)findViewById(R.id.codigoPostalEmpresa);


        btnEmpresaAlCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente =new Intent(Empresa_Activity.this, Cliente_Activity.class);
                startActivity(siguiente);
            }
        });

    }
}
