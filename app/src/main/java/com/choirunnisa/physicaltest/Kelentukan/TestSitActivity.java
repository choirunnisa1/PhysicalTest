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

import com.choirunnisa.physicaltest.AdapterApps.SitAndReachAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.SitModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TestSitActivity extends AppCompatActivity {

    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sit);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);


        actionBar = getSupportActionBar();
        actionBar.setTitle("Sit and Reach Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);
        SitAndReachAdapter adapter = new SitAndReachAdapter(getsitList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = findViewById(R.id.recyclerViewDeliveryProductList2);
        SitAndReachAdapter adapter2 = new SitAndReachAdapter(getsitList2());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(adapter2);

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

                    int usia = Integer.parseInt(opUsia);

                    if (usia >= 20){
                        if (rb_laki.isChecked()) {
                            str = "Laki-laki";
                            if (input > 28 ) {
                                hasil = "Sangat Baik";
                            } else if (input >=24  && input <=28) {
                                hasil = "Baik";
                            } else if (input >=20  && input <=23) {
                                hasil = "Rata-rata";
                            } else if (input >=17 && input <=19) {
                                hasil = "Kurang";
                            } else if (input<17){
                                hasil = "Sangat Kurang";
                            }
                        } else if (rb_perempuan.isChecked()) {
                            str = "Perempuan";
                            if (input > 35 ) {
                                hasil = "Sangat Baik";
                            } else if (input >=32  && input <=35) {
                                hasil = "Baik";
                            } else if (input >=31  && input <=30) {
                                hasil = "Rata-rata";
                            } else if (input >=25 && input <=29) {
                                hasil = "Kurang";
                            } else if (input<25){
                                hasil = "Sangat Kurang";
                            }
                        }
                    } else if(usia>=16 && usia<=19){
                        if(rb_laki.isChecked()){
                            str = "Laki-laki";
                            if (input > 14 ) {
                                hasil = "Sangat Baik";
                            } else if (input >=11  && input <=14) {
                                hasil = "Baik";
                            } else if (input >=7  && input <=10) {
                                hasil = "Rata-rata";
                            } else if (input >=4 && input <=6) {
                                hasil = "Kurang";
                            } else if (input<4){
                                hasil = "Sangat Kurang";
                            }

                        }
                        else if(rb_perempuan.isChecked()){
                            str = "Perempuan";
                            if (input > 15 ) {
                                hasil = "Sangat Baik";
                            } else if (input >=12  && input <=15) {
                                hasil = "Baik";
                            } else if (input >=7  && input <=11) {
                                hasil = "Rata-rata";
                            } else if (input >=4 && input <=6) {
                                hasil = "Kurang";
                            } else if (input<4){
                                hasil = "Sangat Kurang";
                            }
                        }
                    }






                    Intent intent = new Intent(TestSitActivity.this, HasilActivity.class);
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

    private List getsitList() {
        List sitList = new ArrayList<>();

        sitList.add(new SitModel(1, "Baik Sekali", ">14",">15"));
        sitList.add(new SitModel(2, "Baik", "11-14","12-15"));
        sitList.add(new SitModel(3, "Rata-Rata", "7-10","7-11"));
        sitList.add(new SitModel(4, "Kurang", "4-6","4-6"));
        sitList.add(new SitModel(5, "Sangat Kurang", "<4","<4"));


        return sitList;
    }

    private List getsitList2() {
        List sitList = new ArrayList<>();

        sitList.add(new SitModel(1, "Baik Sekali", ">28",">35"));
        sitList.add(new SitModel(2, "Baik", "24-28","32-35"));
        sitList.add(new SitModel(3, "Rata-Rata", "20-23","30-31"));
        sitList.add(new SitModel(4, "Kurang", "17-19","25-29"));
        sitList.add(new SitModel(5, "Sangat Kurang", "<17","<25"));


        return sitList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
