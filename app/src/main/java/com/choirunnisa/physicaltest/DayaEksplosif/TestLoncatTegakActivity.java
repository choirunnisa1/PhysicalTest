package com.choirunnisa.physicaltest.DayaEksplosif;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.choirunnisa.physicaltest.AdapterApps.LoncatAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.LoncatModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TestLoncatTegakActivity extends AppCompatActivity {

    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_loncat_tegak);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Loncat Accuracy Throw Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        LoncatAdapter adapter = new LoncatAdapter(getLoncatList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

//        cameraPermission = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
//        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNama = (EditText) findViewById(R.id.nama);
                String opName = editNama.getText().toString();
                EditText editJenis = (EditText) findViewById(R.id.jenis);
                String opJenis = editJenis.getText().toString();
                EditText editinput = (EditText) findViewById(R.id.skor);
                String opInput = editinput.getText().toString();
                RadioGroup rb_fitness = findViewById(R.id.jk);
                EditText editUsia = findViewById(R.id.usia);
                String opUsia = editUsia.getText().toString();


                if (opName.equals("") || opInput.length() == 0 || rb_fitness.getCheckedRadioButtonId() == -1 || opUsia.equals("")) {
                    Toast.makeText(getApplicationContext(), "Mohon Lengkapi Terlebih Dahulu",
                            Toast.LENGTH_SHORT).show();
                } else {


                    double input = Double.parseDouble(opInput);

                    if (rb_laki.isChecked()) {
                        str = "Laki-laki";
                        if (input>70) {
                            hasil = "Sempurna";
                        } else if (input == 62 || input <= 69) {
                            hasil = "Baik Sekali";
                        } else if (input == 53 || input <= 61) {
                            hasil = "Baik";
                        } else if (input == 46 || input <= 52) {
                            hasil = "Cukup";
                        } else if (input == 38 || input <= 45){
                            hasil = "Kurang";
                        } else hasil =  "Tidak terdefinisi";
                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                        if (input>48) {
                            hasil = "Sempurna";
                        } else if (input == 44 || input <= 47) {
                            hasil = "Baik Sekali";
                        } else if (input == 38 || input <= 43) {
                            hasil = "Baik";
                        } else if (input == 33 || input <= 37) {
                            hasil = "Cukup";
                        } else if (input == 29 || input <= 32){
                            hasil = "Kurang";
                        } else hasil =  "Tidak terdefinisi";
                    }

                    Intent intent = new Intent(TestLoncatTegakActivity.this, HasilActivity.class);
                    intent.putExtra("nama", opName);
                    intent.putExtra("jenis", opJenis);
                    intent.putExtra("input", opInput);
                    intent.putExtra("hasil", hasil);
                    intent.putExtra("usia",opUsia);
                    intent.putExtra("jenis_kelamin", str);
                    startActivity(intent);
                }
            }
        });


    }

    private List getLoncatList() {
        List LoncatList = new ArrayList<>();

        LoncatList.add(new LoncatModel(1, "Sempurna", ">70",">48"));
        LoncatList.add(new LoncatModel(2, "Baik Sekali", "62-69","44-47"));
        LoncatList.add(new LoncatModel(3, "Baik", "53-61","38-43"));
        LoncatList.add(new LoncatModel(4, "Cukup", "46-52","33-37"));
        LoncatList.add(new LoncatModel(5, "Kurang", "38-45","29-32"));


        return LoncatList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
