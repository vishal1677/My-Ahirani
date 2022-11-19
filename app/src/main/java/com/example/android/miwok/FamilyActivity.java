package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "बाप ", R.drawable.family_father, R.raw.father));
        words.add(new Word("Mother", "माय ", R.drawable.family_mother, R.raw.mother));
        words.add(new Word("Son", "पोरगा ", R.drawable.family_son, R.raw.son));
        words.add(new Word("Daughter", "पोर ", R.drawable.family_daughter, R.raw.daughter));
        words.add(new Word("Brother", "भाऊ ", R.drawable.family_younger_brother, R.raw.brother));
        words.add(new Word("Sister", "बहीण  ", R.drawable.family_younger_sister, R.raw.song2sister));
        words.add(new Word("Uncle", "चुलता ", R.drawable.family_older_brother, R.raw.song2uncle));
        words.add(new Word("Aunty", "चुलती ", R.drawable.family_older_sister, R.raw.song2aunty));
        words.add(new Word("Grandmother", "माळी", R.drawable.family_grandmother, R.raw.grandmother));
        words.add(new Word("Grandfather", "जिबो", R.drawable.family_grandfather, R.raw.grandfather));
        WordAddapter wordAddapter = new WordAddapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(wordAddapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaplayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getSoundResourceId());
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

