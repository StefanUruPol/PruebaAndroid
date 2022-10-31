package com.example.practico6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtNumero;
    private Switch switchOpcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtNumero = findViewById(R.id.txtNumero);
        switchOpcion = findViewById(R.id.switchOpcion);
    }

    public void leerPreferencias(View view) {
        SharedPreferences preferences = getSharedPreferences("prueba", Context.MODE_PRIVATE);

        String nombre = preferences.getString("nombre", "Nombre no encontrado");
        String apellido = preferences.getString("apellido", "Apellido no encontrado");
        int numero = preferences.getInt("numero", -1);
        boolean opcion = preferences.getBoolean("opcion", false);

        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtNumero.setText(new Integer(numero).toString());
        switchOpcion.setChecked(opcion);
    }

    public void guardarPreferencias(View view) {
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        int numero = Integer.parseInt(txtNumero.getText().toString());
        boolean op = switchOpcion.isChecked();

        SharedPreferences preferences = getSharedPreferences("prueba", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("nombre", nombre);
        editor.putString("apellido", apellido);
        editor.putInt("numero", numero);
        editor.putBoolean("opcion", op);

        editor.commit();
    }
}