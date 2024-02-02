package com.example.cs408lab2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cs408lab2b.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText fText = binding.fText;
                EditText cText = binding.cText;

                boolean fempty = fText.getText().toString().isEmpty();
                boolean cempty = cText.getText().toString().isEmpty();

                if(!fempty) { //F given (Default) ; Convert: F->C
                    float F = Float.parseFloat(fText.getText().toString());
                    float conversion = (F - 32) * (5/9);
                    cText.setText(String.valueOf(conversion));
                }
                else if(fempty && !cempty) { //F empty, C given ; Convert: F<-C
                    float C = Float.parseFloat(cText.getText().toString());
                    float conversion = (C * (9/5)) + 32;
                    fText.setText(String.valueOf(conversion));
                }

            }
        });
    }
}