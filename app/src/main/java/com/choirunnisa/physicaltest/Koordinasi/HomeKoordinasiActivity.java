package com.choirunnisa.physicaltest.Koordinasi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.choirunnisa.physicaltest.MenuUtama.JenisTestActivity;
import com.choirunnisa.physicaltest.R;

public class HomeKoordinasiActivity extends AppCompatActivity {
    TextView tv_squat;
    Button btn_squat;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_koordinasi);
        tv_squat = findViewById(R.id.tv_squat);
        btn_squat = findViewById(R.id.btn_squat);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Koordinasi");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeKoordinasiActivity.this, TataSquadActivity.class);
                startActivity(tata);
            }
        });
        btn_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeKoordinasiActivity.this, TestSquadActivity.class);
                startActivity(test);
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        Intent jenis = new Intent(getApplicationContext(), JenisTestActivity.class);
        jenis.addCategory(Intent.CATEGORY_HOME);
        jenis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(jenis);
    }
}
