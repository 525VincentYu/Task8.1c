package com.example.itube;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database1 extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public static final String TABLE_NAME = "user";
    public static final String COLUM_USERNAME = "username";
    public static final String COLUM_PASSWORD = "password";
    public static final String COLUM_FULLNAME = "fullname";
    public static final String COLUM_PHONENUMBER = "phonenumber";

   public Database1(Context context) {
       super(context, "Login.db", null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUM_USERNAME + " TEXT PRIMARY KEY, "  +
                        COLUM_PASSWORD + " TEXT, " +
                        COLUM_FULLNAME + " TEXT, " +
                        COLUM_PHONENUMBER + " TEXT " + ")";
        MyDB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists " + TABLE_NAME);
        onCreate(MyDB);



    }


    public Boolean insertData(  String username, String password, String fullname)
    {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("fullname",fullname);

        long result = MyDB.insert("user", null, contentValues);
        if(result == -1)return false;
        else
            return true;
    }
    public Boolean insertData2(  String fullname, String phonenumber)
    {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("fullname", fullname);
        contentValues.put("phonenumber", phonenumber);
        //contentValues.put("fullname",fullname);
        //contentValues.put("phonenumber",phonenumber);
        long result = MyDB.insert("user", null, contentValues);
        if(result == -1)return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where username = ? " , new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernampassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
