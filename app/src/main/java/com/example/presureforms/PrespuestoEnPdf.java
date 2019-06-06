package com.example.presureforms;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PrespuestoEnPdf {
    private Context context;
    private File ficheroPdf;
    private Document document;
    private PdfWriter escribirPdf;
    private Paragraph parrafo;

    private Font tituloFuente = new Font(Font.FontFamily.COURIER, 15);
    private Font subtitulo = new Font(Font.FontFamily.COURIER, 13);


    public PrespuestoEnPdf(Context cotext)  {
        this.context = context;

    }

    public void abrirDocumento() {
        creadorCarpeta();
        try {
            document = new Document(PageSize.A4);
            escribirPdf = PdfWriter.getInstance(document, new FileOutputStream(ficheroPdf));
            document.open();
        } catch (Exception e) {
            Log.e("abrirDocumento", e.toString());

        }

    }

    private void creadorCarpeta() {

        File carpeta = new File(Environment.getExternalStorageDirectory().toString(), "pressReformsPDF");

        if (!carpeta.exists()) {
            carpeta.mkdirs();
            ficheroPdf = new File(carpeta, "Factura.pdf");


        }

    }

    public void cerrarDocumento() {
        document.close();

    }

    public void crearMetadatos(String titulo, String sujeto, String autor) {
        document.addTitle(titulo);
        document.addSubject(sujeto);
        document.addAuthor(autor);
    }

    public void agregarTitulos(String titulo, String sujeto, String autor) {
        try {
            parrafo = new Paragraph();

        } catch (Exception e) {

            Log.e("agregarTitulos", e.toString());

        }


    }

    private void crearSubtitulo(Paragraph parrafoHijo) {
        try {

            parrafoHijo.setAlignment(Element.ALIGN_CENTER);
            parrafo.add(parrafoHijo);
        } catch (Exception e) {

            Log.e("crearSubtitlo", e.toString());

        }
    }

    public void crearTabla(String[] cabeberaEmpresa, ArrayList<String[]> empresa) {
        try {
            parrafo = new Paragraph();
            parrafo.setFont(tituloFuente);
            PdfPTable tablaEmpresa = new PdfPTable(cabeberaEmpresa.length);
            tablaEmpresa.setWidthPercentage(100);
            PdfPCell celdas;
            int caberezaEmpresaPrincipal = 0;
            while (caberezaEmpresaPrincipal < cabeberaEmpresa.length) {
                celdas = new PdfPCell(new Phrase(cabeberaEmpresa[caberezaEmpresaPrincipal++], tituloFuente));
                celdas.setHorizontalAlignment(Element.ALIGN_LEFT);
                celdas.setBackgroundColor(BaseColor.BLUE);
                tablaEmpresa.addCell(celdas);
            }

            for (int indexR = 0; indexR < empresa.size(); indexR++) {
                String[] filas = empresa.get(indexR);
                for (int indexC = 0; indexC < cabeberaEmpresa.length; indexC++) {
                    celdas = new PdfPCell(new Phrase(filas[indexC]));
                    celdas.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tablaEmpresa.addCell(celdas);
                }
            }

            parrafo.add(tablaEmpresa);
            document.add(parrafo);
        } catch (Exception e) {
            Log.e("crearTabla", e.toString());

        }
    }

    public void agregarParrafo(String texto) {
        try {
            parrafo = new Paragraph(texto, tituloFuente);
            document.add(parrafo);

        } catch (Exception e) {

            Log.e("agregarTitulos", e.toString());

        }
    }

    public void verPDF() {
        Intent siguiente = new Intent(context, VerFicheroPDF.class);
        siguiente.putExtra("path", ficheroPdf.getAbsolutePath());
        siguiente.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(siguiente);

    }
}
