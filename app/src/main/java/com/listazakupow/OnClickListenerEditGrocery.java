package com.listazakupow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

class OnClickListenerEditGrocery implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        final Context context = view.getRootView().getContext();

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = layoutInflater.inflate(R.layout.grocery_position_edit_form, null, false);

        final EditText editGroceryPosition = formElementsView.findViewById(R.id.editGroceryPosition);
        final EditText editGroceryAmount = formElementsView.findViewById(R.id.editGroceryAmount);
        final EditText editGroceryPrice = formElementsView.findViewById(R.id.editGroceryPrice);
        final EditText editGroceryBought = formElementsView.findViewById(R.id.editGroceryBought);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Edytuj pozycję z listy zakupów")
                .setPositiveButton("Edytuj",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String groceryPosition = editGroceryPosition.getText().toString();
                                String groceryAmount = editGroceryAmount.getText().toString();
                                String groceryPrice = editGroceryPrice.getText().toString();
                                String groceryBought = editGroceryBought.getText().toString();

                                ObjectGrocery objectGrocery = new ObjectGrocery();
                                objectGrocery.groceryPosition = groceryPosition;
                                objectGrocery.groceryAmount = groceryAmount;
                                objectGrocery.groceryPrice = groceryPrice;
                                objectGrocery.groceryBought = groceryBought;

                                boolean updateSuccessful = new TableControllerGroceries(context).update(objectGrocery);

                                if(updateSuccessful){
                                    Toast.makeText(context, "Pozycja została nadpisana.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Nadpianie informacji zakończyło się niepowodzeniem.", Toast.LENGTH_SHORT).show();
                                }



                                dialog.cancel();
                            }

                        }).show();

    }
}
