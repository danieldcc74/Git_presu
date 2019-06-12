package com.example.presureforms;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MenuPresupuestos extends AppCompatActivity {

    String dato0Empresa, dato1Empresa, dato3Empresa, dato4Empresa, dato5Empresa;
    String dato0c, dato1c, dato2c, dato3c, dato4c, dato5c;
    String txtNumeroFactura, txtFechaFactura;
    String txtModoPago, txtdireccionReforma, txtnombreEncargado, txtLicencia, txtprecioTrabajadores, txtNumTrabajadores, txtDiasFinalizar, txtprecioGasto, txtprecioCobrar, txtIVA;

    //textos a mostrar del cliente
    TextView txtdato, txtdato1, txtdato2, txtdato3, txtdato4, txtdato5;
    //textos a mostrar de la empresa
    TextView txtdatoEmpresa, txtdato1Empresa, txtdato3Empresa, txtdato4Empresa, txtdato5Empresa;
    //textos a mostrar del presupuesto
    TextView etxtNumeroFactura, etxtFechaFactura;
    TextView etxtdireccionReforma, etxtModoPago, etxtnombreEncargado, etxtLicencia, etxtprecioTrabajadores, etxtNumTrabajadores, etxtDiasFinalizar, etxtprecioGasto, etxtprecioCobrar, etxtIVA;


    private final static String CARPETA = "Facturas";
    private final static String FICHERO = "factura.pdf";
    private final static String ERROR = "ERROR";

    Button btnGenerar, btnCliente, btnEmpresa, btnPresupuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_presupuestos);
        this.setTitle(R.string.nameActionPrincipal);// nombre de actionBar
        // Permisos.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1000);
        }

        Bundle bundlePresupuesto = getIntent().getExtras();
        Bundle bundleEmpresa = getIntent().getExtras();

        //DECLARACION DE TEXTVIEW DEL XML DEL CLIENTE
        txtdato = (TextView) findViewById(R.id.dato);
        txtdato1 = (TextView) findViewById(R.id.dato1);
        txtdato2 = (TextView) findViewById(R.id.dato2);
        txtdato3 = (TextView) findViewById(R.id.dato3);
        txtdato4 = (TextView) findViewById(R.id.dato4);
        txtdato5 = (TextView) findViewById(R.id.dato5);

        //DECLARACION DE TEXTVIEW DEL XML DE LA EMPRESA
        txtdatoEmpresa = (TextView) findViewById(R.id.datoEmpresa);
        txtdato1Empresa = (TextView) findViewById(R.id.dato1Empresa);
        txtdato3Empresa = (TextView) findViewById(R.id.dato3Empresa);
        txtdato4Empresa = (TextView) findViewById(R.id.dato4Empresa);
        txtdato5Empresa = (TextView) findViewById(R.id.dato5Empresa);

        //DECLARACION DE TEXTVIEW DEL XML DEL PRESUPUESTO
        etxtNumeroFactura = (TextView) findViewById(R.id.facturaM);

        etxtFechaFactura = (TextView) findViewById(R.id.fechaM);
        etxtdireccionReforma = (TextView) findViewById(R.id.direccionM);
        etxtnombreEncargado = (TextView) findViewById(R.id.encargadoM);
        etxtModoPago = (TextView) findViewById(R.id.modoPagoM);
        etxtLicencia = (TextView) findViewById(R.id.licenciaM);
        etxtNumTrabajadores = (TextView) findViewById(R.id.cantidadTrabajadoresM);
        etxtprecioTrabajadores = (TextView) findViewById(R.id.precioTrabajadorDiaM);
        etxtDiasFinalizar = (TextView) findViewById(R.id.diasFinalizacionM);
        etxtprecioGasto = (TextView) findViewById(R.id.precioGastoM);
        etxtprecioCobrar = (TextView) findViewById(R.id.precioCobrarM);
        etxtIVA = (TextView) findViewById(R.id.ivaM);
/*
        // Generaremos el documento al hacer click sobre el boton.
        btnGenerar = (Button) findViewById(R.id.btn_generar_pdf);
        btnCliente = (Button) findViewById(R.id.btnRellenarCliente);
        btnEmpresa = (Button) findViewById(R.id.btnRellenarEmpresa);
        btnPresupuesto = (Button) findViewById(R.id.btnRellenaPresu);

*/
    }

    public void btnAltaCliente(View v) {

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
        Toast.makeText(this, "Se han guardado los datos del cliente", Toast.LENGTH_LONG).show();

    }

    public void btnAltaEmpresa(View v) {

        EmpresaActivity empresaActivity = new EmpresaActivity();
        BaseDeDatos dbEmpresa = new BaseDeDatos(this, "Empresa", null, 1);
        SQLiteDatabase empresaDataBase = dbEmpresa.getWritableDatabase();

        String idEmpresaString = empresaActivity.idEmpresa.getText().toString();
        String nameEmpresaString = empresaActivity.nameEmpresa.getText().toString();
        String domEmpresaString = empresaActivity.domEmpresa.getText().toString();
        String loEmpresaString = empresaActivity.loEmpresa.getText().toString();
        String cpEmpresaString = empresaActivity.cpEmpresa.getText().toString();
        String telefonoEmpresaString = empresaActivity.telefonoEmpresa.getText().toString();
        String emailempresaString = empresaActivity.emailEmpresa.getText().toString();


        ContentValues registroEmpresa = new ContentValues();

        registroEmpresa.put("dniEmpresa", idEmpresaString);
        registroEmpresa.put("nombreEmpresa", nameEmpresaString);
        registroEmpresa.put("domicilioEmpresa", domEmpresaString);
        registroEmpresa.put("localidadEmpresa", loEmpresaString);
        registroEmpresa.put("codigoPostalEmpresa", cpEmpresaString);
        registroEmpresa.put("telefonoEmpresa", telefonoEmpresaString);
        registroEmpresa.put("emailEmpresa", emailempresaString);


        empresaDataBase.insert("tablaEmpresa", null, registroEmpresa);

        empresaActivity.idEmpresa.setText("");
        empresaActivity.nameEmpresa.setText("");
        empresaActivity.domEmpresa.setText("");
        empresaActivity.loEmpresa.setText("");
        empresaActivity.cpEmpresa.setText("");
        empresaActivity.telefonoEmpresa.setText("");
        empresaActivity.emailEmpresa.setText("");

        empresaDataBase.close();
        Toast.makeText(this, "Se han guardado los datos de la empresa", Toast.LENGTH_LONG).show();

    }

    public void btnAltaPresupuesto(View v) {

        PresupuestoActivity presupuestoActivity = new PresupuestoActivity();
        BaseDeDatos dbPresupuesto = new BaseDeDatos(this, "Presupuesto", null, 1);

        SQLiteDatabase presupuestoDataBase = dbPresupuesto.getWritableDatabase();

        String nFacturaString = presupuestoActivity.nfacturaPresu.getText().toString();
        String fechaFactura = presupuestoActivity.fechaPresu.getText().toString();
        String direccionReformaString = presupuestoActivity.direcionReformaPresu.getText().toString();
        String encargadoString = presupuestoActivity.encargadoPresu.getText().toString();
        String licenciaString = presupuestoActivity.licenciaPresu.getText().toString();
        String detallestrabajoString = presupuestoActivity.detallesTrabajo.getText().toString();
        String cantidadTrabajorString = presupuestoActivity.cantidadTrabajadoresPresu.getText().toString();
        String precioTrabajorString = presupuestoActivity.precioTrabajadorDiaPresu.getText().toString();
        String diasFinzalizarString = presupuestoActivity.diasFinalizacionPresu.getText().toString();
        String precioCobrarString = presupuestoActivity.precioCobrarPresu.getText().toString();
        String precioGastarString = presupuestoActivity.precioGastoPresu.getText().toString();
        String ivaString = presupuestoActivity.ivaPresu.getText().toString();


        ContentValues registroPresupuesto = new ContentValues();

        registroPresupuesto.put("numeroFactura", nFacturaString);
        registroPresupuesto.put("fechaFactura", fechaFactura);
        registroPresupuesto.put("direccionReforma", direccionReformaString);
        registroPresupuesto.put("encagado", encargadoString);
        registroPresupuesto.put("licencia", licenciaString);
        registroPresupuesto.put("detallesTrabajo", detallestrabajoString);
        registroPresupuesto.put("cantidadTrabajadores", cantidadTrabajorString);
        registroPresupuesto.put("precioTrabajador", precioTrabajorString);
        registroPresupuesto.put("diasFinalizacion", diasFinzalizarString);
        registroPresupuesto.put("precioCobrar", precioCobrarString);
        registroPresupuesto.put("precioGastar", precioGastarString);
        registroPresupuesto.put("iva", ivaString);


        presupuestoDataBase.insert("tablaPresupuesto", null, registroPresupuesto);

        presupuestoActivity.nfacturaPresu.setText("");
        presupuestoActivity.fechaPresu.setText("");
        presupuestoActivity.direcionReformaPresu.setText("");
        presupuestoActivity.encargadoPresu.setText("");
        presupuestoActivity.licenciaPresu.setText("");
        presupuestoActivity.detallesTrabajo.setText("");
        presupuestoActivity.cantidadTrabajadoresPresu.setText("");
        presupuestoActivity.precioTrabajadorDiaPresu.setText("");
        presupuestoActivity.diasFinalizacionPresu.setText("");
        presupuestoActivity.precioGastoPresu.setText("");
        presupuestoActivity.precioCobrarPresu.setText("");
        presupuestoActivity.ivaPresu.setText("");


        presupuestoDataBase.close();
        Toast.makeText(this, "Se han guardado los datos del presupuesto", Toast.LENGTH_LONG).show();

    }

    public void btnMostrarDatos(View v) {
        ClienteActivity mostrarCliente = new ClienteActivity();
        BaseDeDatos consultarCliente = new BaseDeDatos(this, "cliente", null, 1);
        SQLiteDatabase bd = consultarCliente.getReadableDatabase();

/*
        String idClienteString = mostrarCliente.idCliente.getText().toString();
        String nameClienteString = mostrarCliente.nameCliente.getText().toString();
        String lastNamecliente = mostrarCliente.lastnameCliente.getText().toString();
        String domClienteString = mostrarCliente.domCliente.getText().toString();
        String loClienteString = mostrarCliente.loCliente.getText().toString();
        String cpClienteString = mostrarCliente.cpCliente.getText().toString();
        String telefonoClienteString = mostrarCliente.tflCliente.getText().toString();
        String emailClienteString = mostrarCliente.emailCliente.getText().toString();
*/
        Cursor filaCliente = bd.rawQuery("select *from cliente", null);
        if (filaCliente.moveToFirst()) {

            txtdato.setText(filaCliente.getString(0));
            txtdato1.setText(filaCliente.getString(1));
            txtdato2.setText(filaCliente.getString(2));
            txtdato3.setText(filaCliente.getString(3));
            txtdato4.setText(filaCliente.getString(4));
            txtdato5.setText(filaCliente.getString(5));

        } else {
            Toast.makeText(this, "No has rellenado los datos cliente", Toast.LENGTH_LONG).show();
        }
    }


    public void generarPdf() {

        // Creamos el documento.
        Document documento = new Document();

        try {

            File f = crearFichero(FICHERO);

            // Creamos el flujo de datos de salida para el fichero donde
            // guardaremos el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream(
                    f.getAbsolutePath());

            // Asociamos el flujo que acabamos de crear al documento.
            PdfWriter escribir = PdfWriter.getInstance(documento, ficheroPdf);

            // Abrimos el documento.
            documento.open();

            // Añadimos un titulo con la fuente por defecto.

            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20,
                    Font.BOLD);


            PdfPTable tablaCabeceraEmpresa = new PdfPTable(1);


            tablaCabeceraEmpresa.addCell("NIF/DNI/CIF: " + dato0Empresa);
            tablaCabeceraEmpresa.addCell("Nombre empresa o particular: " + dato1Empresa);
            tablaCabeceraEmpresa.addCell("Domicilio: " + dato3Empresa);
            tablaCabeceraEmpresa.addCell("Localidad: " + dato4Empresa);
            tablaCabeceraEmpresa.addCell("Codigo postal: " + dato5Empresa);

//temazos que tienes puestos eh dua lipa
            PdfPTable tablaCabeceraCliente = new PdfPTable(1);

            tablaCabeceraCliente.addCell("NIF/DNI/CIF: " + dato0c);
            tablaCabeceraCliente.addCell("Nombre: " + dato1c + " " + dato2c);
            tablaCabeceraCliente.addCell("Domicilio: " + dato3c);
            tablaCabeceraCliente.addCell("Localidad: " + dato4c);
            tablaCabeceraCliente.addCell("Código postal: " + dato5c);
            tablaCabeceraCliente.setSpacingAfter(10);
            tablaCabeceraCliente.setSpacingBefore(10);


//y donde metes el presupuesto en el codigo donde generas la factura donde estan los detalles del presupuesto
            PdfPTable tablaPrincipal = new PdfPTable(1);
            tablaPrincipal.setSpacingAfter(10);


            PdfPTable celdatotalObra = new PdfPTable(1);

            double precioObra = Double.parseDouble(txtprecioCobrar);
            double ivaObra = Double.parseDouble(txtIVA);
            //
            double totalIVa = precioObra * ivaObra / 100;
            double totalNeto = precioObra + totalIVa;
            String totalnetoString = String.valueOf(totalNeto);
            celdatotalObra.addCell(txtdireccionReforma);
            celdatotalObra.addCell("Total Bruto: " + txtprecioCobrar);
            celdatotalObra.addCell("IVA " + txtIVA + ": " + totalIVa);
            celdatotalObra.addCell("Total Neto:" + totalNeto);

            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));

            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(1);
            tablaPrincipal.addCell(celdaFinal);

            documento.add(new Phrase("DATOS EMPRESA"));
            documento.add(tablaCabeceraEmpresa);
            documento.add(new Phrase("DATOS CLIENTE"));
            documento.add(tablaCabeceraCliente);
            documento.add(new Paragraph("DETALLES DEL TRABAJO", font));
            documento.add(tablaPrincipal);
            documento.add(celdaFinal);


            documento.close();

            // Agregar marca de agua
            /*font = FontFactory.getFont(FontFactory.HELVETICA, 42, Font.BOLD,
                    Color.GRAY);
            ColumnText.showTextAligned(escribir.getDirectContentUnder(),
                    Element.ALIGN_CENTER, new Paragraph(
                            "", font), 297.5f, 421,
                    escribir.getPageNumber() % 2 == 1 ? 45 : -45);*/

        } catch (DocumentException e) {

            Log.e(ERROR, e.getMessage());

        } catch (IOException e) {

            Log.e(ERROR, e.getMessage());

        } finally {
            // Cerramos el documento.
            documento.close();
        }
    }


    public static File crearFichero(String nombreFichero) throws IOException {
        File ruta = getRuta();
        File fichero = null;
        if (ruta != null)
            fichero = new File(ruta, nombreFichero);
        return fichero;
    }

    public static File getRuta() {

        // El fichero sera almacenado en un directorio dentro del directorio
        // Descargas
        File ruta = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            ruta = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    CARPETA);

            if (ruta != null) {
                if (!ruta.mkdirs()) {
                    if (!ruta.exists()) {
                        return null;
                    }
                }
            }
        } else {
        }

        return ruta;
    }

}