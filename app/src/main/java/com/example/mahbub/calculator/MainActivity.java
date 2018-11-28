package com.example.mahbub.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText number1, number2;
    private Button addButton, subButton, mulButton, divButton, history;
    private Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,buttonZero,buttonEqual,buttonClear;
    private TextView result,operator;
    private double value1,value2,sum;
    private String flag;
    private boolean starting=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.resultView);
        operator = findViewById(R.id.operator);

        number1 = findViewById(R.id.number1);
        number1.setInputType(InputType.TYPE_NULL);
        number2 = findViewById(R.id.number2);
        number2.setInputType(InputType.TYPE_NULL);

        addButton = findViewById(R.id.addButton);
        subButton = findViewById(R.id.subButton);
        mulButton = findViewById(R.id.multiplyButton);
        divButton = findViewById(R.id.divButton);
        history = findViewById(R.id.history);

        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonZero = findViewById(R.id.buttonZero);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonClear = findViewById(R.id.buttonClear);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonClear.setOnClickListener(this);


        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            if(starting == true){
                if(v.getId()==R.id.buttonOne){
                    result.setText(result.getText()+""+buttonOne.getText());
                }
                if(v.getId() == R.id.buttonTwo){
                    result.setText(result.getText()+""+ buttonTwo.getText());
                }
                if(v.getId() == R.id.buttonThree){
                    result.setText(result.getText()+""+ buttonThree.getText());
                }
                if(v.getId() == R.id.buttonFour){
                    result.setText(result.getText()+""+ buttonFour.getText());
                }
                if(v.getId() == R.id.buttonFive){
                    result.setText(result.getText()+""+ buttonFive.getText());
                }
                if(v.getId() == R.id.buttonSix){
                    result.setText(result.getText()+""+ buttonSix.getText());
                }
                if(v.getId() == R.id.buttonSeven){
                    result.setText(result.getText()+""+ buttonSeven.getText());
                }
                if(v.getId() == R.id.buttonEight){
                    result.setText(result.getText()+""+ buttonEight.getText());
                }
                if(v.getId() == R.id.buttonNine){
                    result.setText(result.getText()+""+ buttonNine.getText());
                }
                if(v.getId() == R.id.buttonZero){
                    result.setText(result.getText()+""+ buttonZero.getText());
                }
                if(v.getId() == R.id.buttonClear){
                    result.setText("");
                    number1.setText("");
                    number2.setText("");
                    operator.setText("");
                }
                if(v.getId() == R.id.history){
                    Intent intent = new Intent(this,HistoryActivity.class);
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this,"History",Toast.LENGTH_SHORT).show();
                }

                if(v.getId() == R.id.addButton){
                    value1 = Double.parseDouble((String) result.getText());
                    result.setText("");
                    number1.setText(String.valueOf(value1));
                    flag="add";
                    operator.setText("+");
                }
                if(v.getId() == R.id.subButton){
                    value1 = Double.parseDouble((String) result.getText());
                    result.setText("");
                    number1.setText(String.valueOf(value1));
                    flag="sub";
                    operator.setText("-");
                }
                if(v.getId() == R.id.multiplyButton){
                    value1 = Double.parseDouble((String) result.getText());
                    result.setText("");
                    number1.setText(String.valueOf(value1));
                    flag="mul";
                    operator.setText("*");
                }
                if(v.getId() == R.id.divButton){
                    value1 = Double.parseDouble((String) result.getText());
                    result.setText("");
                    number1.setText(String.valueOf(value1));
                    flag="div";
                    operator.setText("/");
                }
                if(v.getId()==R.id.buttonEqual){
                    value2 = Double.parseDouble((String) result.getText());
                    if(flag == "add"){
                        sum = value1 + value2;
                        String fileData = "Adding "+ value1 +" with "+value2+"  is "+sum+"\n";
                        writeToFile(fileData);
                    }
                    if(flag=="sub"){
                        sum = value1 - value2;
                        String fileData = "Subtracting  "+ value2 +" From "+value1+"  is "+sum+"\n";
                        writeToFile(fileData);
                    }
                    if(flag=="mul"){
                        sum = value1 * value2;
                        String fileData = "Multiplying "+ value1 +" with "+value2+"  is: "+sum+"\n";
                        writeToFile(fileData);
                    }
                    if(flag=="div"){
                        try{
                            sum = value1 / value2;
                            String fileData = "Dividing  "+ value1 +" by "+value2+"  is: "+sum+"\n";
                            writeToFile(fileData);
                        }catch(Exception e){
                            //sum = 0;
                            //Toast.makeText(MainActivity.this,"Infinity",Toast.LENGTH_SHORT).show();
                        }
                    }
                    number2.setText(String.valueOf(value2));
                    result.setText(""+ sum);
                    flag="";
                    starting = false;
                }

            }else{
                result.setText("");
                number1.setText("");
                number2.setText("");
                operator.setText("");
                starting= true;
            }

        }catch (Exception e){
            //result.setText("Input a number");
            Toast.makeText(MainActivity.this,"Please Enter Numbers",Toast.LENGTH_SHORT).show();
        }
    }

    public void writeToFile(String fileData){
        try {
            FileOutputStream writer = openFileOutput("history.txt",Context.MODE_APPEND | MODE_PRIVATE);
            try {
                writer.write(fileData.getBytes());
                writer.close();
                Toast.makeText(MainActivity.this,"History Added",Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
