package com.example.presureforms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
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

    String dato0, dato1, dato2, dato3, dato4, dato5;

    String txtNumeroFactura, txtFechaFactura;
    String txtModoPago, txtdireccionReforma, txtnombreEncargado, txtLicencia, txtprecioTrabajadores, txtNumTrabajadores, txtDiasFinalizar, txtprecioGasto, txtprecioCobrar, txtIVA;


    TextView txtdato, txtdato1, txtdato2, txtdato3, txtdato4, txtdato5, datosClienteCabecera;
    TextView txtdatoEmpresa, txtdato1Empresa, txtdato2Empresa, txtdato3Empresa, txtdato4Empresa, txtdato5Empresa, datosEmpresaCabereza;
    TextView etxtNumeroFactura, etxtFechaFactura;
    TextView etxtdireccionReforma, etxtModoPago, etxtnombreEncargado, etxtLicencia, etxtprecioTrabajadores, etxtNumTrabajadores, etxtDiasFinalizar, etxtprecioGasto, etxtprecioCobrar, etxtIVA;


    private final static String CARPETA = "Presupuestos";
    private final static String FICHERO = "factura.pdf";
    private final static String ERROR = "ERROR";

    Button btnGenerar, btnCliente, btnEmpresa, btnPresupuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymenupresupuestos);

        Bundle bundleEmpresa, bundleCliente, bundlePresupuesto;
        bundleEmpresa = getIntent().getExtras();
        bundleCliente = getIntent().getExtras();
        bundlePresupuesto = getIntent().getExtras();

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


        //DECLARACION DE TEXTVIEW DEL XML DEL CLIENTE
        txtdato = (TextView) findViewById(R.id.dato);
        txtdato1 = (TextView) findViewById(R.id.dato1);
        txtdato2 = (TextView) findViewById(R.id.dato2);
        txtdato3 = (TextView) findViewById(R.id.dato3);
        txtdato4 = (TextView) findViewById(R.id.dato4);
        txtdato5 = (TextView) findViewById(R.id.dato5);
        datosClienteCabecera = (TextView) findViewById(R.id.datosClienteCabereza);


        //DECLARACION DE TEXTVIEW DEL XML DE LA EMPRESA
        txtdatoEmpresa = (TextView) findViewById(R.id.datoEmpresa);
        txtdato1Empresa = (TextView) findViewById(R.id.dato1Empresa);
        txtdato3Empresa = (TextView) findViewById(R.id.dato3Empresa);
        txtdato4Empresa = (TextView) findViewById(R.id.dato4Empresa);
        txtdato5Empresa = (TextView) findViewById(R.id.dato5Empresa);
        datosEmpresaCabereza = (TextView) findViewById(R.id.datosEmpresaCabereza);


        //DATOS CLIENTE


        dato0 = bundleCliente.getString("dato");
        txtdato.setText("NIF/DNI/CIF: " + dato0);
        dato1 = bundleCliente.getString("dato1");
        txtdato1.setText("NOMBRE: " + dato1 + "   ");
        dato2 = bundleCliente.getString("dato2");
        txtdato2.setText(dato2);
        dato3 = bundleCliente.getString("dato3");
        txtdato3.setText("DOMICILIO: " + dato3);
        dato4 = bundleCliente.getString("dato4");
        txtdato4.setText("LOCALIDAD: " + dato4);
        dato5 = bundleCliente.getString("dato5");
        txtdato5.setText("CODIGO POSTAL: " + dato5);


        //DATOS EMPRESA

        dato0Empresa = bundleEmpresa.getString("idEmpresa");
        txtdatoEmpresa.setText("NIF/DNI/CIF: " + dato0Empresa);
        dato1Empresa = bundleEmpresa.getString("nameEmpresa");
        txtdato1Empresa.setText("NOMBRE EMPRESA O PARTICULAR: " + dato1Empresa);
        dato3Empresa = bundleEmpresa.getString("domEmpresa");
        txtdato3Empresa.setText("DOMICILIO: " + dato3Empresa);
        dato4Empresa = bundleEmpresa.getString("loEmpresa");
        txtdato4Empresa.setText("LOCALIDAD: " + dato4Empresa);
        dato5Empresa = bundleEmpresa.getString("cpEmpresa");
        txtdato5.setText("CODIGO POSTAL: " + dato5Empresa);

//DATOS PRESUPUESTO

        txtNumeroFactura = bundlePresupuesto.getString("numeroFactura");
        etxtNumeroFactura.setText("Número de factura: " + txtNumeroFactura);

        txtFechaFactura = bundlePresupuesto.getString("fechaFactura");
        etxtFechaFactura.setText("Fecha de facturación " + txtFechaFactura);

        txtdireccionReforma = bundlePresupuesto.getString("direccionReforma");
        etxtdireccionReforma.setText("Direccion de la reforma: " + txtdireccionReforma);

        txtnombreEncargado = bundlePresupuesto.getString("nombreEncargado");
        etxtnombreEncargado.setText("Nombre del encargado: " + txtnombreEncargado);

        txtModoPago = bundlePresupuesto.getString("modoPago");
        etxtModoPago.setText("Direccion de la reforma: " + txtModoPago);

        txtLicencia = bundlePresupuesto.getString("licencia");
        etxtLicencia.setText("Licencia: " + txtLicencia);

        txtNumTrabajadores = bundlePresupuesto.getString("numTrabajadores");
        etxtNumTrabajadores.setText("Cantidad de trabajadores necesarios: " + txtNumTrabajadores);

        txtprecioTrabajadores = bundlePresupuesto.getString("precioTrabajador");
        etxtprecioTrabajadores.setText("Precio del trabajador por dia: " + txtprecioTrabajadores);

        txtDiasFinalizar = bundlePresupuesto.getString("diasFinalizacion");
        etxtDiasFinalizar.setText("Cantidad de dias en terminar la obra: " + txtDiasFinalizar);

        txtprecioCobrar = bundlePresupuesto.getString("precioAcobrar");
        etxtprecioCobrar.setText("¿Precio a cobrar?: " + txtprecioCobrar);

        txtprecioGasto = bundlePresupuesto.getString("precioAgastar");
        etxtprecioGasto.setText("¿Cuánto se va a invertir en la obra?: " + txtprecioGasto);

        txtIVA = bundlePresupuesto.getString("iva");
        etxtIVA.setText("Porcentaje de IVA: " + txtIVA);


        // Permisos.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1000);
        }
        // Generaremos el documento al hacer click sobre el boton.
        btnGenerar = (Button) findViewById(R.id.btn_generar_pdf);
        btnCliente = (Button) findViewById(R.id.btnRellenarCliente);
        btnEmpresa = (Button) findViewById(R.id.btnRellenarEmpresa);
        btnPresupuesto = (Button) findViewById(R.id.btnRellenaPresu);


        btnGenerar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                generarPdf();
                Toast.makeText(MenuPresupuestos.this, "Se creo tu archivo pdf", Toast.LENGTH_SHORT).show();

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
    }
//comentario nuevo

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

            tablaCabeceraEmpresa.addCell(String.valueOf(txtdatoEmpresa));
            tablaCabeceraEmpresa.addCell(String.valueOf(txtdato1Empresa));
            tablaCabeceraEmpresa.addCell(String.valueOf(txtdato2Empresa));
            tablaCabeceraEmpresa.addCell(String.valueOf(txtdato3Empresa));
            tablaCabeceraEmpresa.addCell(String.valueOf(txtdato4Empresa));
            tablaCabeceraEmpresa.addCell(String.valueOf(txtdato5Empresa));

            PdfPTable tablaCabeceraCliente = new PdfPTable(1);

            tablaCabeceraCliente.addCell(String.valueOf(dato0));
            tablaCabeceraCliente.addCell(String.valueOf(dato1));
            tablaCabeceraCliente.addCell(String.valueOf(dato2));
            tablaCabeceraCliente.addCell(String.valueOf(dato3));
            tablaCabeceraCliente.addCell(String.valueOf(dato4));
            tablaCabeceraCliente.addCell(String.valueOf(dato5));
            tablaCabeceraCliente.setSpacingAfter(10);
            tablaCabeceraCliente.setSpacingBefore(10);
            documento.add(new Paragraph("DETALLES DEL TRABAJO", font));


            PdfPTable tablaPrincipal = new PdfPTable(1);
            tablaPrincipal.setSpacingAfter(10);


            PdfPTable celdatotalObra = new PdfPTable(1);

            double precioObra = Double.parseDouble(txtprecioCobrar);
            double ivaObra = Double.parseDouble(txtIVA);
            double totalIVa = precioObra * ivaObra / 100;
            double totalNeto = precioObra + totalIVa;
            String totalnetoString = String.valueOf(totalNeto);

            celdatotalObra.addCell(txtdireccionReforma);
            celdatotalObra.addCell("Total Bruto: " + txtprecioCobrar);
            celdatotalObra.addCell("IVA: " + txtIVA + ": " + totalIVa);
            celdatotalObra.addCell("Total Neto:" + totalnetoString);

            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));

            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(1);
            tablaPrincipal.addCell(celdaFinal);


            documento.add(tablaCabeceraEmpresa);
            documento.add(tablaCabeceraCliente);
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