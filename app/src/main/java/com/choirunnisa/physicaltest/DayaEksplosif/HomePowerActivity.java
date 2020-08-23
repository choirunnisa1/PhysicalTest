package com.choirunnisa.physicaltest.DayaEksplosif;

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

public class HomePowerActivity extends AppCompatActivity {
    TextView tv_loncat, tv_medicine, tv_standing;
    Button btn_loncat, btn_medicine, btn_standing;
    private ActionBar actionBar;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_power);

        tv_loncat = findViewById(R.id.tv_loncatin);
        tv_medicine = findViewById(R.id.tv_medicine);
        tv_standing = findViewById(R.id.tv_standing);
        btn_loncat = findViewById(R.id.btn_loncatin);
        btn_medicine = findViewById(R.id.btn_medicine);
        btn_standing = findViewById(R.id.btn_standing);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Daya Eksplosif");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_loncat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tataloncatin = new Intent(HomePowerActivity.this, TataLoncatTegakActivity.class);
                startActivity(tataloncatin);
            }
        });
        tv_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tataloncatin = new Intent(HomePowerActivity.this, TataMedicineActivity.class);
                startActivity(tataloncatin);
            }
        });
        tv_standing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tataloncatin = new Intent(HomePowerActivity.this, TataStandingActivity.class);
                startActivity(tataloncatin);
            }
        });

        btn_loncat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomePowerActivity.this, TestLoncatTegakActivity.class);
                startActivity(test);
            }
        });
        btn_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomePowerActivity.this, TestMedicineActivity.class);
                startActivity(test);
            }
        });
        btn_standing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomePowerActivity.this,TestStandingActivity.class);
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
