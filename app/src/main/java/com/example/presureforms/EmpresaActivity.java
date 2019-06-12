package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmpresaActivity extends AppCompatActivity {
    Button btnEmpresaAlMenu;
   public static String textIDEmpresa, textNameEmpresa, textDomEmpresa, textLoEmpresa, textCpEmpresa;
    EditText idEmpresa, nameEmpresa, domEmpresa, loEmpresa, cpEmpresa, telefonoEmpresa,emailEmpresa;

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
                Intent siguiente = new Intent(EmpresaActivity.this, MenuPresupuestos.class);
                startActivity(siguiente);
                textIDEmpresa = idEmpresa.getText().toString();
                textNameEmpresa = nameEmpresa.getText().toString();
                textDomEmpresa = domEmpresa.getText().toString();
                textLoEmpresa = loEmpresa.getText().toString();
                textCpEmpresa = cpEmpresa.getText().toString();

                Bundle bundleEmpresa = new Bundle();
                siguiente.putExtra("idEmpresa", textIDEmpresa);
                siguiente.putExtra("nameEmpresa", textNameEmpresa);
                siguiente.putExtra("domEmpresa", textDomEmpresa);
                siguiente.putExtra("loEmpresa", textLoEmpresa);
                siguiente.putExtra("cpEmpresa", textCpEmpresa);


                startActivity(siguiente);

            }
        });

    }
}