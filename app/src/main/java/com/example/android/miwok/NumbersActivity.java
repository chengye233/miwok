package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an array of words
        List<String> words = new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        //rootView
        LinearLayout rootView = findViewById(R.id.rootView);
        TextView wordView = new TextView(this);

        //添加TextView
        for (int i = 0; i < 10; i++) {
            TextView textView = new TextView(this);
            textView.setText(words.get(i));
            rootView.addView(textView);
        }

    }
}
