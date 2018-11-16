package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity
{

    /**
     * 构造器 MainActivity点击时构造
     *
     * @param savedInstanceState 默认
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //默认
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // 数据WordList
        List<Word> words = new ArrayList<>();
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo'e"));
        words.add(new Word("ten", "na'aacha"));

        // 使用WordAdapter
        WordAdapter wordAdapter = new WordAdapter(this, R.layout.list_item, words);

        // 构造好的视图放入NumbersActivity的ListView
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }
}
