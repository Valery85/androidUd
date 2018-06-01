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

    public Word(String mRuWord, String mEnWord) {
        this.mRuWord = mRuWord;
        this.mEnWord = mEnWord;
    }

    public String getmRuWord() {
        return mRuWord;
    }

    public String getmEnWord() {
        return mEnWord;
    }
}
