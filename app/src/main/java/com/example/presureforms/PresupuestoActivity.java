package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.presureforms.MenuPresupuestos.*;

public class PresupuestoActivity extends AppCompatActivity {
    Button btnSiguienteGenerar;

    EditText nfacturaPresu, fechaPresu;
    EditText modoPago, direcionReformaPresu, encargadoPresu, licenciaPresu, detallesPresu, cantidadTrabajadoresPresu, precioTrabajadorDiaPresu, diasFinalizacionPresu, precioGastoPresu, precioCobrarPresu, ivaPresu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle(R.string.nameActionPresupuesto);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto_);
        btnSiguienteGenerar = (Button) findViewById(R.id.btnSiguienteDescripcion);


        nfacturaPresu = (EditText) findViewById(R.id.nFactura);
        fechaPresu = (EditText) findViewById(R.id.fechFactura);
        direcionReformaPresu = (EditText) findViewById(R.id.direccionReforma);
        encargadoPresu = (EditText) findViewById(R.id.encargado);
        licenciaPresu = (EditText) findViewById(R.id.licencia);
        modoPago = (EditText) findViewById(R.id.modoPagoE);
        detallesPresu = (EditText) findViewById(R.id.dellates);
        cantidadTrabajadoresPresu = (EditText) findViewById(R.id.cantidadTrabajadores);
        precioTrabajadorDiaPresu = (EditText) findViewById(R.id.precioTrabajadorDia);
        diasFinalizacionPresu = (EditText) findViewById(R.id.diasFinalizacion);
        precioGastoPresu = (EditText) findViewById(R.id.precioGasto);
        precioCobrarPresu = (EditText) findViewById(R.id.precioCobrar);
        ivaPresu = (EditText) findViewById(R.id.iva);


        btnSiguienteGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               txtNumeroFactura = nfacturaPresu.getText().toString();
               txtFechaFactura = fechaPresu.getText().toString();
               txtdireccionReforma = direcionReformaPresu.getText().toString();
               txtnombreEncargado = encargadoPresu.getText().toString();
               txtLicencia = licenciaPresu.getText().toString();
               txtDetalles= detallesPresu.getText().toString();
                txtNumTrabajadores = cantidadTrabajadoresPresu.getText().toString();
               txtprecioTrabajadores = precioTrabajadorDiaPresu.getText().toString();
               txtDiasFinalizar = diasFinalizacionPresu.getText().toString();
               txtprecioGasto = precioGastoPresu.getText().toString();
               txtprecioCobrar = precioCobrarPresu.getText().toString();
               txtModoPago = modoPago.getText().toString();
                txtIVA = ivaPresu.getText().toString();



                Intent siguiente = new Intent(PresupuestoActivity.this, MenuPresupuestos.class);


                startActivity(siguiente);
            }
        });


    }
}
