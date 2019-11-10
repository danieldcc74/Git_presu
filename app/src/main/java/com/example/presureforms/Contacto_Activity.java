package com.example.presureforms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Contacto_Activity extends AppCompatActivity {
Button volver_contac_sala;
ImageButton btn_social;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        volver_contac_sala=(Button)findViewById(R.id.btn_volver_contac_sala);
        btn_social=(ImageButton)findViewById(R.id.btn_social);

        volver_contac_sala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irSala= new Intent(Contacto_Activity.this,Sala_Principal.class);
                startActivity(irSala);
            }
        });
        btn_social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","info@dccmarket.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Tengo una opinión para ti");
                startActivity(Intent.createChooser(emailIntent,getString(R.string.selector)));
            }
        });
    }

}
