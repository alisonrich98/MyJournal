package com.example.office1.myjournal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class PromptEntry extends AppCompatActivity {
    int textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt_entry);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

        textColor = Color.BLACK;

        String[] colorNames = {"Black", "Red", "Dark Blue", "Light Blue", "Gray", "Green", "Yellow", "Magenta"};
        final int[] colors = {
                Color.BLACK,
                Color.RED,
                Color.BLUE,
                Color.CYAN,
                Color.GRAY,
                Color.GREEN,
                Color.YELLOW,
                Color.MAGENTA};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colorNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textColor = colors[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
