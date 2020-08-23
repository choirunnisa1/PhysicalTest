package com.choirunnisa.physicaltest.Reaksi;

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

import com.choirunnisa.physicaltest.AdapterApps.TangkapPenggarisAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.TangkapModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TesPenggarisActivity extends AppCompatActivity {

    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_penggaris);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);


        actionBar = getSupportActionBar();
        actionBar.setTitle("Tangkap Penggaris Tes");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);
        TangkapPenggarisAdapter adapter = new TangkapPenggarisAdapter(getTangkapList());
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


                    if (input == 0 || input<=6) {
                        hasil = "Sangat Baik";
                    } else if (input == 7 || input <= 12) {
                        hasil = "Baik";
                    } else if (input == 13 || input <= 18) {
                        hasil = "Sedang";
                    } else if (input == 19 || input <= 24) {
                        hasil = "Kurang";
                    } else if (input == 25 || input <= 30){
                        hasil = "Sangat Kurang";
                    } else hasil =  "Tidak terdefinisi";


                    if (rb_laki.isChecked()) {
                        str = "Laki-laki";
                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                    }

                    Intent intent = new Intent(TesPenggarisActivity.this, HasilActivity.class);
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

    private List getTangkapList() {
        List TangkapList = new ArrayList<>();

        TangkapList.add(new TangkapModel(1, "Baik Sekali", "0-6"));
        TangkapList.add(new TangkapModel(2, "Baik", "7-12"));
        TangkapList.add(new TangkapModel(3, "Sedang", "13-18"));
        TangkapList.add(new TangkapModel(4, "Kurang", "19-24"));
        TangkapList.add(new TangkapModel(5, "Sangat Kurang", "25-30"));


        return TangkapList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
