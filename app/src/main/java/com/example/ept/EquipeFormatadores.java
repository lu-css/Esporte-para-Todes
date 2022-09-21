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
//        TextView txtName = (TextView) this.findViewById(R.id.nomeEquipe);

        String[][] equipesInfos = {
                {getResources().getString(R.string.formatadores), getResources().getString(R.string.descricaoformatadores), "imgpath"},
                {"DST", "descrição", "imgpath"},
                {"Jogostosos", "descrição", "imgpath"},
                {"Mecapeta", "descrição", "imgpath"}
        };

        setTitle(equipesInfos[id][0]);
        txtName.setText(equipesInfos[id][0]);
        txtDesc.setText(equipesInfos[id][1]);

    }
}