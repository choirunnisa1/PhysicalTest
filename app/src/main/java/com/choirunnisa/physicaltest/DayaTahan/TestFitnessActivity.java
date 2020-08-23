package com.choirunnisa.physicaltest.DayaTahan;

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

import com.choirunnisa.physicaltest.AdapterApps.FitnessAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.FitnesModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TestFitnessActivity extends AppCompatActivity {

    Button buttonSave;
    //    String gender;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fitness);

        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Test Multi Fitness");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        FitnessAdapter adapter = new FitnessAdapter(getFitnessList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNama = (EditText) findViewById(R.id.nama);
                String opName = editNama.getText().toString();
                EditText editJenis = (EditText) findViewById(R.id.jenis);
                String opJenis = editJenis.getText().toString();
                EditText editinput = (EditText) findViewById(R.id.input);
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
                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                    }

                    if (input <= 28) {
                        hasil = "Kurang Sekali";
                    } else if (input == 28 || input <= 34) {
                        hasil = "Kurang";
                    } else if (input == 34 || input == 42) {
                        hasil = "Sedang";
                    } else if (input > 42 || input == 52) {
                        hasil = "Baik";
                    } else if (input > 52) {
                        hasil = ("Baik Sekali");
                    }

                    Intent intent = new Intent(TestFitnessActivity.this, HasilActivity.class);

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
    private List getFitnessList() {
        List fitnessList = new ArrayList<>();

        fitnessList.add(new FitnesModel("Sangat Buruk", "<25.0", "<25.0","<25.0",""));
        fitnessList.add(new FitnesModel("Buruk", "25.0-33.7", "25.0-30.1","25.0-26.4","<25.0"));
        fitnessList.add(new FitnesModel("Sedang", "33.8-42.5", "30.2-39.1","26.5-35.4","25.0-33.7"));
        fitnessList.add(new FitnesModel("Baik", "42.6-51.5", "39-48","35.5-45.0","33.8-43.0"));
        fitnessList.add(new FitnesModel("Sangat Baik", ">51.6", ">48",">45.1",">43.1"));

        return fitnessList;
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
