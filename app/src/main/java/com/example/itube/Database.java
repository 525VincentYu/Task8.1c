package com.example.itube;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    Context context;
    public Database(Context context) {
        super(context, "playlist.db", null, 1);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists playlist (ID integer primary key autoincrement, url text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists playlist");

    }

    public Boolean insertData(  String url )
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("url",url);

        long result = DB.insert("playlist",null,contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }



    }









    public ArrayList<String> getAlldata()
    {
        try {
            ArrayList<String>playlist = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            if(sqLiteDatabase!=null){
            Cursor cursor = sqLiteDatabase.rawQuery("select * from playlist",null);
            if(cursor.getCount()!=0){
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    String context = cursor.getString(cursor.getColumnIndexOrThrow("url"));
                    String[] temp2;
                    String[] temp;
                    String delimeter = "=";
                    temp2 = context.split(delimeter);
                    if (temp2.length > 1) {
                        delimeter = temp2[1];
                        String delimeter2 = "&";
                        temp = delimeter.split(delimeter2);
                        playlist.add(temp[0]);
                        cursor.moveToNext();
                    }
                }
                return playlist;

            }
            else {
                Toast.makeText(context, "No data is ", Toast.LENGTH_SHORT).show();
                return null;
            }
            }
            else {
                Toast.makeText(context, "Data is null", Toast.LENGTH_SHORT).show();
                return null;
            }

        }
        catch (Exception e){
            Toast.makeText(context, "getAllData:-"+e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public ArrayList<String> getAlldata1()
    {
        try {
            ArrayList<String>playlist = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            if(sqLiteDatabase!=null){
                Cursor cursor = sqLiteDatabase.rawQuery("select * from playlist",null);
                if(cursor.getCount()!=0){
                    if(cursor.getCount()!=0){
                        while(cursor.moveToNext()){
                            String url = cursor.getString(1);
                            playlist.add(url);
                        }
                    }
                    return playlist;

                }
                else {
                    Toast.makeText(context, "No data is ", Toast.LENGTH_SHORT).show();
                    return null;
                }
            }
            else {
                Toast.makeText(context, "Data is null", Toast.LENGTH_SHORT).show();
                return null;
            }

        }
        catch (Exception e){
            Toast.makeText(context, "getAllData:-"+e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }


    public String geturl(int ID){
        SQLiteDatabase MyDB = this.getReadableDatabase();

        Cursor cursor = MyDB.rawQuery("select * from playlist where ID = ID",null);
        if(cursor != null && cursor.moveToFirst()){
         return cursor.getString(1);}
        else {Toast.makeText(context, "Data is null", Toast.LENGTH_SHORT).show();
            return null;       }
    }}

