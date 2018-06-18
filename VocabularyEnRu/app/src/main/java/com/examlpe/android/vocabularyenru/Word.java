package com.examlpe.android.vocabularyenru;

/*
* Word class represent russian word that user want to learn
 * it contains russian word and english translation
* */


public class Word {
    /*Default translation*/
    private String mRuWord;
    /*English translation*/
    private String mEnWord;
    /** For store image id*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /** Constant that shows that no image was provided for this word*/
    private static final int NO_IMAGE_PROVIDED = -1;
    /** To store correspondent sound file id */
    private int mAudioResourceId;


    public Word(String mRuWord, String mEnWord, int mAudioResourceId) {
        this.mRuWord = mRuWord;
        this.mEnWord = mEnWord;
        this.mAudioResourceId = mAudioResourceId;
    }

    /**
     * @param mRuWord russian word
     * @param mEnWord english word
     * @param mImageResourceId resource id of correspondent image*/
    public Word(String mRuWord, String mEnWord, int mImageResourceId, int mAudioResourceId){
        this.mRuWord = mRuWord;
        this.mEnWord = mEnWord;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getmRuWord() {
        return mRuWord;
    }

    public String getmEnWord() {
        return mEnWord;
    }

    public int getmImageResourceId() { return  mImageResourceId; }

    public int getmAudioResourceId() { return  mAudioResourceId; }

    /** Return whether or not there is an image for this word*/
    public boolean hasImage() { return mImageResourceId != NO_IMAGE_PROVIDED; }
}
