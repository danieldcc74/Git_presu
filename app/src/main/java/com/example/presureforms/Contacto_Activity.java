package com.example.presureforms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contacto_Activity extends AppCompatActivity {
Button volver_contac_sala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        volver_contac_sala=(Button)findViewById(R.id.btn_volver_contac_sala);
        volver_contac_sala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irSala= new Intent(Contacto_Activity.this,Sala_Principal.class);
                startActivity(irSala);
            }
        });
    }

}
