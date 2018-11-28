package com.example.mahbub.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    private Button backButton,clearButton;
    private EditText historyDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyDetails = findViewById(R.id.historyDetails);
        //historyDetails.setInputType(InputType.TYPE_NULL);

        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(this);

        clearButton = findViewById(R.id.historyClear);
        clearButton.setOnClickListener(this);

        readFile();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.historyClear){
            writeToFile();
        }
    }

    public void readFile(){
        try {
            FileInputStream  reader = openFileInput("history.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(reader);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String lines;
            StringBuffer stringBuffer = new StringBuffer();

            while ( (lines = bufferedReader.readLine())!=null){
                stringBuffer.append(lines+'\n');
            }
            historyDetails.setText(stringBuffer.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(){
        try {
            FileOutputStream writer = openFileOutput("history.txt",Context.MODE_PRIVATE);
            String fileData="";
            try {
                writer.write(fileData.getBytes());
                writer.close();
                Toast.makeText(HistoryActivity.this,"History Cleared",Toast.LENGTH_SHORT).show();
                readFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
