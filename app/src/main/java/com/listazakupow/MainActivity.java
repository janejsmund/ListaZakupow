package com.listazakupow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button lista;
    private Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = findViewById(R.id.settings);
        lista = findViewById(R.id.list);
}

    public void OpenList (View v) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void OpenSettings (View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
