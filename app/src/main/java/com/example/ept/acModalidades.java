package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class acModalidades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_modalidades);
    }

    public void futsal(){
        gotoLink(getResources().getString(R.string.link_futsal));
    }

    public void voileibol(){
        gotoLink(getResources().getString(R.string.link_voileibol));
    }
    public void basquetebol(){
        gotoLink(getResources().getString(R.string.link_basquetebol));
    }
    public void queimada(){
        gotoLink(getResources().getString(R.string.link_queimada));
    }
    public void handbol(){
        gotoLink(getResources().getString(R.string.link_handbol));
    }
    private void gotoLink(String link){
        Uri uri = Uri.parse(link);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(Intent.createChooser(it, getString(R.string.chNavegador)));

    }
}