package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class bmi extends AppCompatActivity {
        //implements AdapterView.OnItemSelectedListener
    EditText nameEditText,weightEditText,heightEditText;
    Spinner spinnerWeight,spinnerHeight;
    ArrayAdapter<CharSequence> adapterW;
    ArrayAdapter<CharSequence> adapterH;
    //String itemsW[]={"in kg","in lbs"};
   // String itemsH[]={"in m","in cm","in feet and inches","in inches"};
    int unitW,unitH;
   public String name,result;
    double weight,height;
public double BMI;
    public void getBMI(View view)
    {
        try {
            name=nameEditText.getText().toString();
            weight=Double.parseDouble(weightEditText.getText().toString());
            height=Double.parseDouble(heightEditText.getText().toString());


        if(unitW==0 && unitH==0  || unitW==0 && unitH==1)
        {
            if(unitH==1)
                height/=100;
            BMI=(weight)/(height*height);

            getResult();
           switchLayout();

        }
        else
            if(unitW==1 && unitH==2)
            {
                BMI=703*(weight)/(height*height);
                getResult();
               switchLayout();
            }
            else
            {
                Toast.makeText(this,"Invalid format!",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"One or more fields is/are empty/has been entered wrongly!",Toast.LENGTH_SHORT).show();
        }//catch ends



    }//getBMI ends

    public void getResult()
    {
        if(BMI>=30) {
            result = name + " you are Obese!";
        }
        else
        if(BMI>=25) {
            result = name + " you are Overweight!";
        }
        else
        if(BMI>=18.5) {
            result = name + " you are Normal!! :)";
        }
        else
        {
            result=name+ " you are Underweight!";
        }
    }//getResult ends

   public  void switchLayout()
    {
        Intent i=new Intent(this,display.class);
        Bundle b=new Bundle();
        b.putDouble("d",BMI);
        i.putExtras(b);
        i.putExtra("str",result);
        i.putExtra("str2",name);
        //i.putExtra("str3",BMI);
        startActivity(i);
        finish();
    }//switchLayout ends

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Intent i=getIntent();

        nameEditText=(EditText)findViewById(R.id.nameEditText);
        weightEditText=(EditText)findViewById(R.id.weightEditText);
        heightEditText=(EditText)findViewById(R.id.heightEditText);

       spinnerWeight=(Spinner)findViewById(R.id.spinnerWeight);
       spinnerHeight=(Spinner)findViewById(R.id.spinnerHeight);

         //itemsW
         //itemsH={"in m","in cm","in feet and inches","in inches"};

         adapterW=ArrayAdapter.createFromResource(this,R.array.Weight,android.R.layout.simple_spinner_item);
         adapterH=ArrayAdapter.createFromResource(this,R.array.Height,android.R.layout.simple_spinner_item);

        adapterW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerWeight.setAdapter(adapterW);
        spinnerHeight.setAdapter(adapterH);

        //spinnerWeight.setOnItemSelectedListener(this);
        //spinnerHeight.setOnItemSelectedListener(this);

       /* spinnerWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        spinnerWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unitW=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerHeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unitH=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }//onCreate ends

  /*  @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(),position+"",Toast.LENGTH_SHORT).show();
         unit=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/


}//class ends
