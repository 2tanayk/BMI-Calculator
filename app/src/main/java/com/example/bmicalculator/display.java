package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
         Intent in=getIntent();
        // bmi obj=new bmi();

        Bundle extras=in.getExtras();
        String name="";
        if(extras!=null)
        {
            name=extras.getString("str2");
           // result=extras.getString("str");
        }
        Bundle extras2=in.getExtras();
        String result="";
        if(extras2!=null)
        {
            result=extras2.getString("str");
        }
        Bundle extras3=getIntent().getExtras();
        double BMI=extras3.getDouble("d");
        DecimalFormat df=new DecimalFormat("#.###");
       //double BMI= System.out.format(""+iBMI,)
      /*  if(extras3!=null)
        {
            BMI=Double.parseDouble(extras3.getString("str3"));
        }*/

        TextView displayTextView=findViewById(R.id.displayTextView);
        displayTextView.setText(name+" Your BMI is: "+df.format(BMI)+"\r\n\r\n"+result);

    }
    public void goBack(View view){
        Intent intent=new Intent(this,bmi.class);
        startActivity(intent);
        finish();
    }
}
