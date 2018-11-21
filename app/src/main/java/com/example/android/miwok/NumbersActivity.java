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
        words.add(new Word("one", "lutti", R.drawable.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten));

        // 使用WordAdapter
        WordAdapter wordAdapter = new WordAdapter(this, R.layout.list_item, words, R.color.category_numbers);

        // 构造好的视图放入NumbersActivity的ListView
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }
}
