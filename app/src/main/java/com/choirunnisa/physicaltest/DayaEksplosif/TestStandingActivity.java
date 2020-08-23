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

import com.choirunnisa.physicaltest.AdapterApps.StandingAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.StandingModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TestStandingActivity extends AppCompatActivity {

    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_standing);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Standing Long Jump Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);
        StandingAdapter adapter = new StandingAdapter(getStandingList());
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
                        if (input>250) {
                            hasil = "Baik Sekali";
                        } else if (input == 241 || input <= 250) {
                            hasil = "Baik";
                        } else if (input == 231 || input <= 240) {
                            hasil = "Cukup";
                        } else if (input == 221 || input <= 230) {
                            hasil = "Sedang";
                        } else hasil =  "Tidak terdefinisi";
                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                        if (input>200) {
                            hasil = "Baik Sekali";
                        } else if (input == 191 || input <= 200) {
                            hasil = "Baik";
                        } else if (input == 181 || input <= 190) {
                            hasil = "Cukup";
                        } else if (input == 171 || input <= 180) {
                            hasil = "Sedang";
                        } else hasil =  "Tidak terdefinisi";
                    }

                    Intent intent = new Intent(TestStandingActivity.this, HasilActivity.class);
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

    private List getStandingList() {
        List StandingList = new ArrayList<>();
        StandingList.add(new StandingModel(1, "Sedang", "221-230","171-180"));
        StandingList.add(new StandingModel(2, "Cukup", "231-240","191-200"));
        StandingList.add(new StandingModel(3, "Baik", "241-250","181-190"));
        StandingList.add(new StandingModel(4, "Baik Sekali", ">250",">200"));

        return StandingList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
