package com.choirunnisa.physicaltest.Kecepatan;

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
import android.os.Handler;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.choirunnisa.physicaltest.AdapterApps.FitnessAdapter;
import com.choirunnisa.physicaltest.AdapterApps.LariAdapter;
import com.choirunnisa.physicaltest.DayaTahan.TestFitnessActivity;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.Keseimbangan.TestStrockActivity;
import com.choirunnisa.physicaltest.ModelApps.LariModel;
import com.choirunnisa.physicaltest.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.List;

public class TestLariActivity extends AppCompatActivity {

    Button buttonSave;
    //    String gender;

    private ActionBar actionBar;

    TextView editinput;
    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;
    String waktu;
    Button start, pause, reset;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    int Seconds, Minutes, MilliSeconds ;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lari);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);
        start = findViewById(R.id.button);
        pause = findViewById(R.id.button2);
        reset = findViewById(R.id.button3);
        editinput = findViewById(R.id.input);

        handler = new Handler();


        actionBar = getSupportActionBar();
        actionBar.setTitle("Test Lari 300 M");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        LariAdapter adapter = new LariAdapter(getLariList());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset.setEnabled(true);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                MilliSeconds = 0 ;

                editinput.setText("00.00");

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNama = (EditText) findViewById(R.id.nama);
                String opName = editNama.getText().toString();
                EditText editJenis = (EditText) findViewById(R.id.jenis);
                String opJenis = editJenis.getText().toString();
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
                    } else {
                        Toast.makeText(TestLariActivity.this, "Mohon Lengkapi Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                    }

                    if (input > 77) {
                        hasil = "Kurang";
                    } else if (input == 77 || input >= 71.1) {
                        hasil = "Di bawah Rata-rata";
                    } else if (input == 71 || input >= 65.1) {
                        hasil = "Rata-rata";
                    } else if (input == 65 || input >= 59.1) {
                        hasil = "Di atas Rata-rata";
                    } else if (input == 59 || input >= 54.1) {
                        hasil = "Baik";
                    } else if (input == 54 || input >= 48) {
                        hasil = "Sangat Baik";
                    } else if (input < 48) {
                        hasil = "Sempurna";
                    }

                    Intent intent = new Intent(TestLariActivity.this, HasilActivity.class);

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

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            MilliSeconds = (int) (UpdateTime % 1000);

            editinput.setText(Seconds + "."
                    + String.format("%02d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };
    private List getLariList() {
        List lariList = new ArrayList<>();

        lariList.add(new LariModel(1, ">77", "Kurang"));
        lariList.add(new LariModel(2, "71.1-77", "Di Bawah Rata-Rata"));
        lariList.add(new LariModel(3, "65.1-71", "Rata-Rata"));
        lariList.add(new LariModel(4, "59.1-65", "Di Atas Rata-Rata"));
        lariList.add(new LariModel(5, "54.1-59", "Baik"));
        lariList.add(new LariModel(6, "48-54", "Sangat Baik"));
        lariList.add(new LariModel(7, "<48", "Sempurna"));

        return lariList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
