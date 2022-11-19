package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener completionListener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMedia();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "तू कठे जाई र्यायना ?", R.raw.where_are_you_going));
        words.add(new Word("What is your name?","तून नाव काय शे ?", R.raw.whatisyour_name));
        words.add(new Word("My name is...", "मन नाव .. शे", R.raw.my_name_is));
        words.add(new Word("How are you feeling?", "तुले कसं वाटी रायन ?", R.raw.how_are_you_feeling));
        words.add(new Word("I’m feeling good.","माले चांगल वाटी रायन ", R.raw.iamfeelingwel));
        words.add(new Word("Are you coming?", "तू येई रायना का ?", R.raw.are_you_coming));
        words.add(new Word("Yes, I’m coming.", "हा , मी येई रायनू ", R.raw.yesiamcoming));
        words.add(new Word("Let’s go.","चाल मग जाऊत  ", R.raw.lets_go));
        words.add(new Word("Come here.", "इकडे ये ",R.raw.come_here));
        words.add(new Word("Do you like Ahirani ?", "तुले अहिराणी पटस का ?", R.raw.do_you_like_ahirani));
        WordAddapter wordAddapter = new WordAddapter(this,words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(wordAddapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMedia();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getSoundResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
            }
        });


    }
    private void releaseMedia()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}