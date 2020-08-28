package com.choirunnisa.physicaltest.Ketepatan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.choirunnisa.physicaltest.MenuUtama.JenisTestActivity;
import com.choirunnisa.physicaltest.R;

public class HomeKetepatanActivity extends AppCompatActivity {
    TextView tv_overhand;
    Button btn_overhand;
    private ActionBar actionBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ketepatan);
        tv_overhand = findViewById(R.id.tv_overhand);
        btn_overhand = findViewById(R.id.btn_overhand);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Ketepatan");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_overhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeKetepatanActivity.this, TataOverhandActivity.class);
                startActivity(tata);
            }
        });
        btn_overhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeKetepatanActivity.this, TestOverhandActivity.class);
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
