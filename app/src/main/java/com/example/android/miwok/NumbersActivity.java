package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mcompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word>words = new ArrayList<Word>();
        words.add(new Word("One", "एक ",R.drawable.number_one, R.raw.one));
        words.add(new Word("Two","दोन ",R.drawable.number_two, R.raw.two));
        words.add(new Word("Three", "तीन ",R.drawable.number_three, R.raw.three));
        words.add(new Word("Four", "चार ",R.drawable.number_four, R.raw.four));
        words.add(new Word("Five","पाच ", R.drawable.number_five, R.raw.five));
        words.add(new Word("Six", "सऊ  ",R.drawable.number_six, R.raw.six));
        words.add(new Word("Seven", "सात ", R.drawable.number_seven, R.raw.seven));
        words.add(new Word("Eight","आठ ", R.drawable.number_eight, R.raw.eight));
        words.add(new Word("Nine", "नऊ ", R.drawable.number_nine,R.raw.nine));
        words.add(new Word("Ten", "दहा ", R.drawable.number_ten,R.raw.ten));
        WordAddapter wordAddapter = new WordAddapter(this,words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(wordAddapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word= words.get(i);
                releaseMediaPlayer();
              mediaPlayer= MediaPlayer.create(NumbersActivity.this, word.getSoundResourceId());
              mediaPlayer.start();
              mediaPlayer.setOnCompletionListener(mcompletionListener);
            }

        });


    }

    private void releaseMediaPlayer()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}