package com.example.office1.myjournal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PromptEntry extends AppCompatActivity {
    int textColor;
    private FreehandView drawView;
    private EditText textView;
    Button randomize;
    private RadioButton type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt_entry);
        randomize = (Button)findViewById(R.id.button5);

        type = (RadioButton)findViewById(R.id.radioButton);

        Button submit = (Button)findViewById(R.id.button8);

        drawView = (FreehandView)findViewById(R.id.freehand);

        drawView.setVisibility(View.INVISIBLE);
        textView = (EditText)findViewById(R.id.textView5);


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
                drawView.invalidate();
                textColor = colors[i];
                drawView.setColor(textColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomize.setText(getRandomPrompt());
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                JournalEntry entry;
                Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
//                if(type.isChecked()) {
//                    entry = new JournalEntry((String)type.getText(), LocalDateTime.now());
//                    try {
//                        BufferedWriter bw = new BufferedWriter(new FileWriter(entry.filename));
//                        bw.write(entry.text);
//                        bw.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
                Intent intent = new Intent(PromptEntry.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public String getRandomPrompt() {
        String[] prompts = getResources().getStringArray(R.array.prompts);
        int randomNumber = new Random().nextInt(prompts.length);
        return prompts[randomNumber];
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if(view.getId() == R.id.radioButton2 && checked) {
            drawView.setVisibility(View.VISIBLE);
            drawView.setEnabled(true);
            textView.setEnabled(false);
            textView.setVisibility(View.INVISIBLE);
        }

        if(view.getId() == R.id.radioButton && checked) {
            drawView.setVisibility(View.INVISIBLE);
            drawView.setEnabled(false);
            textView.setEnabled(true);
            textView.setVisibility(View.VISIBLE);
        }

        switch(view.getId()) {
            case R.id.radioButton:
                if(checked)
                    break;
            case R.id.radioButton2:
                if(checked)
                    break;
        }
    }
}
