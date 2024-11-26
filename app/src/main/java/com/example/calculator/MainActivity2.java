package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View viewHeart = findViewById(R.id.v_heart);

        viewHeart.setOnClickListener(v -> {
            if (viewHeart.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.heart).getConstantState())) {
                viewHeart.setBackgroundResource(R.drawable.heart2);
            } else {
                viewHeart.setBackgroundResource(R.drawable.heart);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.dropdown_items, // Массив элементов из res/values/strings.xml
                android.R.layout.simple_spinner_item // Макет для отображения элементов
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Макет для выпадающего списка

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;

                    if (position == 0) {
                        textView.setText("   Type");
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });




    }
}
