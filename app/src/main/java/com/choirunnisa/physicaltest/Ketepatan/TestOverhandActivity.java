package com.choirunnisa.physicaltest.Ketepatan;

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

import com.choirunnisa.physicaltest.AdapterApps.OverhandAdapter;
import com.choirunnisa.physicaltest.AdapterApps.TableViewAdapter;
import com.choirunnisa.physicaltest.HasilActivity;
import com.choirunnisa.physicaltest.ModelApps.OverhandModel;
import com.choirunnisa.physicaltest.R;

import java.util.ArrayList;
import java.util.List;

public class TestOverhandActivity extends AppCompatActivity {

    Button buttonSave;

    private ActionBar actionBar;

    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_overhand);
        buttonSave = findViewById(R.id.proses);
        rb_laki = findViewById(R.id.laki);
        rb_perempuan = findViewById(R.id.perempuan);


        actionBar = getSupportActionBar();
        actionBar.setTitle("Overhand Accuracy Throw Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        OverhandAdapter adapter = new OverhandAdapter(getoverhandList());

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


                    if (input == 13 || input<=15) {
                        hasil = "Sangat Baik";
                    } else if (input == 10 || input <= 12) {
                        hasil = "Baik";
                    } else if (input == 7 || input <= 9) {
                        hasil = "Rata-rata";
                    } else if (input == 4 || input <= 6) {
                        hasil = "Kurang";
                    } else if (input == 1 || input <= 3){
                        hasil = "Sangat Kurang";
                    } else hasil =  "Tidak terdefinisi";


                    if (rb_laki.isChecked()) {
                        str = "Laki-laki";
                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                    }

                    Intent intent = new Intent(TestOverhandActivity.this, HasilActivity.class);
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

    private List getoverhandList() {
        List overhandList = new ArrayList<>();

        overhandList.add(new OverhandModel(1, "Baik Sekali", "13-15"));
        overhandList.add(new OverhandModel(2, "Baik", "10-12"));
        overhandList.add(new OverhandModel(3, "Rata-Rata", "7-9"));
        overhandList.add(new OverhandModel(4, "Kurang", "4-6"));
        overhandList.add(new OverhandModel(5, "Sangat Kurang", "1-3"));


        return overhandList;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
