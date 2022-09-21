package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class EquipeFormatadores extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_formatadores);
        Intent intentDisplay = getIntent();

        int equipeID = intentDisplay.getIntExtra(Equipes.EXTRA_MESSAGE, 0);
        setInfos(equipeID);
        Log.v("id", String.valueOf(equipeID));
    }

    private void setInfos(int id){
        TextView txtName = (TextView) this.findViewById(R.id.nomeEquipe);
        TextView txtDesc = (TextView) this.findViewById(R.id.descEquipe);
        ImageView imgEscudo = (ImageView) findViewById(R.id.imgCamisa);
        ImageView imgCamisa = (ImageView) findViewById(R.id.imgEscudo);
//        TextView txtName = (TextView) this.findViewById(R.id.nomeEquipe);

        String[][] equipesInfos = {
                {getResources().getString(R.string.formatadores), getResources().getString(R.string.descricaoformatadores), String.valueOf(R.drawable.formatadores), String.valueOf(R.drawable.camisa_formatadores)},
                {getResources().getString(R.string.dst), getResources().getString(R.string.des_cdst), String.valueOf(R.drawable.dst_), String.valueOf(R.drawable.camisa_dst)},
                // Alterar os "R.drawable.formatadores" para o nome correto da imagem do Jogostosos
                {getResources().getString(R.string.jogostosos), getResources().getString(R.string.desc_jogostosos), String.valueOf(R.drawable.formatadores), String.valueOf(R.drawable.camisa_jogostosos)},
                // Alterar os "R.drawable.formatadores" para o nome correto da imagem do Mecapeta
                {getResources().getString(R.string.mecapeta), getResources().getString(R.string.desc_mecapeta), String.valueOf(R.drawable.formatadores), String.valueOf(R.drawable.camisa_mecapeta)}
        };

        setTitle(equipesInfos[id][0]);
        txtName.setText(equipesInfos[id][0]);
        txtDesc.setText(equipesInfos[id][1]);

        int escudo =  Integer.parseInt(equipesInfos[id][2]);
        int camisa =  Integer.parseInt(equipesInfos[id][3]);

        imgEscudo.setImageResource(escudo);
        imgCamisa.setImageResource(camisa);

    }
}