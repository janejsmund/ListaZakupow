package com.listazakupow;

import android.app.Activity;
import android.widget.Button;

public class GroceryButton extends Button {

    GroceryButton (Activity activity) {
        super(activity);

        this.setOnClickListener(new OnClickListenerEditGrocery());
    }
}
