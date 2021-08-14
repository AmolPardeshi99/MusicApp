package com.example.apmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnSongClicked {

    private RecyclerView recyclerView;
    private ArrayList<MusicModel> musiclist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildList();
        setRecyclerview();
    }

    private void setRecyclerview() {
        MusicAdapter musicAdapter = new MusicAdapter(musiclist, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(musicAdapter);
    }

    private void buildList() {
        int t = 2;
        while (t-- > 0) {
            MusicModel musicModel = new MusicModel(R.drawable.iv_bandeya_re, "Bandeya re Bandeya");
            musiclist.add(musicModel);
            MusicModel musicModel2 = new MusicModel(R.drawable.iv_bharat_ki_beti, "Bharat Ki Beti");
            musiclist.add(musicModel2);
            MusicModel musicModel3 = new MusicModel(R.drawable.iv_challa_uri, "Challa - URI");
            musiclist.add(musicModel3);
            MusicModel musicModel4 = new MusicModel(R.drawable.iv_dhaga_aspirants, "Dhaga Aspirants");
            musiclist.add(musicModel4);
            MusicModel musicModel5 = new MusicModel(R.drawable.iv_giveme_sunshine, "Give me Some Sunshine");
            musiclist.add(musicModel5);
            MusicModel musicModel6 = new MusicModel(R.drawable.iv_liggi_ritviz, "Liggi - Ritviz");
            musiclist.add(musicModel6);
            MusicModel musicModel7 = new MusicModel(R.drawable.iv_manzar_hai_naya, "Manzar hai Naya");
            musiclist.add(musicModel7);
            MusicModel musicModel8 = new MusicModel(R.drawable.iv_nazm_nazm, "Nazm Nazm sa");
            musiclist.add(musicModel8);
            MusicModel musicModel9 = new MusicModel(R.drawable.iv_shabashiyan, "Shabashiyan - Mission Mangal");
            musiclist.add(musicModel9);
            MusicModel musicModel10 = new MusicModel(R.drawable.iv_teri_mitti, "Teri Mitti - Kesari");
            musiclist.add(musicModel10);
        }
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
    }

    @Override
    public void onSongClicked(MusicModel musicModel, int position) {
        Intent intent = new Intent(MainActivity.this, PlayMusicActivity.class);
        intent.putExtra("MusicName", musicModel.getSongName());
        intent.putExtra("MusicImage", musicModel.getImage());
        startActivity(intent);
    }
}