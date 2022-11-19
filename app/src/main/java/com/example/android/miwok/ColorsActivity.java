package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaplayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "लाल ", R.drawable.color_red, R.raw.red));
        words.add(new Word("White","धव्या   ", R.drawable.color_white, R.raw.white));
        words.add(new Word("Black", "काया ", R.drawable.color_black, R.raw.black));
        words.add(new Word("Yellow", "पिाव्या  ", R.drawable.color_mustard_yellow, R.raw.yellow));
        words.add(new Word("Green","हिरवा", R.drawable.color_green, R.raw.green));
        words.add(new Word("Brown", "तपकिरी    ", R.drawable.color_brown,R.raw.brown ));
        words.add(new Word("Gray", "मटक्या  ", R.drawable.color_gray, R.raw.gray));
        words.add(new Word("Mustered yellow","फिकट पिव्या   ", R.drawable.color_dusty_yellow, R.raw.musteredyellow));
        WordAddapter wordAddapter = new WordAddapter(this,words, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(wordAddapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word= words.get(i);
                releaseMediaplayer();
                mediaPlayer= MediaPlayer.create(ColorsActivity.this, word.getSoundResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
            }
        });

    }
    private void releaseMediaplayer()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}