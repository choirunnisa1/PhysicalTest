package com.choirunnisa.physicaltest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DetailDataActivity extends AppCompatActivity {

    ActionBar actionBar;

    private TextView dNama, dTest, dJkel,dInput, dHasil, dWaktu;
    private String InputID;
    DataHelper dataHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        Intent intent = getIntent();
        InputID = intent.getStringExtra("RECORD_ID");

        dataHelper = new DataHelper(this);

        dNama = findViewById(R.id.dNama);
        dTest = findViewById(R.id.dJenis);
        dJkel = findViewById(R.id.dJkel);
        dInput = findViewById(R.id.dInput);
        dHasil = findViewById(R.id.dHasil);
        dWaktu = findViewById(R.id.dWaktu);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Detail Hasil Test Peserta");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        showInputDetail();
    }

    private void showInputDetail() {
        String selectQuery ="SELECT * FROM " + DataContract.TABLE_NAME + " WHERE " + DataContract.ID + " =\"" + InputID+"\"";

        SQLiteDatabase db = dataHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                String id = ""+cursor.getInt(cursor.getColumnIndex(DataContract.ID));
                String nama = ""+cursor.getString(cursor.getColumnIndex(DataContract.NAME));
                String jkel = ""+cursor.getString(cursor.getColumnIndex(DataContract.JKEL));
                String jenis = ""+cursor.getString(cursor.getColumnIndex(DataContract.TEST));
                String input = ""+cursor.getString(cursor.getColumnIndex(DataContract.INPUT));
                String hasil = ""+cursor.getString(cursor.getColumnIndex(DataContract.HASIL));
                String waktu = ""+cursor.getString(cursor.getColumnIndex(DataContract.TIME));

//                Calendar calendar = Calendar.getInstance(Locale.getDefault() );
//                calendar.setTimeInMillis(Long.parseLong(waktu));
//                String time = ""+ DateFormat.format("dd/MM/yyyy hh:mm:aa", calendar);

                dNama.setText(": "+nama);
                dJkel.setText(": "+jkel);
                dTest.setText(": "+jenis);
                dInput.setText(": "+input);
                dHasil.setText(": "+hasil);
                dWaktu.setText(": "+waktu);


            }while (cursor.moveToNext());
        }

        db.close();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
