package com.example.admin.quickmaths;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.admin.quickmaths.model.display.DisplayObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 11/16/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    //when you change the schema, change the version number

    private static final String DATABASE_NAME = "Cart.db";

    private static final String TABLE_NAME = "Offers";
    private static final String COLUMN_PRODUCT = "Product";
    private static final String COLUMN_STORE = "Store";
    private static final String COLUMN_DESCRIPTION = "Description";
    private static final String COLUMN_LINK = "Link";
    private static final String COLUMN_IMAGEURL = "ImageURL";
    private static final String COLUMN_PRICE = "Price";
    private static final String COLUMN_ONLINE = "Online";
    private static final String TAG = "DBHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_PRODUCT + " TEXT, " +
                COLUMN_STORE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_LINK + " TEXT, " +
                COLUMN_IMAGEURL + " TEXT, " +
                COLUMN_PRICE + " TEXT, " +
                COLUMN_ONLINE + " TEXT, " +
                "PRIMARY KEY (" + COLUMN_PRODUCT + ", " + COLUMN_STORE + ")" +
                ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long saveOffer(DisplayObject displayObject){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //key column name, value
        contentValues.put(COLUMN_PRODUCT, displayObject.getProduct());
        contentValues.put(COLUMN_STORE, displayObject.getStore());
        contentValues.put(COLUMN_DESCRIPTION, displayObject.getImageUrl());
        contentValues.put(COLUMN_LINK, displayObject.getImageUrl());
        contentValues.put(COLUMN_IMAGEURL, displayObject.getImageUrl());
        contentValues.put(COLUMN_PRICE, String.valueOf(displayObject.getPrice()));
        contentValues.put(COLUMN_ONLINE, String.valueOf(displayObject.isOnLine()));

        //database.insert returns row value where this data was saved
        long isSaved = database.insert(TABLE_NAME, null, contentValues);

        Log.d(TAG, "saveOffer: " + isSaved);
        return isSaved;

    }

    public List<DisplayObject> getOfferList(){

        List<DisplayObject> offerList = new ArrayList<>();
        SQLiteDatabase databse = this.getWritableDatabase();

        String QUERY = "SELECT * from " + TABLE_NAME;
        Cursor cursor = databse.rawQuery(QUERY, null);
//        String QUERY = "SELECT * from " + TABLE_NAME + " where name = ?";
//        Cursor cursor = databse.rawQuery(QUERY, new String[]{"34"});

        //returns boolean true if there is a record
        if(cursor.moveToFirst()){
            do {
                DisplayObject offer = new DisplayObject(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        Double.valueOf(cursor.getString(5)),
                        Boolean.valueOf(cursor.getString(6)));
                offerList.add(offer);
            } while(cursor.moveToNext());
        }

        return offerList;

    }

    public boolean deleteOffer(String name, String store)
    {
        SQLiteDatabase database = this.getWritableDatabase();
//        database.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_PRODUCT + "= '" + name + "'");
        return database.delete(TABLE_NAME, COLUMN_PRODUCT + "= '" + name + "' AND " + COLUMN_STORE + "= '" + store + "'", null) > 0;
    }

}
