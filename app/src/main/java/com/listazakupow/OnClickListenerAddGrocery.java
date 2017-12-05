package com.listazakupow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

class OnClickListenerAddGrocery implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        final Context context = view.getRootView().getContext();

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = layoutInflater.inflate(R.layout.grocery_position_input_form, null, false);

        final EditText editGroceryPosition = formElementsView.findViewById(R.id.editGroceryPosition);
        final EditText editGroceryAmount = formElementsView.findViewById(R.id.editGroceryAmount);
        final EditText editGroceryPrice = formElementsView.findViewById(R.id.editGroceryPrice);
        final EditText editGroceryBought = formElementsView.findViewById(R.id.editGroceryBought);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Dodaj pozycję do listy zakupów")
                .setPositiveButton("Dodaj",
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

                                boolean createSuccessful = new TableControllerGroceries(context).create(objectGrocery);

                                if(createSuccessful){
                                    Toast.makeText(context, "Pozycja została dodana do listy zakupów.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Zapis informacji zakończył się niepowodzeniem.", Toast.LENGTH_SHORT).show();
                                }



                                dialog.cancel();
                            }

                        }).show();

    }

}
