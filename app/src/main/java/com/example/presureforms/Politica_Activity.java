package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Politica_Activity extends AppCompatActivity {
Button btn_volver_sala_poli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politica_);
        btn_volver_sala_poli=(Button)findViewById(R.id.btn_volver_poli_sala);
        btn_volver_sala_poli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver_sala = new Intent(Politica_Activity.this, Sala_Principal.class);
                startActivity(volver_sala);
            }
        });
    }
}
