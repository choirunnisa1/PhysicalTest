package com.choirunnisa.physicaltest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.choirunnisa.physicaltest.Database.DataHelper;
import com.choirunnisa.physicaltest.MenuUtama.JenisTestActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HasilActivity extends AppCompatActivity {

    TextView tvNama,tvGender,tvJenis,tvSkor,tvHasil, tvUsia;
    ActionBar actionBar;
    private String nama,j_kel,jenis,usia,input,hasil;
    Button btn_Save;

    private DataHelper dataHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Hasil Test Peserta");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        Intent dataIntent = getIntent();
        nama = dataIntent.getStringExtra("nama");
        input = dataIntent.getStringExtra("input");
        usia = dataIntent.getStringExtra("usia");
        jenis = dataIntent.getStringExtra("jenis");
        hasil = dataIntent.getStringExtra("hasil");
        Bundle jkel = getIntent().getExtras();

        tvNama = findViewById(R.id.namaf);
        tvGender = findViewById(R.id.genderf);
        tvJenis = findViewById(R.id.jenisf);
        tvUsia = findViewById(R.id.usiaf);
        tvSkor = findViewById(R.id.skorf);
        tvHasil = findViewById(R.id.hasilf);
        btn_Save = findViewById(R.id.input);

        dataHelper = new DataHelper(this);


        tvNama.setText(nama);
        tvJenis.setText(jenis);
        tvUsia.setText(usia);
        tvSkor.setText(input);
        tvHasil.setText(hasil);
        if(jkel!=null){
            j_kel = jkel.getString("jenis_kelamin");
            tvGender.setText(j_kel);
        }

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData();
                Intent daya = new Intent(HasilActivity.this, MainActivity.class);
                daya.addCategory(Intent.CATEGORY_HOME);
                daya.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(daya);
            }
        });

    }
    private void inputData(){
        nama = ""+tvNama.getText().toString().trim();
        input = ""+tvSkor.getText().toString().trim();
        jenis =""+tvJenis.getText().toString().trim();
        usia = ""+tvUsia.getText().toString().trim();
        hasil = ""+tvHasil.getText().toString().trim();
        j_kel =""+tvGender.getText().toString().trim();

//        String timestamp = ""+System.currentTimeMillis();
        long id = dataHelper.insertData(
                ""+nama,
                ""+jenis,
                ""+j_kel,
                ""+input,
                ""+hasil,
                ""+usia,
                ""+getDateTime()
        );

        Toast.makeText(this,"Data ditambahkan dengan ID : "+id,Toast.LENGTH_SHORT).show();


    }

     @Override
     public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
     }

     @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), JenisTestActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
     private String getDateTime() {

         SimpleDateFormat dateFormat = new SimpleDateFormat(

                 "yyyy-MM-dd HH:mm:ss", Locale.getDefault());

         Date date = new Date();

         return dateFormat.format(date);

     }

}
