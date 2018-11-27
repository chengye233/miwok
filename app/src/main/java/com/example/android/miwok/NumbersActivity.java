package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    /**
     * 音频管理
     */
    private AudioManager mAudioManager;

    /**
     * Audio Focus回调监听器
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    // 短时间失去 Audio Focus
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // 暂停并且下次从头播放
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);

                    } // 重新获得 Audio Focus
                    else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // 播放
                        mMediaPlayer.start();

                    } // 失去 Audio Focus
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // 释放发音资源
                        releaseMediaPlayer();
                    }
                }
            };

    /**
     * 音频播放器 播放Miwok读音
     */
    private MediaPlayer mMediaPlayer;

    /**
     * 异步回调 释放MediaPlayer资源
     */
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    /**
     * 构造器 MainActivity点击时构造
     *
     * @param savedInstanceState 默认
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 默认
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // 初始化 mAudioManager
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // 数据WordList final用于匿名内部类
        final List<Word> words = new ArrayList<>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        // 使用WordAdapter
        WordAdapter wordAdapter = new WordAdapter(this, R.layout.list_item, words, R.color.category_numbers);

        // 构造好的视图放入NumbersActivity的ListView
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        // 设置发音
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = words.get(position);
                // 有发音的音频时
                if (currentWord.hasSong()) {
                    // 播放前也释放资源
                    releaseMediaPlayer();

                    // Request audio focus for playback
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // 音频长度 很短
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    // 播放发音
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // Start playback
                        mMediaPlayer = MediaPlayer.create(NumbersActivity.this, currentWord.getSongResourceId());
                        mMediaPlayer.start();

                        // 播放完成后异步回调 释放MediaPlayer资源
                        mMediaPlayer.setOnCompletionListener(onCompletionListener);

                    }
                }
            }
        });

    }

    /**
     * 后台时也要清空发音资源
     */
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
