package com.example.android.registrarcontacto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText etNombres;
    TextView etFecha;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcion;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombres = (EditText) findViewById(R.id.etNombres);
        etFecha = (TextView) findViewById(R.id.etFecha);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        //Intent explicito (une actividades dentro de la misma aplicacion)

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.nNombre), etNombres.getText().toString());
                intent.putExtra(getResources().getString(R.string.nFecha), etFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.nTelefono), etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.neMail), etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.nDescripcion), etDescripcion.getText().toString());
                startActivity(intent);
            }
        });
    }

    //Date picker methods
    public void datePicker(View view){
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.etFecha)).setText(dateFormat.format(calendar.getTime()));
    }
    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        setDate(cal);
    }

    public static class DatePickerFragment extends DialogFragment {

        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), year, month, day);
        }
    }
}
