package com.listazakupow;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends Activity {

    private Button apply;
    private EditText fontSize;
    private EditText fontColor;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    private String fontSizeValue = null;
    private String fontColorValue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setSettings();

    }

    private void setSettings() {
        apply = findViewById(R.id.apply);
        fontSize = findViewById(R.id.fontSize);
        fontColor = findViewById(R.id.fontColor);

        settings = this.getSharedPreferences(getString(R.string.preference_file_key), 0);
        editor = settings.edit();

        fontSizeValue = settings.getString("fontSize", "18");
        fontColorValue = settings.getString("fontColor", "@android:color/black");

        fontSize.setText(fontSizeValue);
        fontSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(fontSizeValue));
        fontColor.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(fontSizeValue));

        setFontColor();

        apply.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Apply(v);
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void setFontColor() {
        fontColor.setText(fontColorValue);
        if (fontColorValue.equalsIgnoreCase("BLACK")) {
            fontColor.setTextColor(Color.BLACK);
            fontSize.setTextColor(Color.BLACK);
        } else if (fontColorValue.equalsIgnoreCase("RED")) {
            fontColor.setTextColor(Color.RED);
            fontSize.setTextColor(Color.RED);
        } else if (fontColorValue.equalsIgnoreCase("GREEN")) {
            fontColor.setTextColor(Color.GREEN);
            fontSize.setTextColor(Color.GREEN);
        } else if (fontColorValue.equalsIgnoreCase("BLUE")) {
            fontColor.setTextColor(Color.BLUE);
            fontSize.setTextColor(Color.BLUE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setSettings();
    }

    public void Apply (View v) {

        fontSizeValue = fontSize.getText().toString();
        fontColorValue = fontColor.getText().toString();

        editor.putString("fontSize", fontSizeValue);
        editor.putString("fontColor", fontColorValue);
        editor.commit();

    }
}
