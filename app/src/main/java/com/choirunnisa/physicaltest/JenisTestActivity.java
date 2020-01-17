package com.choirunnisa.physicaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.choirunnisa.physicaltest.DayaTahan.HomeFitnessActivity;
import com.choirunnisa.physicaltest.Kecepatan.HomeLariActivity;
import com.choirunnisa.physicaltest.Kekuatan.HomeLenganActivity;
import com.choirunnisa.physicaltest.Kelincahan.HomeAgilityActivity;
import com.choirunnisa.physicaltest.Keseimbangan.HomeStrockActivity;

public class JenisTestActivity extends AppCompatActivity {
    Button btn_daya,btn_lincah,btn_seimbang,btn_kuat,btn_cepat,btn_lainnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_test);

        btn_daya = findViewById(R.id.daya_tahan);
        btn_lincah = findViewById(R.id.kelincahan);
        btn_seimbang = findViewById(R.id.keseimbangan);
        btn_kuat = findViewById(R.id.kekuatan);
        btn_cepat = findViewById(R.id.kecepatan);
        btn_lainnya = findViewById(R.id.lainnya);
        
        btn_daya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daya = new Intent(JenisTestActivity.this, HomeFitnessActivity.class);
                startActivity(daya);
            }
        });
        btn_cepat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cepat = new Intent(JenisTestActivity.this, HomeLariActivity.class);
                startActivity(cepat);
            }
        });
        btn_kuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lengan = new Intent(JenisTestActivity.this, HomeLenganActivity.class);
                startActivity(lengan);
            }
        });
        btn_lincah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lincah = new Intent(JenisTestActivity.this, HomeAgilityActivity.class);
                startActivity(lincah);
            }
        });
        btn_seimbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seimbang = new Intent(JenisTestActivity.this, HomeStrockActivity.class);
                startActivity(seimbang);
            }
        });
        btn_lainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(JenisTestActivity.this,"Sedang dalam perkembangan... ",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        home.addCategory(Intent.CATEGORY_HOME);
        home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }
}
