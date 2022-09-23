package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void telaEquipes(View view) {
        Intent intent = new Intent(this, Equipes.class);
        startActivity(intent);
    }

    public void telaCampeonatos(View view) {

        Intent intent = new Intent(this, Campeonatos.class);
        startActivity(intent);
    }

    public void telaModalidades(View view) {
        Intent intent = new Intent(this, Modalidades.class);
        startActivity(intent);
    }
    public void telaEstatisticas(View view){

        Intent intent = new Intent(this, Estatisticas.class);
        startActivity(intent);
    }
/// ------------------
}