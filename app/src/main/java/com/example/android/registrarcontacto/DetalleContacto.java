package com.example.android.registrarcontacto;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btnEditarDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Intent i = getIntent();
        String nombre = i.getStringExtra(getResources().getString(R.string.nNombre));
        String fecha = i.getStringExtra(getResources().getString(R.string.nFecha));
        String telefono = i.getStringExtra(getResources().getString(R.string.nTelefono));
        String eMail = i.getStringExtra(getResources().getString(R.string.neMail));
        String descripcion = i.getStringExtra(getResources().getString(R.string.nDescripcion));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(eMail);
        tvDescripcion.setText(descripcion);

        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
