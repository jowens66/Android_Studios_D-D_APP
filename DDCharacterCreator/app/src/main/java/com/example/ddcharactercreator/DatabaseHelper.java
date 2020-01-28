package com.example.ddcharactercreator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DbName = "SQLiteCharacters.db";
    private static final int DbVer= 1;
    public static final String dbTableCharacter = "character";
    public static final String dbColId = "_id";
    public static final String dbColName = "name";
    public static final String dbColClass = "class";
    public static final String dbColRace = "race";
    public static final String dbColStr = "strength";
    public static final String dbColDex = "dexterity";
    public static final String dbColCon = "constitution";
    public static final String dbColInt = "intelligence";
    public static final String dbColWis = "wisdom";
    public static final String dbColCha = "charisma";

    SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        super(context, DbName, null, DbVer);
    }

    //This builds the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL);", dbTableCharacter, dbColName, dbColClass, dbColRace, dbColStr, dbColDex, dbColCon, dbColInt, dbColWis, dbColCha);
        db.execSQL(query);
        onCreate(db);*/
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT NOT NULL);" , dbTableCharacter, dbColName);
        db.execSQL(query);
    }

    //This drops the table
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = String.format("DELETE TABLE IF EXISTS %s", dbTableCharacter);
        db.execSQL(query);
        onCreate(db);
    }

    //The following functions will add every aspect of the character. A cannot resolve method error occurs if multiple strings are entered into values.put()

    public void insertNewCharacter(String Cname){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(dbColName, Cname);
        //values.put(dbColClass, Cclass);
        //values.put(dbColRace, Crace);
        db.insertWithOnConflict(dbTableCharacter, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    //Edit the Characters name, class, and race
    public void EditCharacter(String Cname, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbColName, Cname);
        //values.put(dbColClass, Cclass);
        //values.put(dbColRace, Crace);
        db.update(dbTableCharacter, values, dbColName + " = ?", new String[]{oldName});
        db.close();
    }


    //Delete the characters name, class, and race
    public void deleteCharacter(String Cname){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(dbTableCharacter, dbColName + " = ?", new String[]{Cname});
        db.close();
    }


    //These functions are used to build arrays for all of the characters attributes
    public ArrayList<String> getAllCharacters(){

        ArrayList<String> characterList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(dbTableCharacter, new String[]{dbColName}, null, null, null, null, null);

        while(cursor.moveToNext()){

            int index = cursor.getColumnIndex(dbColName);
            characterList.add(cursor.getString(index));
        }

        cursor.close();
        db.close();
        return characterList;
    }
}