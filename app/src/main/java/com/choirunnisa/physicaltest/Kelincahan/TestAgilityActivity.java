package com.choirunnisa.physicaltest.Kelincahan;

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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.choirunnisa.physicaltest.AdapterApps.TableViewAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.AgiltyModel;
import com.choirunnisa.physicaltest.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.List;

public class TestAgilityActivity extends AppCompatActivity {


    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_agility);

        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);


        actionBar = getSupportActionBar();
        actionBar.setTitle("Test Agility T-Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        TableViewAdapter adapter = new TableViewAdapter(getAgilityList());

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


                if (opName.equals("") || opInput.length() == 0 || rb_fitness.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Mohon Lengkapi Terlebih Dahulu",
                            Toast.LENGTH_SHORT).show();
                } else {


                    double input = Double.parseDouble(opInput);


                    if (rb_laki.isChecked()) {
                        str = "Laki-laki";
                        if (input < 9.5) {
                            hasil = "Sangat Baik";
                        } else if (input == 9.5 || input <= 10.5) {
                            hasil = "Baik";
                        } else if (input == 10.5 || input <= 11.5) {
                            hasil = "Rata-rata";
                        } else if (input > 11.5) {
                            hasil = "Kurang";
                        }

                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                        if (input < 10.5) {
                            hasil = "Sangat Baik";
                        } else if (input == 10.5 || input <= 11.5) {
                            hasil = "Baik";
                        } else if (input == 11.5 || input <= 12.5) {
                            hasil = "Rata-rata";
                        } else if (input > 12.5) {
                            hasil = "Kurang";
                        }
                    }

                    Intent intent = new Intent(TestAgilityActivity.this, HasilActivity.class);
                    intent.putExtra("nama", opName);
                    intent.putExtra("jenis", opJenis);
                    intent.putExtra("input", opInput);
                    intent.putExtra("hasil", hasil);
                    intent.putExtra("jenis_kelamin", str);
                    startActivity(intent);
                }
            }
        });


    }

    private List getAgilityList() {
        List agilityList = new ArrayList<>();

        agilityList.add(new AgiltyModel(1, "Baik Sekali", "<9.5", "<10.5"));
        agilityList.add(new AgiltyModel(2, "Baik", "9.5-10.5", "10.5-11.5"));
        agilityList.add(new AgiltyModel(3, "Rata-Rata", "10.5-11.5", "11.5-12.5"));
        agilityList.add(new AgiltyModel(4, "Kurang", ">11.5", ">12.5"));


        return agilityList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
