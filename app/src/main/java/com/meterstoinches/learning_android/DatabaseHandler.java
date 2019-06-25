package com.meterstoinches.learning_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final int databse_version = 1;
    public static final String database_name = "MarksScored";
    public static final String table_name = "MarksScoredByStudent";

    public static final String key_id = "id";
    public static final String key_name = "name";
    public static final String key_marks = "marks";

    String create_table = "create table "+table_name+"("+key_id+" integer primary key,"+key_name
            +" text,"+key_marks+" integer"+")";
    String drop_table = "drop table if exists "+table_name;

    public DatabaseHandler(Context context) {
        super(context, database_name, null, databse_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_table);
        onCreate(db);
    }
    //CRUD
    public void addMarks(String p1,String p2){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(key_name,p1);
        contentValues.put(key_marks,p2);
        db.insert(table_name,null,contentValues);
        db.close();
    }
    public List<Marks> getAllMarks(){
        List<Marks> marksList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String selectquery = "select * from "+table_name;
        Cursor cursor = db.rawQuery(selectquery,null);
        if (cursor.moveToFirst()){
            do{
                Marks marks = new Marks();
                marks.setId(Integer.parseInt(cursor.getString(0)));
                marks.setName(cursor.getString(1));
                marks.setMarks(Integer.parseInt(cursor.getString(2)));

                marksList.add(marks);

            }while (cursor.moveToNext());
        }
        return marksList;
    }
    public void deleteAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(drop_table);
        db.execSQL(create_table);
    }
    public void deleteLastRow(){
        SQLiteDatabase db = this.getReadableDatabase();
        Marks marks = new Marks();
        String selectQuery = "SELECT  * FROM " + table_name;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToLast()) {
            marks.setId(Integer.parseInt(cursor.getString(0)));
        }

        db.execSQL("DELETE FROM " + table_name+ " WHERE "+key_id+"='"+marks.getId()+"'");
        db.close();

    }

}
