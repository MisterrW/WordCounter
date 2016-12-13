package com.example.user.wordcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class CounterActivity extends AppCompatActivity {
    EditText inputString;
    Button submitButton;
    TextView resultsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputString = (EditText)findViewById(R.id.input_string);
        submitButton = (Button)findViewById(R.id.get_answer);
        resultsText = (TextView)findViewById(R.id.results_text);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordCounter wordCounter = new WordCounter();
                String input = inputString.getText().toString();
                String result = wordCounter.getCountAsSortedString(input);
                resultsText.setText(result);
            }
        });
    }

}
