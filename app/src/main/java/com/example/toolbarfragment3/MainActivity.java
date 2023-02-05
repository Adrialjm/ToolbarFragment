package com.example.toolbarfragment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");

        Spinner spinner = findViewById(R.id.spin);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentMenu());
        fragments.add(new FragmentAlfa());
        fragments.add(new FragmentBeta());
        fragments.add(new FragmentGamma());
        fragments.add(new FragmentDelta());
        fragments.add(new FragmentEpsilon());
        fragments.add(new FragmentZeta());
        fragments.add(new FragmentEta());
        FragmentManager fragmentManager = getSupportFragmentManager();
        SpinnerFragmentAdapter adapter = new SpinnerFragmentAdapter(this, fragments, fragmentManager);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter.changeFragment(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_menu:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_perfil:
                intent = new Intent(MainActivity.this, Usuario.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}