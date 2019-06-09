package com.example.presureforms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Presupuesto_Activity extends AppCompatActivity {
    String txtNumeroFactura,txtFechaFactura;
    String txtdireccionReforma,txtnombreEncargado,txtLicencia,txtNumTrabajadores,txtDiasFinalizar, txtprecioGasto,txtprecioCobrar,txtIVA;
    Button btnSiguienteGenerar;

    EditText nfacturaPresu,fechaPresu;
   EditText direcionReformaPresu,encargadoPresu,licenciaPresu,cantidadTrabajadoresPresu,precioTrabajadorDiaPresu,diasFinalizacionPresu,precioGastoPresu,precioCobrarPresu,ivaPresu ;
    Bundle bundleEmpresaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto_);
        btnSiguienteGenerar=(Button)findViewById(R.id.btnSiguienteDescripcion);
/*
        txtNumeroFactura=(TextView)findViewById(R.id.nFactura);
        txtFechaFactura=(TextView)findViewById(R.id.fechFactura);
        txtdescripcionTrabajo=(TextView)findViewById(R.id.titulodescripcion);
        txtdireccionReforma=(TextView)findViewById(R.id.direccionReforma);
        txtnombreEncargado=(TextView)findViewById(R.id.encargado);

         txtLicencia=(TextView)findViewById(R.id.licencia);
        txtNumTrabajadores=(TextView)findViewById(R.id.);*/

        nfacturaPresu=(EditText)findViewById(R.id.nFactura);
        fechaPresu=(EditText)findViewById(R.id.fechFactura);
        direcionReformaPresu=(EditText)findViewById(R.id.direccionReforma);
        encargadoPresu=(EditText)findViewById(R.id.encargado);
        licenciaPresu=(EditText)findViewById(R.id.licencia);
        cantidadTrabajadoresPresu=(EditText)findViewById(R.id.encargado);
        precioTrabajadorDiaPresu=(EditText)findViewById(R.id.precioTrabajadorDia);
        diasFinalizacionPresu=(EditText)findViewById(R.id.diasFinalizacion);
        precioGastoPresu=(EditText)findViewById(R.id.precioGasto);
        precioCobrarPresu=(EditText)findViewById(R.id.precioCobrar);
        precioGastoPresu=(EditText)findViewById(R.id.precioGasto);
        ivaPresu=(EditText)findViewById(R.id.iva);


        btnSiguienteGenerar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent siguiente = new Intent(Presupuesto_Activity.this, MenuPresupuestos.class);
        startActivity(siguiente);

        txtNumeroFactura= nfacturaPresu.getText().toString();
        txtFechaFactura= fechaPresu.getText().toString();
        txtdireccionReforma= direcionReformaPresu.getText().toString();
        txtnombreEncargado= encargadoPresu.getText().toString();
        txtLicencia= licenciaPresu.getText().toString();

        txtNumTrabajadores= cantidadTrabajadoresPresu.getText().toString();
        txtDiasFinalizar= diasFinalizacionPresu.getText().toString();
        txtprecioGasto= precioGastoPresu.getText().toString();
        txtprecioCobrar= precioCobrarPresu.getText().toString();
        txtIVA= ivaPresu.getText().toString();


        siguiente.putExtra("numeroFactura", txtNumeroFactura);
        siguiente.putExtra("fechaFactura", txtFechaFactura);
        siguiente.putExtra("direccionReforma", txtdireccionReforma);
        siguiente.putExtra("nombreEncargado", txtnombreEncargado);
        siguiente.putExtra("modoPago", txtnombreEncargado);
        siguiente.putExtra("licencia", txtLicencia);
        siguiente.putExtra("numTrabajadores", txtNumTrabajadores);
        siguiente.putExtra("precioTrabajador", txtNumTrabajadores);
        siguiente.putExtra("diasFinalizacion", txtDiasFinalizar);
        siguiente.putExtra("precioAgastar", txtprecioGasto);
        siguiente.putExtra("precioAcobrar", txtprecioCobrar);
        siguiente.putExtra("iva", txtIVA);

        startActivity(siguiente);
    }
});


    }
}
