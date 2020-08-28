package com.choirunnisa.physicaltest.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.choirunnisa.physicaltest.DataContract;
import com.choirunnisa.physicaltest.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    public DataHelper(@Nullable Context context) {
        super(context, DataContract.DB_NAME, null, DataContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DataContract.TABLE_NAME);

        onCreate(db);
    }
    public long insertData(String nama, String test,
                String jkel,String usia,String input, String hasil,String waktu) {

            SQLiteDatabase db = this.getWritableDatabase();
            //query to insert record in database table
            ContentValues values = new ContentValues();

            values.put(DataContract.NAME, nama );
            values.put(DataContract.TEST, test);
            values.put(DataContract.JKEL, jkel);
            values.put(DataContract.USIA, usia);
            values.put(DataContract.INPUT, input);
            values.put(DataContract.HASIL, hasil);
            values.put(DataContract.TIME, waktu);

            long id = db.insert(DataContract.TABLE_NAME, null,values);

            db.close();

            return id;
    }
    public ArrayList<Model> getAllData(String orderBy) {
        ArrayList<Model> modelArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DataContract.TABLE_NAME + " ORDER BY " + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Model model = new Model(
                        "" + cursor.getInt(cursor.getColumnIndex(DataContract.ID)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.NAME)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.TEST)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.JKEL)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.USIA)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.INPUT)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.HASIL)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.TIME))
                );

                modelArrayList.add(model);
            } while (cursor.moveToNext());
        }if (modelArrayList.size()==0){

        }
            db.close();
            return modelArrayList;
        }

    public ArrayList<Model> getSearchData(String query) {
        ArrayList<Model> modelArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DataContract.TABLE_NAME + " WHERE " + DataContract.NAME + " LIKE '%" + query +"%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Model model = new Model(
                        "" + cursor.getInt(cursor.getColumnIndex(DataContract.ID)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.NAME)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.TEST)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.JKEL)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.USIA)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.INPUT)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.HASIL)),
                        "" + cursor.getString(cursor.getColumnIndex(DataContract.TIME))
                );

                modelArrayList.add(model);
            } while (cursor.moveToNext());
        }
        if (modelArrayList.size()==0) {
//            Toast.makeText(Context, "No record found...", Toast.LENGTH_SHORT).show();
//        }
        }
        db.close();
        return modelArrayList;
    }

    public void deleteData(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DataContract.TABLE_NAME, DataContract.ID + " = ?", new String[]{id});
        db.close();
    }
    public Cursor getuser() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + DataContract.TABLE_NAME + " ",
                null);
        return res;
    }

    public void deleteAllData(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + DataContract.TABLE_NAME);
        db.close();
    }
    public int getAddCount(){
        String countQuery = "SELECT * FROM " + DataContract.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);

        int count = cursor.getCount();

        cursor.close();

        return count;

    }
    private String getDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(

                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());

        Date date = new Date();

        return dateFormat.format(date);

    }

}