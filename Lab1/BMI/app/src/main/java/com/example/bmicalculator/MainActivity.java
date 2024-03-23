package com.example.bmicalculator;

import static java.util.Objects.nonNull;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonBMIresult;
    private TextView userMass;
    private TextView userHeight;
    private TextView userBMIresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonBMIresult = (Button) findViewById(R.id.buttonBMI);
        buttonBMIresult.setOnClickListener(summitButtonListener);
        userMass = (TextView) findViewById(R.id.massNumber);
        userHeight = (TextView) findViewById(R.id.heightNumber);
        userBMIresult = (TextView) findViewById(R.id.BMIresult);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private final View.OnClickListener summitButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer userHeight = getInteger(MainActivity.this.userHeight);
            Integer userMass = getInteger(MainActivity.this.userMass);
            if (nonNull(userMass) && nonNull(userHeight)) {
                calculateBMI(userHeight, userMass);
            }
        }
    };

    private void calculateBMI(Integer userHeightCm, Integer userMass) {
        double userHeightMeters = userHeightCm / 100.0;
        double userHeightMetersSquare = Math.pow(userHeightMeters, 2);
        double bmiValue = userMass / userHeightMetersSquare;
        DecimalFormat df = new DecimalFormat("#.#");
        String bmiValueString = df.format(bmiValue);
        userBMIresult.setText(bmiValueString);
    }
    private Integer getInteger(TextView textView) {
        try {
            return Integer.valueOf(textView.getText().toString());
        } catch (Exception e) {
            return null;
        }
    }
}