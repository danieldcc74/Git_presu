package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login_activity extends AppCompatActivity {
    RequestQueue solicitud;
    JsonRequest jSolicitud;

    EditText box_correo, box_contraseña;
    Button btn_iniciar_sesion, btn_registro;


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
                Intent irRegistro = new Intent(Login_activity.this, Registro_activity.class);
                startActivity(irRegistro);
            }
        });
        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metodo_iniciar_sesion("http://192.168.0.13:80/registro/validar_usuario.php");
            }
        });
    }

    private void metodo_iniciar_sesion(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    if(response.isEmpty()){
                        Intent irSalaPrincipal = new Intent(Login_activity.this, Sala_Principal.class);
                        startActivity(irSalaPrincipal);
                    }else{
                        Toast.makeText(Login_activity.this, "El usuario y la contraseña no existen", Toast.LENGTH_SHORT).show();

                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login_activity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("email", box_correo.getText().toString());
                parametros.put("contraseña", box_contraseña.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
