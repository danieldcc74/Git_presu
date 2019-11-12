package com.example.presureforms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registro_activity extends AppCompatActivity {
    Button btn_reg_volver, btn_reg_registrase;
    EditText reg_nombre, reg_apellidos, reg_id_empresa, reg_nombre_empresa, reg_direc_empresa, reg_cod_postal_empresa, reg_poblacion_empresa, reg_email, reg_contraseña, reg_confir_contraseña, reg_telefono;
    ImageButton reg_icon_empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_activity);
        btn_reg_volver = (Button) findViewById(R.id.btn_reg_volver);
        btn_reg_registrase = (Button) findViewById(R.id.btn_reg_registrarse);

        reg_icon_empresa = (ImageButton) findViewById(R.id.reg_icon_empresa);

        reg_nombre = (EditText) findViewById(R.id.reg_nombre);
        reg_apellidos = (EditText) findViewById(R.id.reg_apellidos);
        reg_id_empresa = (EditText) findViewById(R.id.reg_id_empresa);
        reg_nombre_empresa = (EditText) findViewById(R.id.reg_nombre_empresa);
        reg_direc_empresa = (EditText) findViewById(R.id.reg_direc_empresa);
        reg_cod_postal_empresa = (EditText) findViewById(R.id.reg_codpos_empresa);
        reg_poblacion_empresa = (EditText) findViewById(R.id.reg_poblacion_empresa);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_contraseña = (EditText) findViewById(R.id.reg_contraseña);
        reg_confir_contraseña = (EditText) findViewById(R.id.reg_confirmar_contraseña);
        reg_telefono = (EditText) findViewById(R.id.reg_telefono);

        btn_reg_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverReg = new Intent(Registro_activity.this, Login_activity.class);
                startActivity(volverReg);
            }
        });
        btn_reg_registrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reg_nombre.getText().toString().isEmpty()
                        || reg_apellidos.getText().toString().isEmpty()
                        || reg_id_empresa.getText().toString().isEmpty()
                        || reg_nombre_empresa.getText().toString().isEmpty()
                        || reg_direc_empresa.getText().toString().isEmpty()
                        || reg_cod_postal_empresa.getText().toString().isEmpty()
                        || reg_poblacion_empresa.getText().toString().isEmpty()
                        || reg_email.getText().toString().isEmpty()
                        || reg_contraseña.getText().toString().isEmpty()
                        || reg_confir_contraseña.getText().toString().isEmpty()
                        || reg_telefono.getText().toString().isEmpty()
                        &&(reg_contraseña.getText().toString()!=reg_confir_contraseña.getText().toString())) {
                    Toast.makeText(Registro_activity.this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();

                } else {
                    conexionWebSevice("http://192.168.0.13:80/registro/registro.php");
                    Intent volver_login = new Intent(Registro_activity.this, Login_activity.class);
                    startActivity(volver_login);
                }
            }
        });
    }

    public void conexionWebSevice(String URL) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Se ha registrado con exito", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre_titular", reg_nombre.getText().toString());
                parametros.put("apellidos_titular", reg_apellidos.getText().toString());
                parametros.put("id_empresa", reg_id_empresa.getText().toString());
                parametros.put("nombre_empresa", reg_nombre_empresa.getText().toString());
                parametros.put("direccion_empresa", reg_direc_empresa.getText().toString());
                parametros.put("codigo_postal_empresa", reg_nombre.getText().toString());
                parametros.put("poblacion_empresa", reg_poblacion_empresa.getText().toString());
                parametros.put("email", reg_email.getText().toString());
                parametros.put("contraseña", reg_contraseña.getText().toString());
                parametros.put("telefono", reg_contraseña.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
