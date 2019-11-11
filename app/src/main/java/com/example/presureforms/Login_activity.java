package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class Login_activity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    RequestQueue solicitud;
    JsonRequest jSolicitud;

    EditText box_correo, box_contraseña;
    Button btn_iniciar_sesion ,btn_registro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        solicitud = Volley.newRequestQueue(this);


        box_correo = (EditText) findViewById(R.id.box_email);
        box_contraseña = (EditText) findViewById(R.id.box_password);
        btn_iniciar_sesion = (Button) findViewById(R.id.btn_iniciar_sesion);
        btn_registro = (Button) findViewById(R.id.btn_registrarse);

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irRegistro =new Intent (Login_activity.this, Registro_activity.class);
                startActivity(irRegistro);
            }
        });
        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metodo_iniciar_sesion();
            }
        });
    }

    private void metodo_iniciar_sesion() {
        String url = "https://91.199.120.16/inicio_sesion/inicio_sesion.php/user=" + box_correo.getText().toString() + "&pwd=" + box_contraseña.getText().toString();

        jSolicitud = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        solicitud.add(jSolicitud);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Algo has puesto mal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Bingo!!", Toast.LENGTH_SHORT).show();
    }
}
