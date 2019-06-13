package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.presureforms.MenuPresupuestos.*;


public class EmpresaActivity extends AppCompatActivity {
    Button btnEmpresaAlMenu;

    EditText idEmpresa, nameEmpresa, domEmpresa, loEmpresa, cpEmpresa, telefonoEmpresa, emailEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle(R.string.nameActionEmpresa);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityempresa_);
        Button btnEmpresaAlMenu = findViewById(R.id.btnSiguienteAlCliente);

        idEmpresa = (EditText) findViewById(R.id.identificacionEmpresa);
        nameEmpresa = (EditText) findViewById(R.id.nombreEmpresa);
        domEmpresa = (EditText) findViewById(R.id.domicilioEmpresa);
        loEmpresa = (EditText) findViewById(R.id.localidadEmpresa);
        cpEmpresa = (EditText) findViewById(R.id.codigoPostalEmpresa);
        telefonoEmpresa = (EditText) findViewById(R.id.tlfEmpresa);
        emailEmpresa = (EditText) findViewById(R.id.correoEmpresa);


        btnEmpresaAlMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dato0Empresa = idEmpresa.getText().toString();
                dato1Empresa = nameEmpresa.getText().toString();
                dato3Empresa = domEmpresa.getText().toString();
                dato4Empresa = loEmpresa.getText().toString();
                dato5Empresa = cpEmpresa.getText().toString();
                dato6Empresa = telefonoEmpresa.getText().toString();
                dato7Empresa = emailEmpresa.getText().toString();

                Intent siguiente = new Intent(EmpresaActivity.this, MenuPresupuestos.class);
                Toast.makeText(EmpresaActivity.this, "Se han guardado los datos de la empresa", Toast.LENGTH_SHORT).show();

                startActivity(siguiente);

            }
        });

    }
}
