package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MenuPresupuestos extends AppCompatActivity {

    Button btnActualizar, btnBorrar, btnMostrar;
    EditText buscarIdentificacion, buscarfecha, buscarNumero;
    private PrespuestoEnPdf prespuestoEnPdf;
    private String[] caberezaEmpresa = {"Hola3", "hola2", "Hola1"};
    private String shortTExt = "Hola";
    private String longText = "HOlA HOlA HOlA HOlA HOlA HOlA HOlA HOlA HOlA HOlA HOlA ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_presupuestos);

       // btnActualizar =(Button)findViewById(R.id.btnActualizarPrespuesto);

            prespuestoEnPdf = new PrespuestoEnPdf(getApplicationContext());
            prespuestoEnPdf.abrirDocumento();
            prespuestoEnPdf.crearMetadatos("Clientes", "ventas", "autor");
            prespuestoEnPdf.agregarTitulos("PRESPUESTOS", "Cliente", "daniel");
            prespuestoEnPdf.crearTabla(caberezaEmpresa, getEmpresa());
            prespuestoEnPdf.agregarParrafo(shortTExt);
            prespuestoEnPdf.agregarParrafo(longText);
            prespuestoEnPdf.cerrarDocumento();
/*
            btnActualizar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {



    }
});*/
    }

    public void visorPDF(View view) {

        prespuestoEnPdf.verPDF();

    }

    private ArrayList<String[]> getEmpresa() {
        ArrayList<String[]> filas = new ArrayList<>();

        filas.add(new String[]{"1", "apellidos", "segundo"});
        filas.add(new String[]{"1", "apellidos", "segundo"});
        filas.add(new String[]{"1", "apellidos", "segundo"});
        filas.add(new String[]{"1", "apellidos", "segundo"});
        filas.add(new String[]{"1", "apellidos", "segundo"});
        return filas;
    }
}
