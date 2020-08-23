package com.choirunnisa.physicaltest.Kelentukan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.choirunnisa.physicaltest.DayaTahan.HomeFitnessActivity;
import com.choirunnisa.physicaltest.DayaTahan.TataFitnessActivity;
import com.choirunnisa.physicaltest.DayaTahan.TestFitnessActivity;
import com.choirunnisa.physicaltest.MenuUtama.JenisTestActivity;
import com.choirunnisa.physicaltest.R;

public class HomeKelentukanActivity extends AppCompatActivity {
    TextView tv_sit, tv_trunk;
    Button btn_sit, btn_trunk;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kelentukan);
        tv_sit = findViewById(R.id.tv_sit);
        tv_trunk = findViewById(R.id.tv_trunk);
        btn_sit = findViewById(R.id.btn_sit);
        btn_trunk = findViewById(R.id.btn_trunk);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Kelentukan");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_sit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeKelentukanActivity.this, TataSitActivity.class);
                startActivity(tata);
            }
        });
        tv_trunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeKelentukanActivity.this, TataTrunkActivity.class);
                startActivity(tata);
            }
        });
        btn_sit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeKelentukanActivity.this, TestSitActivity.class);
                startActivity(test);
            }
        });
        btn_trunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeKelentukanActivity.this, TestTrunkActivity.class);
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
