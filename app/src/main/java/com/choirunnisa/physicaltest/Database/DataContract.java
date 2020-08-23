package com.choirunnisa.physicaltest.Database;

import android.graphics.Bitmap;

public class DataContract {
    public static final String DB_NAME = "MY_PHYSICAL_TEST";

    public static final int DB_VERSION = 2;

    public static final String TABLE_NAME = "TABLE_PHYSICAL_TEST";

    public static String ID ="ID";
    public static final String NAME ="NAMA";
    public static final String TEST ="TEST";
    public static final String JKEL ="JKEL";
    public static final String USIA = "USIA";
    public static final String INPUT="INPUT";
    public static final String HASIL="HASIL";
    public static final String TIME ="TIME";


    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
        + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + NAME + " TEXT,"
        + TEST + " TEXT,"
        + JKEL + " TEXT,"
        + USIA + " TEXT,"
        + INPUT + " TEXT,"
        + HASIL + " TEXT,"
        + TIME + " DATETIME DEFAULT CURRENT_TIMESTAMP"
        +")";

}
