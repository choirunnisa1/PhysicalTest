package com.choirunnisa.physicaltest.Kelentukan;

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

import com.choirunnisa.physicaltest.AdapterApps.TrunkandNextAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.TrunkModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TestTrunkActivity extends AppCompatActivity {
    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_trunk);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Trunk and Neck Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);
        TrunkandNextAdapter adapter = new TrunkandNextAdapter(getTrunkList());
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
                        if (input >10) {
                            hasil = "Baik Sekali";
                        } else if (input >= 8 && input <= 10) {
                            hasil = "Baik";
                        } else if (input >=6 && input <= 7.99) {
                            hasil = "Rata-rata";
                        } else if (input >=3 && input <= 5.99) {
                            hasil = "Cukup";
                        } else hasil = "Tak terdefinisi";

                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                        if (input > 9.75) {
                            hasil = "Baik Sekali";
                        } else if (input >= 7.75 && input <= 9.75) {
                            hasil = "Baik";
                        } else if (input >= 5.74 && input <= 7.75) {
                            hasil = "Rata-rata";
                        } else if (input >= 2 && input <= 5.74) {
                            hasil = "Cukup";
                        } else hasil = "Tak terdefinisi";
                    }

                    Intent intent = new Intent(TestTrunkActivity.this, HasilActivity.class);

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

    private List getTrunkList() {
        List trunkList = new ArrayList<>();

        trunkList.add(new TrunkModel(2, "Cukup", ">10",">9.75"));
        trunkList.add(new TrunkModel(3, "Sedang", "10-8","9.75-7.75"));
        trunkList.add(new TrunkModel(4, "Baik", "7.99-6","7.74-5.75"));
        trunkList.add(new TrunkModel(5, "Baik Sekali", "5.99-3","5.74-2"));

        return trunkList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
