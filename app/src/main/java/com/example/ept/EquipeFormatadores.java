package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EquipeFormatadores extends AppCompatActivity {

    private  String[][] equipesInfos;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_formatadores);
        Intent intentDisplay = getIntent();

        id = intentDisplay.getIntExtra(Equipes.EXTRA_MESSAGE, 0);
        equipesInfos = new String[][]{
                {getResources().getString(R.string.formatadores), getResources().getString(R.string.descricaoformatadores), String.valueOf(R.drawable.logo_formatadores), String.valueOf(R.drawable.camisa_formatadores), getResources().getString(R.string.insta_formatadores)},
                {getResources().getString(R.string.dst), getResources().getString(R.string.des_cdst), String.valueOf(R.drawable.logo_dst), String.valueOf(R.drawable.camisa_dst), getResources().getString(R.string.insta_dst)},
                {getResources().getString(R.string.jogostosos), getResources().getString(R.string.desc_jogostosos), String.valueOf(R.drawable.logo_jogostosos), String.valueOf(R.drawable.camisa_jogostosos), getResources().getString(R.string.insta_jogostosos)},
                {getResources().getString(R.string.mecapeta), getResources().getString(R.string.desc_mecapeta), String.valueOf(R.drawable.logo_mecapeta), String.valueOf(R.drawable.camisa_mecapeta), getResources().getString(R.string.insta_mecapeta)}
        };

        setInfos();
        Log.v("id", String.valueOf(id));
    }

    public void gotoInsta(View view){
        String link = "https://instagram.com/" + equipesInfos[id][4];
        Uri uri = Uri.parse("http://instagram.com/_u/" + equipesInfos[id][4]);
        Log.v("inins", "http://instagram.com/_u/" + equipesInfos[id][4]);
        Intent instagram = new Intent(Intent.ACTION_VIEW, uri);
        instagram.setPackage("com.instagram.android");
        try{
            startActivity(instagram);
        }
        catch(ActivityNotFoundException r){
            Log.v("insta", "Instagram não está instalado");
        }
    }
    private void setInfos(){
        TextView txtName = (TextView) this.findViewById(R.id.nomeEquipe);
        TextView txtDesc = (TextView) this.findViewById(R.id.descEquipe);
        ImageView imgEscudo = (ImageView) findViewById(R.id.imgCamisa);
        ImageView imgCamisa = (ImageView) findViewById(R.id.imgEscudo);

        setTitle(equipesInfos[id][0]);
        txtName.setText(equipesInfos[id][0]);
        txtDesc.setText(equipesInfos[id][1]);

        int escudo =  Integer.parseInt(equipesInfos[id][2]);
        int camisa =  Integer.parseInt(equipesInfos[id][3]);

        imgEscudo.setImageResource(escudo);
        imgCamisa.setImageResource(camisa);
    }

    public void modalidades(View view){
        Intent intent = new Intent(this, Modalidades.class);
        startActivity(intent);
    }
}