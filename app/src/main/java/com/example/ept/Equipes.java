package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Equipes extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = ".MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes);
        setTitle("Equipes");
    }
    public void telaFormatadores(View view){
        telaTime(0);
    }
    public void telaDST(View view){
        telaTime(1);
    }

    public void telaJogostosos(View view){
        telaTime(2);
    }

    public void telaMecapeta(View view){
        telaTime(3);
    }
    private void telaTime(int idTime){
       Intent intent = new Intent(this, EquipeFormatadores.class);
        intent.putExtra(EXTRA_MESSAGE, idTime);
        startActivity(intent);
    }
}