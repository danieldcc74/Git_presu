package com.example.presureforms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {

    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tablaCliente(dniCliente text primary key,nombreCliente text,apellidosCliente text,domicilioCliente text,localidadCliente,codigopostalCliente,telefonoCliente,emailCliente)");

        db.execSQL("create table tablaEmpresa(dniEmpresa text primary key,nombreEmpresa text,domicilioEmpresa text,localidadEmpresa text,codigoPostalEmpresa text,telefonoEmpresa text,emailEmpresa text)");

        db.execSQL("create table tablaPresupuesto(numeroFactura text primary key,fechaFactura text,direccionReforma text,encagado text,licencia text,detallesTrabajo text,cantidadTrabajadores text,precioTrabajador text,diasFinalizacion text,precioCobrar text,precioGastar text,iva text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tablaCliente");
        db.execSQL("create table tablaCliente(dniCliente text primary key,nombreCliente text,apellidosCliente text,domicilioCliente text,localidadCliente,codigopostalCliente,telefonoCliente,emailCliente)");
        db.execSQL("drop table if exists tablaEmpresa");
        db.execSQL("create table tablaEmpresa(dniEmpresa text primary key,nombreEmpresa text,domicilioEmpresa text,localidadEmpresa,codigoPostalEmpresa,telefonoEmpresa,emailEmpresa)");
        db.execSQL("drop table if exists tablaPresupuesto");
        db.execSQL("create table tablaPresupuesto(numeroFactura text primary key,fechaFactura text,direccionReforma text,encagado text,licencia text,detallesTrabajo text,cantidadTrabajadores text,precioTrabajador text,diasFinalizacion text,precioCobrar text,precioGastar text,iva text)");

    }
}

/*
   Bundle bundleCliente = getIntent().getExtras();

        // Datos Empresa con recogida de bundle de la empresa
        if (bundleCliente != null) {
            dato0c = bundleCliente.getString("idCliente");
            dato1c = bundleCliente.getString("nombreCliente");
            dato2c = bundleCliente.getString("apellidosCliente");
            dato3c = bundleCliente.getString("domCliente");
            dato4c = bundleCliente.getString("loCliente");
            dato5c = bundleCliente.getString("cpCliente");
            if (txtdato == null) {
                txtdato.setText("NIF/DNI/CIF: " + dato0c);
                txtdato1.setText("Nombre: " + dato1c + "   ");
                txtdato2.setText(dato2c);
                txtdato3.setText("Domicilio: " + dato3c);
                txtdato4.setText("Localidad: " + dato4c);
                txtdato5.setText("Código postal: " + dato5c);
            }
        }
        if (bundleEmpresa != null) {

            dato0Empresa = bundleEmpresa.getString("idEmpresa");
            dato1Empresa = bundleEmpresa.getString("nameEmpresa");
            dato3Empresa = bundleEmpresa.getString("domEmpresa");
            dato4Empresa = bundleEmpresa.getString("loEmpresa");
            dato5Empresa = bundleEmpresa.getString("cpEmpresa");
            if (txtdatoEmpresa == null) {
                txtdatoEmpresa.setText("NIF/DNI/CIF: " + dato0Empresa);
                txtdato1Empresa.setText("Nombre: " + dato1Empresa);
                txtdato3Empresa.setText("Domicilio: " + dato3Empresa);
                txtdato4Empresa.setText("Localidad: " + dato4Empresa);
                txtdato5Empresa.setText("Código postal: " + dato5Empresa);
            }
        }
        if (bundlePresupuesto != null) {
            // Datos Empresa con recogida de bundle de la empresa
            txtFechaFactura = bundlePresupuesto.getString("fechaFactura");
            txtdireccionReforma = bundlePresupuesto.getString("direccionReforma");
            txtnombreEncargado = bundlePresupuesto.getString("nombreEncargado");
            txtModoPago = bundlePresupuesto.getString("modoPago");
            txtLicencia = bundlePresupuesto.getString("licencia");
            txtNumTrabajadores = bundlePresupuesto.getString("numTrabajadores");
            txtprecioTrabajadores = bundlePresupuesto.getString("precioTrabajador");
            txtDiasFinalizar = bundlePresupuesto.getString("diasFinalizacion");
            txtprecioCobrar = bundlePresupuesto.getString("precioAcobrar");
            txtprecioGasto = bundlePresupuesto.getString("precioAgastar");
            txtIVA = bundlePresupuesto.getString("iva");
            if (txtNumeroFactura ==null) {
                txtNumeroFactura = bundlePresupuesto.getString("numeroFactura");
                etxtNumeroFactura.setText("Número de factura: " + txtNumeroFactura);
                etxtFechaFactura.setText("Fecha de facturación " + txtFechaFactura);
                etxtdireccionReforma.setText("Direccion de la reforma: " + txtdireccionReforma);
                etxtnombreEncargado.setText("Nombre del encargado: " + txtnombreEncargado);
                etxtModoPago.setText("Direccion de la reforma: " + txtModoPago);
                etxtLicencia.setText("Licencia: " + txtLicencia);
                etxtNumTrabajadores.setText("Cantidad de trabajadores necesarios: " + txtNumTrabajadores);
                etxtprecioTrabajadores.setText("Precio del trabajador por dia: " + txtprecioTrabajadores);
                etxtDiasFinalizar.setText("Cantidad de dias en terminar la obra: " + txtDiasFinalizar);
                etxtprecioCobrar.setText("¿Precio a cobrar?: " + txtprecioCobrar);
                etxtprecioGasto.setText("¿Cuánto se va a invertir en la obra?: " + txtprecioGasto);
                etxtIVA.setText("Porcentaje de IVA: " + txtIVA);

            }
        }

		 btnGenerar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                generarPdf();
                Toast.makeText(MenuPresupuestos.this, "Se ha creado tu archivo pdf", Toast.LENGTH_SHORT).show();
                Toast.makeText(MenuPresupuestos.this, "Su archivo esta en la carpeta de descargas ", Toast.LENGTH_SHORT).show();

            }

        });

        btnCliente.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent clienteActivity = new Intent(MenuPresupuestos.this, ClienteActivity.class);

                startActivity(clienteActivity);


            }
        });

        btnEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent empresaActivity = new Intent(MenuPresupuestos.this, EmpresaActivity.class);

                startActivity(empresaActivity);
            }
        });
        btnPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent presuActivity = new Intent(MenuPresupuestos.this, PresupuestoActivity.class);
                startActivity(presuActivity);
            }
        });

* */