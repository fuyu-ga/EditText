package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private void method(int index){
        EditText editText1 = findViewById(R.id.EditText1);
        EditText editText2 = findViewById(R.id.EditText2);

        int a = Integer.parseInt(editText1.getText().toString());
        int b = Integer.parseInt(editText2.getText().toString());

        TextView answer = (TextView)findViewById(R.id.answer);
        int c = 0;

        try {
            switch (index) {
                case 0:
                    c = a + b;
                    break;

                case 1:
                    c= a - b;
                    break;

                case 2:
                    c = a * b;
                    break;

                case 3:
                    c= a / b;
                    break;

                default: //swich文のときはそれ以外が来た時を想定して書く必要がある
            }
        } catch (ArithmeticException e) {
            answer.setText("0では割り切れません");
            return;
        }
        answer.setText(String.valueOf(c));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pulas = findViewById(R.id.btn_pulas);
        pulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method(0);
            }
        });

        //引き算
        Button mainasu = findViewById(R.id.btn_mainas);
        mainasu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               method(1);
            }
        });

        Button multiplication = findViewById(R.id.btn_multiplication);
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method(2);
            }
        });

        Button division = findViewById(R.id.btn_division);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method(3);
            }
        });
    }
}