package com.example.android.miwok;

public class Word
{
    private String mdefault_translation;
    private String mahirani_translation;
    private int mSoundResourceId=-1;
    private int mImageResourceId=IMAGE_NOT_PROVIDED;
    private static final int IMAGE_NOT_PROVIDED=-1;
    Word(String default_translation, String ahirani_translation, int SoundResourceId)
    {
        mdefault_translation=default_translation;
        mahirani_translation=ahirani_translation;
        mSoundResourceId=SoundResourceId;
    }
    Word(String  default_translation,String ahirani_translation, int ImageResourceId , int SoundResourceId )
    {
        mdefault_translation=default_translation;
        mahirani_translation=ahirani_translation;
        mImageResourceId=ImageResourceId;
        mSoundResourceId=SoundResourceId;
    }

    public String getDefault_translation()
    {
        return mdefault_translation;
    }
    public String getAhirani_translation()
    {
       return mahirani_translation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage()
    {
        return mImageResourceId != IMAGE_NOT_PROVIDED;
    }

    public int getSoundResourceId(){ return mSoundResourceId;}
    public boolean hasSound(){ return  mImageResourceId != -1; }
}
