package com.choirunnisa.physicaltest.Keseimbangan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.choirunnisa.physicaltest.AdapterApps.FitnessAdapter;
import com.choirunnisa.physicaltest.AdapterApps.StrockAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.Kelincahan.TestAgilityActivity;
import com.choirunnisa.physicaltest.ModelApps.AgiltyModel;
import com.choirunnisa.physicaltest.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.List;

public class TestStrockActivity extends AppCompatActivity {
    private ActionBar actionBar;

    Button buttonSave;
    //    String gender;

    RadioButton rb_laki, rb_perempuan;
    String str, h_jenis;
    String hasil;
    Spinner spinner;
    String[] jenis = new String[]{"~ pilih jenis ~", "berdiri dengan kaki kanan", "berdiri dengan kaki kiri"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_strock);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);

        spinner = findViewById(R.id.jenis);

        ArrayAdapter<String> request = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jenis);
        request.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(request);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Test Berdiri dengan Satu Kaki");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);
        StrockAdapter adapter = new StrockAdapter(getKananList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        RecyclerView recyclerView2 = findViewById(R.id.recyclerViewDeliveryProductList2);
        StrockAdapter adapter2 = new StrockAdapter(getKiriList());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(adapter2);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNama = (EditText) findViewById(R.id.nama);
                String opName = editNama.getText().toString();
                EditText editinput = (EditText) findViewById(R.id.input);
                String opInput = editinput.getText().toString();
                RadioGroup rb_fitness = findViewById(R.id.jk);


                if (opName.equals("") || opInput.length() == 0 || rb_fitness.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Mohon Lengkapi Terlebih Dahulu",
                            Toast.LENGTH_SHORT).show();

                } else {

                    if (spinner.getSelectedItem().toString().equals("berdiri dengan kaki kanan")) {
                        h_jenis = "Tes berdiri satu kaki (kanan) dengan mata tertutup";
                        double input = Double.parseDouble(opInput);
                        if (rb_laki.isChecked()) {
                            str = "Laki-laki";
                            if (input > 50) {
                                hasil = "Sempurna";
                            } else if (input >= 41 && input <= 50) {
                                hasil = "Di atas rata-rata";
                            } else if (input >= 31 && input <= 40) {
                                hasil = "Rata-rata";
                            } else if (input >= 20 && input <=30) {
                                hasil = "Di bawah Rata-rata";
                            } else if (input<20) {
                                hasil = "Kurang";
                            }

                        } else if (rb_perempuan.isChecked()) {
                            str = "Perempuan";
                            if (input > 30) {
                                hasil = "Sempurna";
                            } else if (input >= 23 && input <= 30) {
                                hasil = "Di atas rata-rata";
                            } else if (input >= 16 && input <= 22) {
                                hasil = "Rata-rata";
                            } else if (input >= 10 && input <=15) {
                                hasil = "Di bawah Rata-rata";
                            } else if (input<10) {
                                hasil = "Kurang";
                            }
                        }

                    } else if (spinner.getSelectedItem().toString().equals("berdiri dengan kaki kiri")) {
                        h_jenis = "Tes berdiri satu kaki (kiri) dengan mata tertutup";
                        double input = Double.parseDouble(opInput);
                        if (rb_laki.isChecked()) {
                            str = "Laki-laki";
                            if (input > 50) {
                                hasil = "Sempurna";
                            } else if (input >= 37 && input <= 50) {
                                hasil = "Di atas rata-rata";
                            } else if (input >= 15 && input <= 36) {
                                hasil = "Rata-rata";
                            } else if (input >= 5 && input <=14) {
                                hasil = "Di bawah Rata-rata";
                            } else if (input<5) {
                                hasil = "Kurang";
                            }

                        } else if (rb_perempuan.isChecked()) {
                            str = "Perempuan";
                            if (input > 27) {
                                hasil = "Sempurna";
                            } else if (input >= 23 && input <= 27) {
                                hasil = "Di atas rata-rata";
                            } else if (input >= 8 && input <= 22) {
                                hasil = "Rata-rata";
                            } else if (input >= 3 && input <=7) {
                                hasil = "Di bawah Rata-rata";
                            } else if (input<3) {
                                hasil = "Kurang";
                            }
                        }
                    }
                    
                    

                    Intent intent = new Intent(TestStrockActivity.this, HasilActivity.class);

                    intent.putExtra("nama", opName);
                    intent.putExtra("input", opInput);
                    intent.putExtra("hasil", hasil);
                    intent.putExtra("jenis", h_jenis);
                    intent.putExtra("jenis_kelamin", str);
                    startActivity(intent);
                }
            }
        });


    }

    private List getKananList() {
        List kananList = new ArrayList<>();

        kananList.add(new AgiltyModel(1, "Kurang","<20","<10"));
        kananList.add(new AgiltyModel(2, "Di Bawah Rata-Rata","20-30","10-15"));
        kananList.add(new AgiltyModel(3, "Rata-Rata","31-40","16-22"));
        kananList.add(new AgiltyModel(4,  "Di Atas Rata-Rata","41-50","23-30"));
        kananList.add(new AgiltyModel(5, "Sempurna",">50",">30"));

        return kananList;
    }

    private List getKiriList() {
        List kiriList = new ArrayList<>();

        kiriList.add(new AgiltyModel(1,  "Kurang","<5","<3"));
        kiriList.add(new AgiltyModel(2, "Di Bawah Rata-Rata","5-14","3-7"));
        kiriList.add(new AgiltyModel(3,  "Rata-Rata","15-36","8-22"));
        kiriList.add(new AgiltyModel(4,  "Di Atas Rata-Rata","37-50","23-27"));
        kiriList.add(new AgiltyModel(5,  "Sempurna",">50",">27"));

        return kiriList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
