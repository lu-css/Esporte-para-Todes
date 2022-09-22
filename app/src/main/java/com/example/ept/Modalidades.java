package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class Modalidades extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidades);

    }

    public void futsal(View view){
        gotoLink("https://www.google.com/url?sa=t&source=web&rct=j&url=https://ligafutsal.com.br/documentos/regras-do-jogo-de-futsal-2022-fifa/&ved=2ahUKEwi1-vKV4qb6AhXvu5UCHddoBMsQFnoECBUQAQ&usg=AOvVaw2x_iAZDzpB3_UDCOPvUJya");
    }

    public void voileibol(View view){
        gotoLink("https://www.google.com/url?sa=t&source=web&rct=j&url=https://institucional.cbv.com.br/arquivos/regra_2021-2024.pdf&ved=2ahUKEwi0zqqM46b6AhUQrZUCHfBYAUIQFnoECAsQAQ&usg=AOvVaw3e98EKTRaHc22F5g9PNrwJ");
    }
    public void basquetebol(View view){
        gotoLink("https://www.google.com/url?sa=t&source=web&rct=j&url=https://www.cbb.com.br/wp-content/uploads/Regras-Oficiais-de-Basketball-FIBA-2020-Traduzida-para-Portugues.pdf&ved=2ahUKEwio_vae46b6AhXFvJUCHSh5DOMQFnoECBcQAQ&usg=AOvVaw2-Yk0LJk8NlzO0MqgoQ_WZ");
    }
    public void queimada(View view){
        gotoLink("https://www.google.com/url?sa=t&source=web&rct=j&url=http://www.jiunbs.unb.br/images/PDF/QUEIMADA-Regras.pdf&ved=2ahUKEwjQ-pev46b6AhUCtJUCHelUAJ8QFnoECA0QAQ&usg=AOvVaw3OtMBG6yqBNuqcQIWv1QPW");
    }
    public void handbol(View view){
        gotoLink("https://www.google.com/url?sa=t&source=web&rct=j&url=https://files.cercomp.ufg.br/weby/up/155/o/REGRAS_HANDEBOL.pdf&ved=2ahUKEwj7_5W946b6AhUWg5UCHaOTD_UQFnoECA0QAQ&usg=AOvVaw0tXUER1nB0SRtVI5HD3ID9");
    }
    private void gotoLink(String link){
        Uri uri = Uri.parse(link);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));

    }

}