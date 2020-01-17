package com.choirunnisa.physicaltest.Kelincahan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.choirunnisa.physicaltest.JenisTestActivity;
import com.choirunnisa.physicaltest.R;

public class HomeAgilityActivity extends AppCompatActivity {
    Button btn_agility;
    TextView tv_agility;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_agility);
        tv_agility = findViewById(R.id.tv_agility);
        btn_agility = findViewById(R.id.btn_agility);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Kelincahan");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_agility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeAgilityActivity.this,TataAgilityActivity.class);
                startActivity(tata);
            }
        });
        btn_agility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeAgilityActivity.this, TestAgilityActivity.class);
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
