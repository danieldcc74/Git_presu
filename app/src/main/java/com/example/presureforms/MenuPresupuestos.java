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
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import harmony.java.awt.Color;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;

public class MenuPresupuestos extends AppCompatActivity {


    public static String dato0Empresa, dato1Empresa, dato3Empresa, dato4Empresa, dato5Empresa, dato6Empresa, dato7Empresa;
    public static String dato0c, dato1c, dato2c, dato3c, dato4c, dato5c, dato6c, dato7c, dato8c;
    public static String txtNumeroFactura, txtFechaFactura;
    public static String txtModoPago, txtdireccionReforma, txtnombreEncargado, txtLicencia, txtDetallesTrabajo, txtprecioTrabajadores, txtNumTrabajadores, txtDiasFinalizar, txtprecioGasto, txtprecioCobrar, txtIVA;

    //textos a mostrar del cliente
    private TextView txtdato, txtdato1, txtdato2, txtdato3, txtdato4, txtdato5, txtdato6, txtdato7, txtdato8;
    //textos a mostrar de la empresa
    private TextView txtdatoEmpresa, txtdato1Empresa, txtdato3Empresa, txtdato4Empresa, txtdato5Empresa, txtdato6Empresa, txtdato7Empresa;
    //textos a mostrar del presupuesto
    private TextView etxtNumeroFactura, etxtFechaFactura;
    private TextView etxtdireccionReforma, etxtModoPago, etxtnombreEncargado, etxtLicencia, etxtprecioTrabajadores, etxtNumTrabajadores, etxtDiasFinalizar, etxtprecioGasto, etxtprecioCobrar, etxtIVA;
    private TextView etxtDatosAdicionales, etxtTotalTrabajador, etxtIvaPorcentajeTotal, etxtTotalneto, etxtBeneficios;


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

        //DECLARACION DE TEXTVIEW DEL XML DEL CLIENTE
        txtdato = (TextView) findViewById(R.id.dato);
        txtdato1 = (TextView) findViewById(R.id.dato1);
        txtdato2 = (TextView) findViewById(R.id.dato2);
        txtdato3 = (TextView) findViewById(R.id.dato3);
        txtdato4 = (TextView) findViewById(R.id.dato4);
        txtdato5 = (TextView) findViewById(R.id.dato5);
        txtdato6 = (TextView) findViewById(R.id.dato6);
        txtdato7 = (TextView) findViewById(R.id.dato7);
        txtdato8 = (TextView) findViewById(R.id.dato8);

        //DECLARACION DE TEXTVIEW DEL XML DE LA EMPRESA
        txtdatoEmpresa = (TextView) findViewById(R.id.datoEmpresa);
        txtdato1Empresa = (TextView) findViewById(R.id.dato1Empresa);
        txtdato3Empresa = (TextView) findViewById(R.id.dato3Empresa);
        txtdato4Empresa = (TextView) findViewById(R.id.dato4Empresa);
        txtdato5Empresa = (TextView) findViewById(R.id.dato5Empresa);
        txtdato6Empresa = (TextView) findViewById(R.id.dato6Empresa);
        txtdato7Empresa = (TextView) findViewById(R.id.dato7Empresa);

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
        etxtDatosAdicionales = (TextView) findViewById(R.id.datosAdicionales);
        etxtTotalTrabajador = (TextView) findViewById(R.id.totalTrabajador);
        etxtIvaPorcentajeTotal = (TextView) findViewById(R.id.ivaPorcentajetTotal);
        etxtTotalneto = (TextView) findViewById(R.id.totalNeto);
        etxtBeneficios = (TextView) findViewById(R.id.ivaM);

        // Generaremos el documento al hacer click sobre el boton.
        btnGenerar = (Button) findViewById(R.id.btn_generar_pdf);
        btnCliente = (Button) findViewById(R.id.btnRellenarCliente);
        btnEmpresa = (Button) findViewById(R.id.btnRellenarEmpresa);
        btnPresupuesto = (Button) findViewById(R.id.btnRellenaPresu);


        txtdato.setText("NIF / DNI / NIE: " + dato0c);
        txtdato1.setText("Nombre: " + dato2c);
        txtdato2.setText(dato2c);
        txtdato3.setText("Domicilio: " + dato3c);
        txtdato4.setText("Localidad: " + dato4c);
        txtdato5.setText("Código postal: " + dato5c);
        txtdato6.setText("Teléfono:" + dato6c);
        txtdato7.setText("Correo Electrónico: " + dato7c);


        txtdatoEmpresa.setText("NIF / DNI / NIE: " + dato0Empresa);
        txtdato1Empresa.setText("Nombre emprsa o particular: " + dato1Empresa);
        txtdato3Empresa.setText("Domicilio: " + dato3Empresa);
        txtdato4Empresa.setText("Localidad: " + dato4Empresa);
        txtdato5Empresa.setText("Código postal: " + dato5Empresa);
        txtdato6Empresa.setText("Teléfono: " + dato6Empresa);
        txtdato7Empresa.setText("Correo Electrónico: " + dato7Empresa);

        etxtNumeroFactura.setText("Número de factura: " + txtNumeroFactura);
        etxtFechaFactura.setText("Fecha de factura: " + txtFechaFactura);
        etxtdireccionReforma.setText("Trabajo realizado en: " + txtdireccionReforma);
        etxtModoPago.setText("Modo de pago: " + txtModoPago);
        etxtnombreEncargado.setText("Nombre del encargado: " + txtnombreEncargado);
        etxtLicencia.setText("Requiere licencia: " + txtLicencia);
        etxtprecioTrabajadores.setText("Precio de trabajor por dia: " + txtprecioTrabajadores);
        etxtNumTrabajadores.setText("¿Cuántos trabajadores necesita?: " + txtNumTrabajadores);
        etxtDiasFinalizar.setText("Plazo de entrega: " + txtDiasFinalizar + " dias");
        etxtprecioGasto.setText("¿Cuánto va a invertir en materiales?: " + txtprecioGasto);
        etxtprecioCobrar.setText("¿Cuanto le va a cobrar al cliente?: " + txtprecioCobrar);
       // etxtIVA.setText("Porcentaje de IVA: " + txtIVA);


        /*
        etxtDatosAdicionales.setText("Datos adicionales");
        etxtTotalTrabajador.setText("Mano de obra: " + totalPrecioTrabajadorString);

        etxtprecioCobrar.setText("Total bruto: " + txtprecioCobrar);
        etxtIvaPorcentajeTotal.setText("IVA: " + calculoIVA);
        etxtTotalneto.setText("Total neto: " + totalNeto);
        etxtBeneficios.setText("Beficios: " + beficiosTotales);

        final Double numTrabajador = Double.parseDouble(txtNumTrabajadores);
        final Double precioTrabajador = Double.parseDouble(txtprecioTrabajadores);
        final Double diasFinalizacion = Double.parseDouble(txtDiasFinalizar);
        final Double totalPrecioTrabajador = (numTrabajador * precioTrabajador) * diasFinalizacion;
        final String totalPrecioTrabajadorString = String.valueOf(totalPrecioTrabajador);


        final Double inversion = Double.parseDouble(txtprecioCobrar);
        final Double totalBruto = Double.parseDouble(txtprecioGasto);
        final Double iva = Double.parseDouble(txtIVA);
        final Double calculoIVA = totalBruto * iva / 100;
        final Double totalNeto = calculoIVA + totalBruto;

        Double beficiosTotales = (totalNeto - totalPrecioTrabajador) - inversion;
*/

        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguienteCliente = new Intent(MenuPresupuestos.this, ClienteActivity.class);
                startActivity(siguienteCliente);
            }


        });
        btnEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguienteEmpresa = new Intent(MenuPresupuestos.this, EmpresaActivity.class);
                startActivity(siguienteEmpresa);
            }
        });
        btnPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguientePresupuesto = new Intent(MenuPresupuestos.this, PresupuestoActivity.class);
                startActivity(siguientePresupuesto);
            }
        });
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarPdf();
                Toast.makeText(MenuPresupuestos.this, "PDF lanzado", Toast.LENGTH_SHORT).show();
            }
        });


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

            HeaderFooter cabecera = new HeaderFooter(new Phrase("Número de factura: "+txtNumeroFactura +
                    "\n" + "Fecha factura: "+txtFechaFactura), false);
            cabecera.setAlignment(Element.ALIGN_RIGHT);

            documento.setHeader(cabecera);
            // Abrimos el documento.
            documento.open();


            // Añadimos un titulo con la fuente por defecto.

            Font titulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16,
                    Font.BOLD);
            Font subtitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14,
                    Font.BOLD);
            Font parrafo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,
                    Font.BOLD);

            PdfPTable tablaCabeceraEmpresa = new PdfPTable(1);
//remplazar datos

            tablaCabeceraEmpresa.addCell(new Phrase("sdasdasdasd"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));



            PdfPTable tablaCabeceraCliente = new PdfPTable(1);
            tablaCabeceraCliente.setSpacingAfter(10);
            tablaCabeceraCliente.setSpacingBefore(10);
            tablaCabeceraEmpresa.addCell(new Phrase("sdasdasdasd"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase("sdfasfsdafas"+dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase(dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase(dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase(dato0c));
            tablaCabeceraEmpresa.addCell(new Phrase(dato0c));




//y donde metes el presupuesto en el codigo donde generas la factura donde estan los detalles del presupuesto
            PdfPTable tablaPrincipal = new PdfPTable(1);
            tablaPrincipal.setSpacingAfter(10);


            PdfPTable celdatotalObra = new PdfPTable(1);


            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));

            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(1);
            tablaPrincipal.addCell(celdaFinal);

            documento.add(new Phrase("DATOS EMPRESA"));
            documento.add(tablaCabeceraEmpresa);
            documento.add(new Phrase("DATOS CLIENTE"));
            documento.add(tablaCabeceraCliente);
            documento.add(new Paragraph("DETALLES DEL TRABAJO"));
            documento.add(tablaPrincipal);
            documento.add(celdaFinal);


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