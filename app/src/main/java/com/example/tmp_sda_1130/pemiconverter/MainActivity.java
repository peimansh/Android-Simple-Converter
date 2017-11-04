package com.example.tmp_sda_1130.pemiconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private ArrayAdapter adapter2;
    private ConvertController controller;
    private Spinner spinner ;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View myView = getLayoutInflater().inflate(android.R.layout.simple_spinner_item,  null);

        controller = new ConvertController();
        //Log.i("hello",Integer.toString(R.id.convsel));
        spinner = (Spinner)findViewById(R.id.from);
        //spinner = (Spinner)myView.findViewById(R.id.convsel);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, controller.getAll1());
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner2 = (Spinner)findViewById(R.id.to);
        adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, controller.getAll2());
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);
    }


    public void Convert(View view) {

        EditText editText1 = (EditText)findViewById(R.id.meter);
        EditText editText2 = (EditText)findViewById(R.id.feet);
        String temp1 = editText1.getText().toString();
        int v1 = spinner.getSelectedItemPosition();
        int v2 = spinner2.getSelectedItemPosition();
        String value1 = (String) spinner.getItemAtPosition(v1);
        String value2 = (String) spinner2.getItemAtPosition(v2);
        double tmp = Double.parseDouble(temp1);
        double feet = tmp*(3.28084);
        double inch = feet*12;
        double yard = feet/3;
        double mile = feet/5280;
        try {
            if (value1.equals("Meter") && value2.equals("Feet")) {
                editText2.setText(feet+" Feet");
            }
            else if (value1.equals("Meter") && value2.equals("Inch")) {
                editText2.setText(inch+" Inches");
            }
            else if (value1.equals("Meter") && value2.equals("Yard")) {
                editText2.setText(yard+" Yards");
            }
            else if (value1.equals("Meter") && value2.equals("Mile")) {
                editText2.setText(mile+" Miles");
            }
            else if (value1.equals("Centimeter") && value2.equals("Feet")) {
                editText2.setText(feet/100+" Feet");
            }
            else if (value1.equals("Centimeter") && value2.equals("Inch")) {
                editText2.setText(inch/100+" Inches");
            }
            else if (value1.equals("Centimeter") && value2.equals("Yard")) {
                editText2.setText(yard/100+" Yards");
            }
            else if (value1.equals("Centimeter") && value2.equals("Mile")) {
                editText2.setText(mile/100+" Miles");
            }
            else if (value1.equals("Kilometer") && value2.equals("Feet")) {
                editText2.setText(feet*1000 + " Feet");
            }
            else if (value1.equals("Kilometer") && value2.equals("Inch")) {
                editText2.setText(inch *1000 + " Inches");
            }
            else if (value1.equals("Kilometer") && value2.equals("Yard")) {
                editText2.setText(yard* 1000 + " Yards");
            }
            else if (value1.equals("Kilometer") && value2.equals("Mile")) {
                editText2.setText(mile * 1000 + " Miles");
            }
        }
        catch (NumberFormatException ex) {
            Toast t1 = Toast.makeText(this, "You should enter a number" ,Toast.LENGTH_LONG);
            t1.setGravity(Gravity.TOP| Gravity.RIGHT, 25, 200);
            t1.show();
            editText2.setText("0");
            return;
        }

    }






}
