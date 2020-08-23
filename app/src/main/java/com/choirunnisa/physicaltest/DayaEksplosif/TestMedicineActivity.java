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

import com.choirunnisa.physicaltest.AdapterApps.MedicineAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.MedicineModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TestMedicineActivity extends AppCompatActivity {

    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_medicine);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Medicine Ball Push Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        MedicineAdapter adapter = new MedicineAdapter(getMedicineList());

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
                        if (input>26) {
                            hasil = "Baik Sekali";
                        } else if (input == 22 || input <= 25) {
                            hasil = "Baik";
                        } else if (input == 14 || input <= 21) {
                            hasil = "Cukup";
                        } else if (input == 10 || input <= 13) {
                            hasil = "Kurang";
                        } else hasil =  "Tidak terdefinisi";
                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                        if (input>15) {
                            hasil = "Baik Sekali";
                        } else if (input == 13 || input <= 14) {
                            hasil = "Baik";
                        } else if (input == 8 || input <= 12) {
                            hasil = "Cukup";
                        } else if (input == 5 || input <= 7) {
                            hasil = "Kurang";
                        } else hasil =  "Tidak terdefinisi";
                    }

                    Intent intent = new Intent(TestMedicineActivity.this, HasilActivity.class);
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

    private List getMedicineList() {
        List MedicineList = new ArrayList<>();
        MedicineList.add(new MedicineModel(1, "Kurang", "10-13","5-7"));
        MedicineList.add(new MedicineModel(2, "Cukup", "14-21","8-12"));
        MedicineList.add(new MedicineModel(3, "Baik", "22-25","13-14"));
        MedicineList.add(new MedicineModel(4, "Baik Sekali", ">26",">15"));

        return MedicineList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
