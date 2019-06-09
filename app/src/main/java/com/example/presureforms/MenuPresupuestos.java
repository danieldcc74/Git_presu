package com.example.presureforms;

import android.Manifest;
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
import com.lowagie.text.*;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import harmony.java.awt.Color;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MenuPresupuestos extends AppCompatActivity {

    TextView txtdato, txtdato1, txtdato2, txtdato3, txtdato4, txtdato5,datosClienteCabecera;
    TextView txtdatoEmpresa, txtdato1Empresa, txtdato2Empresa, txtdato3Empresa, txtdato4Empresa, txtdato5Empresa,datosEmpresaCabereza;
    TextView etxtNumeroFactura,etxtFechaFactura;
    TextView etxtdireccionReforma,etxtModoPago,etxtnombreEncargado,etxtLicencia,etxtprecioTrabajadores,etxtNumTrabajadores,etxtDiasFinalizar, etxtprecioGasto,etxtprecioCobrar,etxtIVA;


    private final static String NOMBRE_DIRECTORIO = "Presupuestos";
    private final static String NOMBRE_DOCUMENTO = "factura.pdf";
    private final static String ETIQUETA_ERROR = "ERROR";
    Button btnGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_presupuestos);

        //DECLARACION DE TEXTVIEW DEL XML DEL PRESUPUESTO
        etxtNumeroFactura=(TextView)findViewById(R.id.facturaM);
       etxtFechaFactura=(TextView)findViewById(R.id.fechaM);
        etxtdireccionReforma=(TextView)findViewById(R.id.direccionM);
        etxtnombreEncargado=(TextView)findViewById(R.id.encargadoM);
        etxtModoPago=(TextView)findViewById(R.id.modoPagoM);
       etxtLicencia=(TextView)findViewById(R.id.licenciaM);
        etxtNumTrabajadores=(TextView)findViewById(R.id.cantidadTrabajadoresM);
       etxtprecioTrabajadores=(TextView)findViewById(R.id.precioTrabajadorDiaM);
        etxtDiasFinalizar=(TextView)findViewById(R.id.diasFinalizacionM);
        etxtprecioGasto=(TextView)findViewById(R.id.precioGastoM);
        etxtprecioCobrar=(TextView)findViewById(R.id.precioCobrarM);
        etxtIVA=(TextView)findViewById(R.id.ivaM);


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



        final String dato0, dato1, dato2, dato3, dato4, dato5;
        Bundle bundle = getIntent().getExtras();

        //DATOS CLIENTE
        dato0 = bundle.getString("dato");
        txtdato.setText("NIF/DNI/CIF: " + dato0);
        dato1 = bundle.getString("dato1");
        txtdato1.setText("NOMBRE: " + dato1+" ");
        dato2 = bundle.getString("dato2");
        txtdato2.setText(dato2);
        dato3 = bundle.getString("dato3");
        txtdato3.setText("DOMICILIO: " + dato3);
        dato4 = bundle.getString("dato4");
        txtdato4.setText("LOCALIDAD: " + dato4);
        dato5 = bundle.getString("dato5");
        txtdato5.setText("CODIGO POSTAL: " + dato5);


        final String dato0Empresa,dato1Empresa, dato3Empresa, dato4Empresa, dato5Empresa;

        //DATOS EMPRESA
        dato0Empresa = bundle.getString("idEmpresa");
        txtdatoEmpresa.setText("NIF/DNI/CIF: " + dato0Empresa);
        dato1Empresa = bundle.getString("nameEmpresa");
        txtdato1Empresa.setText("NOMBRE EMPRESA O PARTICULAR: " + dato1Empresa);
        dato3Empresa = bundle.getString("domEmpresa");
        txtdato3Empresa.setText("DOMICILIO: " + dato3Empresa);
        dato4Empresa = bundle.getString("loEmpresa");
        txtdato4Empresa.setText("LOCALIDAD: " + dato4Empresa);
        dato5Empresa = bundle.getString("cpEmpresa");
        txtdato5.setText("CODIGO POSTAL: " + dato5Empresa);

        final String txtNumeroFactura,txtFechaFactura;
        final String txtModoPago,txtdireccionReforma,txtnombreEncargado,txtLicencia,txtprecioTrabajadores,txtNumTrabajadores,txtDiasFinalizar, txtprecioGasto,txtprecioCobrar,txtIVA;

        txtNumeroFactura = bundle.getString("numeroFactura");
        etxtNumeroFactura.setText("Número de factura: " + txtNumeroFactura);

        txtFechaFactura = bundle.getString("fechaFactura");
        etxtFechaFactura.setText("Fecha de facturación " + txtFechaFactura);

        txtdireccionReforma = bundle.getString("direccionReforma");
        etxtdireccionReforma.setText("Direccion de la reforma: " + txtdireccionReforma);

        txtnombreEncargado = bundle.getString("nombreEncargado");
        etxtnombreEncargado.setText("Nombre del encargado: " + txtnombreEncargado);

        txtModoPago= bundle.getString("modoPago");
        etxtModoPago.setText("Direccion de la reforma: " + txtModoPago);

        txtLicencia = bundle.getString("licencia");
        etxtLicencia.setText("Licencia: " + txtLicencia);

        txtNumTrabajadores = bundle.getString("numTrabajadores");
        etxtNumTrabajadores.setText("Cantidad de trabajadores necesarios: " + txtNumTrabajadores);

        txtprecioTrabajadores = bundle.getString("precioTrabajador");
        etxtprecioTrabajadores.setText("Precio del trabajador por dia: " + txtprecioTrabajadores);

        txtDiasFinalizar = bundle.getString("diasFinalizacion");
        etxtDiasFinalizar.setText("Cantidad de dias en terminar la obra: " + txtDiasFinalizar);

        txtprecioCobrar = bundle.getString("precioAcobrar");
        etxtprecioCobrar.setText("¿Precio a cobrar?: " + txtprecioCobrar);

        txtprecioGasto = bundle.getString("precioAgastar");
        etxtprecioGasto.setText("¿Cuánto se va a invertir en la obra?: " + txtprecioGasto);

        txtIVA = bundle.getString("iva");
        etxtIVA.setText("Porcentaje de IVA: " + txtIVA);



        // Permisos.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1000);
        } else {
        }
        // Generaremos el documento al hacer click sobre el boton.
        btnGenerar = (Button) findViewById(R.id.btn_generar_pdf);
        btnGenerar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                generarPdf();
                Toast.makeText(MenuPresupuestos.this, "Se creo tu archivo pdf", Toast.LENGTH_SHORT).show();

            }

        });

    }

    public void generarPdf() {

        // Creamos el documento.
        Document documento = new Document();

        try {

            File f = crearFichero(NOMBRE_DOCUMENTO);

            // Creamos el flujo de datos de salida para el fichero donde
            // guardaremos el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream(
                    f.getAbsolutePath());

            // Asociamos el flujo que acabamos de crear al documento.
            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);

            // Incluimos el pie de pagina y una cabecera
            HeaderFooter cabeceraEmpresa = new HeaderFooter(new Phrase(
                    datosEmpresaCabereza+"\n"+txtdatoEmpresa + "\n" + txtdato1Empresa + " " + txtdato2Empresa + "\n" + txtdato3Empresa + "\n" + txtdato4Empresa + "\n" + txtdato5Empresa), false);
            HeaderFooter cabeceraCliente = new HeaderFooter(new Phrase(
                    datosClienteCabecera+"\n"+txtdato + "\n" + txtdato1 + " " + txtdato2 + "\n" + txtdato3 + "\n" + txtdato4 + "\n" + txtdato5), false);
            HeaderFooter cabeceraPresupuesto = new HeaderFooter(new Phrase(
                    etxtNumeroFactura+"\n"+etxtFechaFactura), false);
            documento.setHeader(cabeceraEmpresa);
            documento.setHeader(cabeceraCliente);
            documento.setHeader(cabeceraPresupuesto);
        //    documento.setFooter(pie);

            // Abrimos el documento.
            documento.open();

            // Añadimos un titulo con la fuente por defecto.
            documento.add(new Paragraph("Titulo 1"));

            Font font = FontFactory.getFont(FontFactory.HELVETICA, 28,
                    Font.BOLD, Color.RED);
            documento.add(new Paragraph("Titulo personalizado", font));

            // Insertamos una tabla.
            PdfPTable tabla = new PdfPTable(5);
            for (int i = 0; i < 15; i++) {
                tabla.addCell("Celda " + i);
            }
            documento.add(tabla);

            // Agregar marca de agua
            font = FontFactory.getFont(FontFactory.HELVETICA, 42, Font.BOLD,
                    Color.GRAY);
            ColumnText.showTextAligned(writer.getDirectContentUnder(),
                    Element.ALIGN_CENTER, new Paragraph(
                            "", font), 297.5f, 421,
                    writer.getPageNumber() % 2 == 1 ? 45 : -45);

        } catch (DocumentException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());

        } catch (IOException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());

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

    /**
     * Obtenemos la ruta donde vamos a almacenar el fichero.
     *
     * @return
     */
    public static File getRuta() {

        // El fichero sera almacenado en un directorio dentro del directorio
        // Descargas
        File ruta = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            ruta = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    NOMBRE_DIRECTORIO);

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