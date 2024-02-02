package com.example.cs408lab2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
                    Log.i(TAG, "Convert F -> C");
                    float F = Float.parseFloat(fText.getText().toString());
                    Log.d(TAG, "F: " + F);
                    Float conversion = ((F - 32) * 5)/9;
                    cText.setText(conversion.toString());
                }
                else if(fempty && !cempty) { //F empty, C given ; Convert: F<-C
                    Log.i(TAG, "Convert F <- C");
                    float C = Float.parseFloat(cText.getText().toString());
                    Float conversion = (C * (float)1.8) + 32;
                    fText.setText(conversion.toString());
                }

            }
        });
    }
}