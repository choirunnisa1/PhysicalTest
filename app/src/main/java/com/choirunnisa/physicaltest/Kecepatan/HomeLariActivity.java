package com.choirunnisa.physicaltest.Kecepatan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.choirunnisa.physicaltest.JenisTestActivity;
import com.choirunnisa.physicaltest.R;

public class HomeLariActivity extends AppCompatActivity {
    TextView tv_lari;
    Button btn_lari;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lari);
        tv_lari = findViewById(R.id.tv_lari);
        btn_lari = findViewById(R.id.btn_lari);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Kecepatan");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_lari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeLariActivity.this, TataLariActivity.class);
                startActivity(tata);
            }
        });
        btn_lari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeLariActivity.this, TestLariActivity.class);
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
