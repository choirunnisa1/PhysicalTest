package com.choirunnisa.physicaltest.MenuUtama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.choirunnisa.physicaltest.DayaEksplosif.HomePowerActivity;
import com.choirunnisa.physicaltest.DayaTahan.HomeFitnessActivity;
import com.choirunnisa.physicaltest.Kecepatan.HomeLariActivity;
import com.choirunnisa.physicaltest.Kekuatan.HomeLenganActivity;
import com.choirunnisa.physicaltest.Kelentukan.HomeKelentukanActivity;
import com.choirunnisa.physicaltest.Kelincahan.HomeAgilityActivity;
import com.choirunnisa.physicaltest.Keseimbangan.HomeStrockActivity;
import com.choirunnisa.physicaltest.Ketepatan.HomeKetepatanActivity;
import com.choirunnisa.physicaltest.Koordinasi.HomeKoordinasiActivity;
import com.choirunnisa.physicaltest.MainActivity;
import com.choirunnisa.physicaltest.R;
import com.choirunnisa.physicaltest.Reaksi.HomeReaksiActivity;

public class JenisTestActivity extends AppCompatActivity {
    Button btn_daya,btn_lincah,btn_seimbang,btn_kuat,btn_cepat,btn_tetap, btn_reaksi,btn_koor,btn_lentuk,btn_dayae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_test);

        btn_daya = findViewById(R.id.daya_tahan);
        btn_lincah = findViewById(R.id.kelincahan);
        btn_seimbang = findViewById(R.id.keseimbangan);
        btn_kuat = findViewById(R.id.kekuatan);
        btn_cepat = findViewById(R.id.kecepatan);
        btn_koor = findViewById(R.id.koordinasi);
        btn_lentuk = findViewById(R.id.kelentukan);
        btn_tetap = findViewById(R.id.ketetapan);
        btn_reaksi = findViewById(R.id.reaksi);
        btn_dayae = findViewById(R.id.daya);
        
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
        btn_koor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seimbang = new Intent(JenisTestActivity.this, HomeKoordinasiActivity.class);
                startActivity(seimbang);

            }
        });
        btn_reaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seimbang = new Intent(JenisTestActivity.this, HomeReaksiActivity.class);
                startActivity(seimbang);

            }
        });
        btn_dayae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seimbang = new Intent(JenisTestActivity.this, HomePowerActivity.class);
                startActivity(seimbang);

            }
        });
        btn_lentuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seimbang = new Intent(JenisTestActivity.this, HomeKelentukanActivity.class);
                startActivity(seimbang);

            }
        });
        btn_tetap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seimbang = new Intent(JenisTestActivity.this, HomeKetepatanActivity.class);
                startActivity(seimbang);

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
