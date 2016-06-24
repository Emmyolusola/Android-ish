package com.emmyolusola.tableassessment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emmyolusola on 4/30/2016.
 */
public class  DBAdadpter {

    public static final String KEY_ROWID = "_ID";
    public static final String KEY_NUMBER = "QUIZ_NUMBER";
    public static final String KEY_TITLE = "QUIZ_TITLE";

    public static final String DATABASE_NAME = "AssessmentDB";
    public static final String DATABASE_TABLE = "QUIZ_TABLE";
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE + "(" + KEY_ROWID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_TITLE + " TEXT NOT NULL, " + KEY_NUMBER + "TEXT NOT NULL );";

    private Context _context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DBAdadpter(Context context) {
        this._context = context;
    }

    private class DatabaseHelper extends SQLiteOpenHelper{


        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                sqLiteDatabase.execSQL(DATABASE_CREATE);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(sqLiteDatabase);
        }
    }

    public DBAdadpter open() throws SQLException{

        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){

        dbHelper.close();
    }

//    Quiz_list ql = new Quiz_list();


    public void insertQuestions(){

//        String[] title = ql.getResources().getStringArray(R.array.quiz_topic);
//        String[] number = ql.getResources().getStringArray(R.array.number);

//        String[] title = ql.title;
//        String[] number = ql.number;
//
//        ContentValues cv = new ContentValues();
//        for (int i = 0; i < title.length; i++){
//            cv.put(KEY_TITLE, title[i]);
//            cv.put(KEY_NUMBER, number[i]);
//        }
//        sqLiteDatabase.insert(DATABASE_TABLE, null, cv);
    }

    public String getTitle(){

//        String[] columns = new String[]{KEY_TITLE, KEY_NUMBER};
        String[] columns = new String[]{KEY_TITLE};
        Cursor cursor = sqLiteDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";

        int iTitle = cursor.getColumnIndex(KEY_TITLE);
//        int iNumber = cursor.getColumnIndex(KEY_NUMBER);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            result = result + cursor.getString(iTitle);
//            result2 = result2 + cursor.getString(iNumber);
        }
        return result;
    }

    public String getNumber(){

        String[] columns = new String[]{KEY_NUMBER};
        Cursor cursor = sqLiteDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";

//        int iTitle = cursor.getColumnIndex(KEY_TITLE);
        int iNumber = cursor.getColumnIndex(KEY_NUMBER);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            result = result + cursor.getString(iNumber);
//            result2 = result2 + cursor.getString(iNumber);
        }
        return result;
    }

}
