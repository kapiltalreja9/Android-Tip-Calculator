package com.kapil.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputText = findViewById(R.id.inputText);
        TextView labelText = findViewById(R.id.labelText);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        // Create one listener for all buttons
        View.OnClickListener listener = v -> {
            Button clickedButton = (Button) v; // Cast view to Button
            String userInput = inputText.getText().toString();
            try {
                String percentageVal = (String) clickedButton.getText();
                double number = Double.parseDouble(userInput);
                double tipPercentage = Double.parseDouble(clickedButton.getTag().toString());
                double tipAmount = number * tipPercentage / 100;
                double total = number + tipAmount;
                labelText.setText(String.format("Tip: %s, Total Bill: %.2f", percentageVal, total));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
            }
        };

        // Attach listener to all buttons
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
    }
}
