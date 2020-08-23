package com.choirunnisa.physicaltest.Kekuatan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.choirunnisa.physicaltest.MenuUtama.JenisTestActivity;
import com.choirunnisa.physicaltest.R;

public class HomeLenganActivity extends AppCompatActivity {
    private ActionBar actionBar;
    TextView tv_leg_dina;
    Button btn_leg_dina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lengan);

        tv_leg_dina = findViewById(R.id.tv_leg_dina);
        btn_leg_dina = findViewById(R.id.btn_leg_dina);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Kekuatan");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_leg_dina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeLenganActivity.this, TataLenganActivity.class);
                startActivity(tata);
            }
        });
        btn_leg_dina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeLenganActivity.this, TestLenganActivity.class);
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
