package com.example.presureforms;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.*;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
                String sNombre = reg_nombre.getText().toString();
                String sApellidos = reg_apellidos.getText().toString();
                String sId_empresa = reg_id_empresa.getText().toString();
                String sNombre_empresa = reg_nombre_empresa.getText().toString();
                String sDirec_empresa = reg_direc_empresa.getText().toString();
                String sCp_empresa = reg_nombre.getText().toString();
                String sPoblacion = reg_poblacion_empresa.getText().toString();
                String sEmail = reg_email.getText().toString();
                String sContraseña = reg_contraseña.getText().toString();
                String sTelefono = reg_contraseña.getText().toString();
                String sConfiContraseña = reg_confir_contraseña.getText().toString();
                new Usuario(Registro_activity.this).execute(sNombre, sApellidos, sId_empresa, sNombre_empresa, sDirec_empresa, sCp_empresa, sPoblacion, sEmail, sContraseña, sTelefono, sConfiContraseña);
            }
        });
    }

    public static class Usuario extends AsyncTask<String, Void, String> {
        private WeakReference<Context> context;

        public Usuario(Context context) {
            this.context = new WeakReference<>(context);
        }

        protected String doInBackground(String... params) {
            String url_servidor_registro = "https://ddcmarket.es/registro.php";
            String resultado;
            try {
                URL url = new URL(url_servidor_registro);
                HttpURLConnection connectionConBase = (HttpURLConnection) url.openConnection();
                connectionConBase.setRequestMethod("POST");
                connectionConBase.setDoOutput(true);
                OutputStream outputStream = connectionConBase.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

                String sNombre = params[0];
                String sApellidos = params[1];
                String sId_empresa = params[2];
                String sNombre_empresa = params[3];
                String sDirec_empresa = params[4];
                String sCp_empresa = params[5];
                String sPoblacion = params[6];
                String sEmail = params[7];
                String sContraseña = params[8];
                String sTelefono = params[9];

                String datos = URLEncoder.encode("nombre_titutlar", "UTF-8") + "=" + URLEncoder.encode(sNombre, "UTF-8")
                        + "&" + URLEncoder.encode("apellidos_titular", "UTF-8") + "=" + URLEncoder.encode(sApellidos, "UTF-8")
                        + "&" + URLEncoder.encode("id_empresa", "UTF-8") + "=" + URLEncoder.encode(sId_empresa, "UTF-8")
                        + "&" + URLEncoder.encode("nombre_empresa", "UTF-8") + "=" + URLEncoder.encode(sNombre_empresa, "UTF-8")
                        + "&" + URLEncoder.encode("direccion_empresa", "UTF-8") + "=" + URLEncoder.encode(sDirec_empresa, "UTF-8")
                        + "&" + URLEncoder.encode("codigo_postal_empresa", "UTF-8") + "=" + URLEncoder.encode(sCp_empresa, "UTF-8")
                        + "&" + URLEncoder.encode("poblacion_empresa", "UTF-8") + "=" + URLEncoder.encode(sPoblacion, "UTF-8")
                        + "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(sEmail, "UTF-8")
                        + "&" + URLEncoder.encode("contraseña", "UTF-8") + "=" + URLEncoder.encode(sContraseña, "UTF-8")
                        + "&" + URLEncoder.encode("telefono", "UTF-8") + "=" + URLEncoder.encode(sTelefono, "UTF-8");

                bufferedWriter.write(datos);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = connectionConBase.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder stringBuilder = new StringBuilder();
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    stringBuilder.append(linea);
                }
                resultado = stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                connectionConBase.disconnect();


            } catch (MalformedURLException e) {
                Log.d("Error del servidor", "La url del servidor no es valida");
                resultado = "Se ha producido un error";
            } catch (IOException e) {
                Log.d("Error de la aplicacion", "Es posible que no tengas internet");
                resultado = "Esposible que no tengas internet";
            }
            return resultado;

        }

        protected void onPostExecute(String resultado) {

    }
    }
}
