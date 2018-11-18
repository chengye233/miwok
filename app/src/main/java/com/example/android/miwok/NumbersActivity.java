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
        words.add(new Word("one", "lutti", R.mipmap.ic_launcher));
        words.add(new Word("two", "otiiko", R.mipmap.ic_launcher));
        words.add(new Word("three", "tolookosu", R.mipmap.ic_launcher));
        words.add(new Word("four", "oyyisa", R.mipmap.ic_launcher));
        words.add(new Word("five", "massokka", R.mipmap.ic_launcher));
        words.add(new Word("six", "temmokka", R.mipmap.ic_launcher));
        words.add(new Word("seven", "kenekaku", R.mipmap.ic_launcher));
        words.add(new Word("eight", "kawinta", R.mipmap.ic_launcher));
        words.add(new Word("nine", "wo'e", R.mipmap.ic_launcher));
        words.add(new Word("ten", "na'aacha", R.mipmap.ic_launcher));

        // 使用WordAdapter
        WordAdapter wordAdapter = new WordAdapter(this, R.layout.list_item, words);

        // 构造好的视图放入NumbersActivity的ListView
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }
}
