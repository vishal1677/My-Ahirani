package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAddapter extends ArrayAdapter<Word>
{

    int mColorResourceId;
    int mSoundResourceId;
     public WordAddapter(Activity context, ArrayList<Word> wordAddapters,int ColorResourseId )
     {
        super(context,0,wordAddapters);
        mColorResourceId=ColorResourseId;
     }
     public WordAddapter(Activity context, ArrayList<Word> wordAddapters, int ColorResourceId, int SoundResourceId)
     {
         super(context, 0, wordAddapters);
         mSoundResourceId=SoundResourceId;
     }

     public View getView(int position, View convertView, ViewGroup parent)
     {
         View listItemview = convertView;
         if(listItemview == null)
         {
             listItemview=LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
         }

        Word currentword = getItem(position);
        TextView defaultTextview = (TextView) listItemview.findViewById(R.id.dafault_text_view);
        defaultTextview.setText(currentword.getDefault_translation());


        TextView ahiraniTextview = (TextView) listItemview.findViewById(R.id.ahirani_text_view);
        ahiraniTextview.setText(currentword.getAhirani_translation());

         ImageView imageView = (ImageView) listItemview.findViewById(R.id.image_demo);
          if( currentword.hasImage() ) {

              imageView.setImageResource(currentword.getImageResourceId());
              imageView.setVisibility(View.VISIBLE);
          }
          else
          {
              imageView.setVisibility(View.GONE);
          }
          LinearLayout textContainer=(LinearLayout) listItemview.findViewById(R.id.text_container);
          int color= ContextCompat.getColor(getContext(), mColorResourceId);
          textContainer.setBackgroundColor(color);


        return  listItemview;
     }

}
