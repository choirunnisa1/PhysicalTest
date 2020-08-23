package com.choirunnisa.physicaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.choirunnisa.physicaltest.Hasil.LihatDataActivity;
import com.choirunnisa.physicaltest.MenuUtama.JenisTestActivity;
import com.choirunnisa.physicaltest.MenuUtama.ReferensiActivity;
import com.choirunnisa.physicaltest.MenuUtama.TentangActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_physical, btn_data, btn_tentang,btn_referensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_physical = findViewById(R.id.physic);
        btn_data = findViewById(R.id.data);
        btn_tentang = findViewById(R.id.tentang);
        btn_referensi = findViewById(R.id.dapus);

        btn_physical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent physic = new Intent(MainActivity.this, JenisTestActivity.class);
                startActivity(physic);
            }
        });
        btn_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, LihatDataActivity.class);
                startActivity(data);
            }
        });
        btn_tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tentang = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(tentang);
            }
        });
        btn_referensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dapus = new Intent(MainActivity.this, ReferensiActivity.class);
                startActivity(dapus);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
