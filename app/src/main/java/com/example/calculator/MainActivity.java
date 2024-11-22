package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Integer firstNumber, secondNumber;
    boolean isOperationClick;
    String currentOperation;
    Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        result = findViewById(R.id.tv_result);
    }

    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperationClick) {
                result.setText("");
            }
            result.append(text);
        }
        isOperationClick = false;

    }

    public void operationClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            result.setText("");
        } else {
            if (view.getId() == R.id.btn_plus) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "+";
            } else if (view.getId() == R.id.btn_minus) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "-";
            } else if (view.getId() == R.id.btn_divide) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "/";
            } else if (view.getId() == R.id.btn_multiply) {
                firstNumber = Integer.valueOf(result.getText().toString());
                currentOperation = "*";
            } else if (view.getId() == R.id.btn_equal) {
                secondNumber = Integer.valueOf(result.getText().toString());
                result.setText(String.valueOf(result(firstNumber, secondNumber, currentOperation)));
                int sum = result(firstNumber, secondNumber, currentOperation);
            }
            isOperationClick = true;
        }
    }

    private int result(int firstNumber, int secondNumber, String currentOperation) {
        switch (currentOperation) {
            case "+":
                return firstNumber + secondNumber;

            case "-":
                return firstNumber - secondNumber;

            case "/":
                return firstNumber / secondNumber;

            case "*":
                return firstNumber * secondNumber;

            default:
                return 0;


        }
    }
}


