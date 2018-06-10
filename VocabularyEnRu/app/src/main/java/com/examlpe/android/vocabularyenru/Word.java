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
    private int mImageResourceId;


    public Word(String mRuWord, String mEnWord) {
        this.mRuWord = mRuWord;
        this.mEnWord = mEnWord;
    }

    /**
     * @param mRuWord russian word
     * @param mEnWord english word
     * @param mImageResourceId resource id of correspondent image*/
    public Word(String mRuWord, String mEnWord, int mImageResourceId){
        this.mRuWord = mRuWord;
        this.mEnWord = mEnWord;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmRuWord() {
        return mRuWord;
    }

    public String getmEnWord() {
        return mEnWord;
    }

    public int getmImageResourceId() { return  mImageResourceId; }
}
