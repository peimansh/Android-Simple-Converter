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
    private ConvertController controller;
    private Spinner spinner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View myView = getLayoutInflater().inflate(android.R.layout.simple_spinner_item,  null);

        controller = new ConvertController();
        //Log.i("hello",Integer.toString(R.id.convsel));
        spinner = (Spinner)findViewById(R.id.convsel);
        //spinner = (Spinner)myView.findViewById(R.id.convsel);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, controller.getAll());
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }


    public void Convert(View view) {

        EditText editText1 = (EditText)findViewById(R.id.meter);
        EditText editText2 = (EditText)findViewById(R.id.feet);
        String temp1 = editText1.getText().toString();
        int v = spinner.getSelectedItemPosition();
        String value = (String) spinner.getItemAtPosition(v);
        double tmp = Double.parseDouble(temp1);
        double feet = tmp*(3.28084);
        double inch = feet*12;
        double yard = feet/3;

        try {
            if (value.equals("Convert from Meter to Feet")) {
                editText2.setText(feet+" Feet");
            }
            else if (value.equals("Convert from Meter to Inch")) {
                editText2.setText(inch+" Inch");
            }
            else if (value.equals("Convert from Meter to Yard")) {
                editText2.setText(yard+" Yard");
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
