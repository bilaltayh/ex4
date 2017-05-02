package com.example.bilalt.bilal;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "todos.db";
    public static final String TABLE_NAME = "todos";
    public static final String COL_1 = "NUM";
    public static final String COL_2 = "DATE";
    public static final String COL_3= "TITLE";
    public static final String COL_4= "TXT";
    public static final String COL_5= "ID";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME +" (NUM INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,TITLE TEXT,TXT TEXT,ID TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String date,String title, String txt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,title);
        contentValues.put(COL_4, txt);
        contentValues.put(COL_5,id);

        long result = db.insert(TABLE_NAME ,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}