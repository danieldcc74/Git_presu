package com.example.presureforms;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Lanzador_Activity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzador_);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent lanzadorActivity = new Intent(Lanzador_Activity.this,MenuPresupuestos.class);
                startActivity(lanzadorActivity);

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
