package com.choirunnisa.physicaltest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.ajts.androidmads.library.SQLiteToExcel;
import com.choirunnisa.physicaltest.ModelApps.Model;

import java.io.File;
import java.util.ArrayList;


public class LihatDataActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private DataHelper dataHelper;
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Daftar Hasil Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.rvhasil);

        dataHelper = new DataHelper(this);



        loadData();

//        File file = new File(directory_path);
//        if (!file.()) {
//            Log.v("File Created", String.valueOf(file.mkdir()));
//        }


    }

    private void loadData() {
        ArrayList<Model> modelArrayList = new ArrayList<>();
        Adapter adapter = new Adapter(LihatDataActivity.this,
                dataHelper.getAllData(DataContract.TIME +" DESC"));
        recyclerView.setAdapter(adapter);
        actionBar.setSubtitle("Total data :"+dataHelper.getAddCount());
        if (dataHelper.getAddCount()==0){
            Toast.makeText(LihatDataActivity.this,"Data kosong/tidak ditemukan",Toast.LENGTH_SHORT).show();
        }
    }


    private void SearchData(String query){
        Adapter adapter = new Adapter(LihatDataActivity.this,
                dataHelper.getSearchData(query));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                SearchData(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id==R.id.action_delete){
        new AlertDialog.Builder(this)
                .setMessage("Yakin hapus semua data?")
                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataHelper.deleteAllData();
                        onResume();
                    }
                })
                .setNegativeButton("TIDAK", null)
                .setCancelable(false)
                .show();
    } else if (id==R.id.action_excel){
        String directory_path = Environment.getExternalStorageDirectory().getPath()+"/Backup/";
        File file = new File(directory_path);
        if (!file.exists()){
            file.mkdir();
        }
        SQLiteToExcel sqLiteToExcel = new SQLiteToExcel(getApplicationContext(), DataContract.DB_NAME,directory_path);
        sqLiteToExcel.exportAllTables("datates.xls", new SQLiteToExcel.ExportListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onCompleted(String filePath) {
                Toast.makeText(LihatDataActivity.this,"Data Berhasil Dieksport pada Folder Backup dengan nama file datatates.xls",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(LihatDataActivity.this,"Gagal Mengeksport, mohon cek perizinan akses penyimpanan Anda",Toast.LENGTH_SHORT).show();

            }
        });
//        sqliteToExcel = new SQLiteToExcel(getApplicationContext(), DataContract.DB_NAME, directory_path);
//        sqliteToExcel.("users.xls", new SQLiteToExcel.ExportListener() {
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onCompleted(String filePath) {
//                Utils.showSnackBar(view, "Successfully Exported");
//            }
//
//            @Override
//            public void onError(Exception e) {
//                Utils.showSnackBar(view, e.getMessage());
//            }
//        });
//    }
    }

    return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


}
