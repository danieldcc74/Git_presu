package com.example.presureforms;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class VerFicheroPDF extends AppCompatActivity {

    private PDFView verPDF;
private File fichero;
    public VerFicheroPDF(Context applicationContext) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_fichero_pdf);

        verPDF=(PDFView)findViewById(R.id.visorPDF);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
fichero = new File(bundle.getString("path","el Fichero no se ha creado"));

verPDF.fromFile(fichero).enableSwipe(true)
        .swipeHorizontal(false)
        .enableDoubletap(true)
        .load();

        }
    }
}
