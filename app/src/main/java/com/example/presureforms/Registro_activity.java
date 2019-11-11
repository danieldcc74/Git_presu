package com.example.presureforms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro_activity extends AppCompatActivity {
Button btn_reg_volver, btn_reg_registrase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_activity);
        btn_reg_volver = (Button) findViewById(R.id.btn_reg_volver);
        btn_reg_registrase = (Button) findViewById(R.id.btn_reg_registrarse);


        btn_reg_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverReg = new Intent(Registro_activity.this,Login_activity.class);
                startActivity(volverReg);
            }
        });
    }
}
