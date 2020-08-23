package com.choirunnisa.physicaltest.Keseimbangan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.choirunnisa.physicaltest.MenuUtama.JenisTestActivity;
import com.choirunnisa.physicaltest.R;

public class HomeStrockActivity extends AppCompatActivity {
    private ActionBar actionBar;
    TextView tv_strock;
    Button btn_strock;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_strock);
        tv_strock = findViewById(R.id.tv_strock);
        btn_strock = findViewById(R.id.btn_strock);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Keseimbangan");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tv_strock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tata = new Intent(HomeStrockActivity.this, TataStrockActivity.class);
                startActivity(tata);
            }
        });
        btn_strock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(HomeStrockActivity.this, TestStrockActivity.class);
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
