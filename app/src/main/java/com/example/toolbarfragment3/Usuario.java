package com.example.toolbarfragment3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class Usuario extends AppCompatActivity {

    public MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");

        findViewById(R.id.button).setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CrearUsuario.class);
            startActivity(intent);
        });

        SharedPreferences preferencesNombre = PreferenceManager.getDefaultSharedPreferences(Usuario.this);
        String texto1 = preferencesNombre.getString("nombre", "");
        EditText editNombre = findViewById(R.id.Nombre);
        editNombre.setText(texto1);

        SharedPreferences preferencesMail = PreferenceManager.getDefaultSharedPreferences(Usuario.this);
        String texto2 = preferencesMail.getString("mail", "");
        EditText editMail = findViewById(R.id.Mail);
        editMail.setText(texto2);

        EditText Nombre = findViewById(R.id.Nombre);
        editNombre.setFocusable(false);
        editNombre.setCursorVisible(false);

        EditText Mail = findViewById(R.id.Mail);
        editMail.setFocusable(false);
        editMail.setCursorVisible(false);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_menu:
                Intent intent = new Intent(Usuario.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_perfil:
                intent = new Intent(Usuario.this, Usuario.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected  void onPause() {
        if (bgm != null) {
            bgm.release();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (bgm != null) {
            bgm.release();
        }
        super.onDestroy();
    }
    }

