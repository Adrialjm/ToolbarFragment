package com.example.toolbarfragment3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
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

public class CrearUsuario extends AppCompatActivity {

    public MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearusuario);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");

        findViewById(R.id.button2).setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Usuario.class);
            startActivity(intent);
        });

        final EditText editNombre = findViewById(R.id.Nombre);
        editNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CrearUsuario.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nombre", s.toString());
                editor.apply();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        final EditText editMail = findViewById(R.id.Mail);
        editMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CrearUsuario.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("mail", s.toString());
                editor.apply();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

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
                Intent intent = new Intent(CrearUsuario.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_perfil:
                intent = new Intent(CrearUsuario.this, Usuario.class);
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

