package com.example.presureforms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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

    private static String dato0Empresa, dato1Empresa, dato3Empresa, dato4Empresa, dato5Empresa;
    private static  String dato0c, dato1c, dato2c, dato3c, dato4c, dato5c;
    private static String txtNumeroFactura, txtFechaFactura;
    private static String txtModoPago, txtdireccionReforma, txtnombreEncargado, txtLicencia, txtprecioTrabajadores, txtNumTrabajadores, txtDiasFinalizar, txtprecioGasto, txtprecioCobrar, txtIVA;

    //textos a mostrar del cliente
    TextView txtdato, txtdato1, txtdato2, txtdato3, txtdato4, txtdato5;
    //textos a mostrar de la empresa
    TextView txtdatoEmpresa, txtdato1Empresa, txtdato3Empresa, txtdato4Empresa, txtdato5Empresa;
    //textos a mostrar del presupuesto
    TextView etxtNumeroFactura, etxtFechaFactura;
    TextView etxtdireccionReforma, etxtModoPago, etxtnombreEncargado, etxtLicencia, etxtprecioTrabajadores, etxtNumTrabajadores, etxtDiasFinalizar, etxtprecioGasto, etxtprecioCobrar, etxtIVA;


    private final static String CARPETA = "Presupuestos";
    private final static String FICHERO = "factura.pdf";
    private final static String ERROR = "ERROR";
    public static Bundle bundleCliente ;
    Button btnGenerar, btnCliente, btnEmpresa, btnPresupuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_presupuestos);
        this.setTitle(R.string.nameActionPrincipal);

        /*
        String dato0Empresa, dato1Empresa, dato3Empresa, dato4Empresa, dato5Empresa;String dato0, dato1, dato2, dato3, dato4, dato5;
        String txtNumeroFactura, txtFechaFactura;
        String txtModoPago, txtdireccionReforma, txtnombreEncargado, txtLicencia, txtprecioTrabajadores, txtNumTrabajadores, txtDiasFinalizar, txtprecioGasto, txtprecioCobrar, txtIVA;


        //Bundle bundleCliente = getIntent().getExtras();
        Bundle bundlePresupuesto = getIntent().getExtras();

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

bundleCliente = getIntent().getExtras();

        dato0c = bundleCliente.getString("idCliente");
        dato1c = bundleCliente.getString("nombreCliente");
        dato2c = bundleCliente.getString("apellidosCliente");
        dato3c = bundleCliente.getString("domCliente");
        dato4c = bundleCliente.getString("loCliente");
        dato5c = bundleCliente.getString("cpCliente");

        txtdato.setText("NIF/DNI/CIF: " + dato0c);
        txtdato1.setText("Nombre: " + dato1c + "   ");
        txtdato2.setText(dato2c);
        txtdato3.setText("Domicilio: " + dato3c);
        txtdato4.setText("Localidad: " + dato4c);
        txtdato5.setText("Código postal: " + dato5c);


        // Datos Empresa con recogida de bundle de la empresa
        dato0Empresa = bundleEmpresa.getString("idEmpresa");
        dato1Empresa = bundleEmpresa.getString("nameEmpresa");
        dato3Empresa = bundleEmpresa.getString("domEmpresa");
        dato4Empresa = bundleEmpresa.getString("loEmpresa");
        dato5Empresa = bundleEmpresa.getString("cpEmpresa");

        txtdatoEmpresa.setText("NIF/DNI/CIF: " + dato0Empresa);
        txtdato1Empresa.setText("Nombre: " + dato1Empresa);
        txtdato3Empresa.setText("Domicilio: " + dato3Empresa);
        txtdato4Empresa.setText("Localidad: " + dato4Empresa);
        txtdato5Empresa.setText("Código postal: " + dato5Empresa);


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

*/
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


            tablaCabeceraEmpresa.addCell(new Phrase("DATOS CLIENTE"));
            tablaCabeceraEmpresa.addCell("NIF/DNI/CIF: " + dato0Empresa);
            tablaCabeceraEmpresa.addCell("Nombre empresa o particular: " + dato1Empresa);
            tablaCabeceraEmpresa.addCell("Domicilio: " + dato3Empresa);
            tablaCabeceraEmpresa.addCell("Localidad: " + dato4Empresa);
            tablaCabeceraEmpresa.addCell("Codigo postal: " + dato5Empresa);

            PdfPTable tablaCabeceraCliente = new PdfPTable(1);
            tablaCabeceraCliente.addCell(new Phrase("DATOS CLIENTE"));
            tablaCabeceraCliente.addCell("NIF/DNI/CIF: " + dato0c);
            tablaCabeceraCliente.addCell("Nombre: " + dato1c + " " + dato2c);
            tablaCabeceraCliente.addCell("Domicilio: " + dato3c);
            tablaCabeceraCliente.addCell("Localidad: " + dato4c);
            tablaCabeceraCliente.addCell("Código postal: " + dato5c);
            tablaCabeceraCliente.setSpacingAfter(10);
            tablaCabeceraCliente.setSpacingBefore(10);



/*
            PdfPTable tablaPrincipal = new PdfPTable(1);
            tablaPrincipal.setSpacingAfter(10);
 documento.add(new Paragraph("DETALLES DEL TRABAJO", font));

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
*/

            documento.add(tablaCabeceraEmpresa);
            //   documento.add(tablaCabeceraCliente);
            //   documento.add(tablaPrincipal);
            //   documento.add(celdaFinal);


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