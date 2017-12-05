package com.listazakupow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TableControllerGroceries extends DatabaseHandler {

    Context context;

    public TableControllerGroceries(Context context) {

        super(context);
        this.context = context;
    }

    public boolean create(ObjectGrocery objectGrocery) {

        ContentValues values = new ContentValues();

        values.put("groceryPosition", objectGrocery.groceryPosition);
        values.put("groceryAmount", objectGrocery.groceryAmount);
        values.put("groceryPrice", objectGrocery.groceryPrice);
        values.put("groceryBought", objectGrocery.groceryBought);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("groceries", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public boolean update(ObjectGrocery objectGrocery) {

        ContentValues values = new ContentValues();

        //values.put("id", objectGrocery.id);
        values.put("groceryPosition", objectGrocery.groceryPosition);
        values.put("groceryAmount", objectGrocery.groceryAmount);
        values.put("groceryPrice", objectGrocery.groceryPrice);
        values.put("groceryBought", objectGrocery.groceryBought);

        SQLiteDatabase db = this.getWritableDatabase();


        boolean updateSuccessful = db.insert("groceries", null, values) > 0;
        db.close();

        return updateSuccessful;
    }

    public List<ObjectGrocery> read() {

        List<ObjectGrocery> recordsList = new ArrayList<>();

        String sql = "SELECT * FROM groceries ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String groceryPosition = cursor.getString(cursor.getColumnIndex("groceryPosition"));
                String groceryAmount = cursor.getString(cursor.getColumnIndex("groceryAmount"));
                String groceryPrice = cursor.getString(cursor.getColumnIndex("groceryPrice"));
                String groceryBought = cursor.getString(cursor.getColumnIndex("groceryBought"));

                ObjectGrocery objectGrocery = new ObjectGrocery();
                objectGrocery.id = id;
                objectGrocery.groceryPosition = groceryPosition;
                objectGrocery.groceryAmount = groceryAmount;
                objectGrocery.groceryPrice = groceryPrice;
                objectGrocery.groceryBought = groceryBought;

                recordsList.add(objectGrocery);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }
}
