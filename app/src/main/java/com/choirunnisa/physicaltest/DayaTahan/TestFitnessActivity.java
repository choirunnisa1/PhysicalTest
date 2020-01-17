package com.choirunnisa.physicaltest.DayaTahan;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.choirunnisa.physicaltest.AdapterApps.FitnessAdapter;
import com.choirunnisa.physicaltest.AdapterApps.TableViewAdapter;
import com.choirunnisa.physicaltest.DataHelper;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.Kecepatan.TestLariActivity;
import com.choirunnisa.physicaltest.Kelincahan.TestAgilityActivity;
import com.choirunnisa.physicaltest.LihatDataActivity;
import com.choirunnisa.physicaltest.ModelApps.AgiltyModel;
import com.choirunnisa.physicaltest.ModelApps.LariModel;
import com.choirunnisa.physicaltest.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

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

                if (opName.equals("") || opInput.length() == 0 || rb_fitness.getCheckedRadioButtonId() == -1) {
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
                    intent.putExtra("jenis_kelamin", str);
                    startActivity(intent);
                }
            }
        });


    }
    private List getFitnessList() {
        List fitnessList = new ArrayList<>();

        fitnessList.add(new LariModel(1, "<=28.8", "Kurang Sekali"));
        fitnessList.add(new LariModel(2, "28.1-34", "Kurang"));
        fitnessList.add(new LariModel(3, "34.1-42", "Sedang"));
        fitnessList.add(new LariModel(4, "42.1-52", "Baik"));
        fitnessList.add(new LariModel(5, ">=52.1", "Baik"));

        return fitnessList;
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
