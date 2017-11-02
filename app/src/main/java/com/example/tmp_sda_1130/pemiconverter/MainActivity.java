package com.example.tmp_sda_1130.pemiconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Convert(View view) {

        EditText editText1 = (EditText)findViewById(R.id.meter);
        String temp = editText1.getText().toString();
        double temp1 = Double.parseDouble(editText1.getText().toString());

        double feet = temp1*(3.28084);
        double inch = feet*12;
        double yard = feet/3;
        EditText editText2 = (EditText)findViewById(R.id.feet);
        editText2.setText(feet+" Feet. Done !");
        EditText editText3 = (EditText)findViewById(R.id.inch);
        editText3.setText(inch+" Inches. Done !");
        EditText editText4 = (EditText)findViewById(R.id.yard);
        editText4.setText(yard+" Yards. Done !");
        Toast toastfeet = Toast.makeText(this,String.valueOf(feet)+ " feet , conversion done !",Toast.LENGTH_SHORT);
        toastfeet.setGravity(Gravity.TOP| Gravity.RIGHT, 25, 200);
        toastfeet.show();

    }

    public void ShowST(View view) {
        Toast toastST = Toast.makeText(this,"Hello EveryOne !", Toast.LENGTH_LONG);
        toastST.show();

    }
}
