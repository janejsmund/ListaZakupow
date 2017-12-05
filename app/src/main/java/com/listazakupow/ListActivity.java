package com.listazakupow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ListActivity extends Activity {

    Button addGrocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        addGrocery = findViewById(R.id.addGrocery);
        addGrocery.setOnClickListener(new OnClickListenerAddGrocery());

        readRecords();
    }

    @Override
    protected void onResume() {
        super.onResume();
        readRecords();
//        finish();
//        startActivity(getIntent());
    }

    public void readRecords() {

        LinearLayout linearLayoutRecords = findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<ObjectGrocery> groceries = new TableControllerGroceries(this).read();

        if (groceries.size() > 0) {

            TextView textView = new TextView(this);
            String textViewContents = "Nazwa produktu - liczba sztuk - cena - kupione?";
            textView.setPadding(0, 10, 0, 10);
            textView.setText(textViewContents);
            linearLayoutRecords.addView(textView);

            for (ObjectGrocery object : groceries) {

                int id = object.id;
                String groceryPosition = object.groceryPosition;
                String groceryAmount = object.groceryAmount;
                String groceryPrice = object.groceryPrice;
                String groceryBought = object.groceryBought;

                textViewContents = groceryPosition + " - " + groceryAmount + " - " + groceryPrice + " - " + groceryBought;

                GroceryButton ButtonGroceryItem= new GroceryButton(this);
                ButtonGroceryItem.setPadding(0, 10, 0, 10);
                ButtonGroceryItem.setText(textViewContents);
                ButtonGroceryItem.setTag(Integer.toString(id));

                linearLayoutRecords.addView(ButtonGroceryItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("Lista jest pusta.");

            linearLayoutRecords.addView(locationItem);
        }

    }
}
