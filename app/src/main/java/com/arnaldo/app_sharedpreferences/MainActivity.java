package com.arnaldo.app_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = (EditText) findViewById(R.id.et_email);

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et_email.setText(preferencias.getString("email", ""));
    }

    //Metodo para el boton guardar
    public void Guardar(View view) {
        SharedPreferences preferencias2 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias2.edit();
        obj_editor.putString("email", et_email.getText().toString());
        obj_editor.commit();
        finish();
    }
}
