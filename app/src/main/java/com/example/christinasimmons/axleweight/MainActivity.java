package com.example.christinasimmons.axleweight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


import org.w3c.dom.Text;

import java.io.Console;
import java.util.EventListener;
import java.util.EventObject;

import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {

    public static final String Display = "AxleWeight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.axleWeight);
        Button btn1 = findViewById(R.id.axleGroupWeight);



btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        EditText usrInput = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);

        double Total = 0.0;
        int factor = 0;
        int weight = Integer.parseInt(usrInput.getText().toString());

//        if (weight >= 1000)
//        {
//            Total = (1000 * .04);
//            factor = 1;
//            if (weight > 2000)
//            {
//                Total += (1000 * .06);
//                factor = 2;
//            }
//            Total += ((weight - (1000 * factor)) * .10);
//            textView.setText(Total + "");
//
//        }


        //first case = weight < 1000
        //2nd case = weight > 1000
        //3rd case = weight > 2000

        double firstTotal = 0.0;
        double secondTotal = 0.0;

        //handles 1st case < 1000
        if (weight < 1000) {
            Total = (weight * 0.02);
        }
        //handles 2nd case > 1000
        else if (weight >= 1000){
            firstTotal = (weight - 1000);
            Total = (1000 * .02);
        }
        if (firstTotal > 1000){
            secondTotal = (firstTotal - 1000);
            Total += (1000 * .04);
        }
        else if(firstTotal < 1000){
            Total += (firstTotal * .06);
        }
        if(secondTotal > 0) {
            Total += (secondTotal * .06);
        }

        textView.setText("$" + Total);

    }

});
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usrInput = findViewById(R.id.editText);
                TextView textView = findViewById(R.id.textView);

                double Total = 0.0;
                double firstTotal = 0.0;
                double secondTotal = 0.0;

                int weight = Integer.parseInt(usrInput.getText().toString());

                if (weight < 2000) {
                    Total = (weight * 0.02);
                }
                else if (weight >= 2000){
                    firstTotal = (weight - 2000);
                    Total = (2000 * .02);
                }
                if (firstTotal >= 3000){
                    secondTotal = (firstTotal - 3000);
                    Total += (3000 * .04);
                }
                else if(firstTotal < 3000){
                    Total += (firstTotal * .04);
                }
                if(secondTotal > 0) {
                Total += (secondTotal * .10);
                }
                textView.setText("$" + Total);

            }});



        Button clearBtn = findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText usrInput = findViewById(R.id.editText);
                TextView textView = findViewById(R.id.textView);
                //Clear EditText
                usrInput.getText().clear();
                textView.setText("Total");
            }
        });
        }

    }



