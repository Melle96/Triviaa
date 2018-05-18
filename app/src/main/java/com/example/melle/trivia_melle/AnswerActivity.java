package com.example.melle.trivia_melle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class AnswerActivity extends AppCompatActivity {

    int t = 43;
    int k = 42;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
    }


    public void clicked(View view) {

        EditText editText = findViewById(R.id.editText);
        String answer = String.valueOf(editText.getText());

        try {
            int ans = Integer.parseInt(answer);
            if (t + k == ans) {
                score = score + 1;
            }
            TextView textView3 = findViewById(R.id.textView3);
            String scoree = Integer.toString(score);
            textView3.setText(scoree);
        } catch (NumberFormatException e) {

        }
        editText.setText("");
        Random rand = new Random();
        t = rand.nextInt(50) + 1;

        Random random = new Random();
        k = random.nextInt(50) + 1;
        TextView textView = findViewById(R.id.textView2);
        String k2 = Integer.toString(k);
        String t2 = Integer.toString(t);
        textView.setText(k2 + " + " + t2);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("t", (int) t);
        outState.putInt("k", (int) k);
        outState.putInt("score", (int) score);
    }

    // zet teksten goed bij rotatie
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        t = savedInstanceState.getInt(("t"));
        k = savedInstanceState.getInt(("k"));
        score = savedInstanceState.getInt(("score"));

        TextView textView = findViewById(R.id.textView2);
        String k2 = Integer.toString(k);
        String t2 = Integer.toString(t);
        textView.setText(k2 + " + " + t2);

        TextView textView3 = findViewById(R.id.textView3);
        String scoree = Integer.toString(score);
        textView3.setText(scoree);
    }

}
